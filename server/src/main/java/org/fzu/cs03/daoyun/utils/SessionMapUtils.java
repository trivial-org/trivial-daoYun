package org.fzu.cs03.daoyun.utils;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.LiteDeviceResolver;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Component
public class SessionMapUtils {

    private static Map<String, JSONObject> SessionMap = new HashMap<String,JSONObject>();

//    public boolean containSession(String userName, DeviceType deviceType){
//        if (! SessionMap.containsKey(userName)) return false;
//        JSONObject jsonObject = SessionMap.get(userName);
//        return jsonObject.has(deviceType.getName());
//    }

    public boolean isActiveSession(String userName, HttpServletRequest request){
        try{
            if (! SessionMap.containsKey(userName)) return false;
            JSONObject jsonObject = SessionMap.get(userName);
            DeviceType deviceType = this.getDeviceType(request);
            if (! jsonObject.has(deviceType.getName())) return false;
            return  jsonObject.get(deviceType.getName()).equals(request.getSession().getId());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateSession(String userName, HttpServletRequest request){
        try{
            JSONObject jsonObject;
            DeviceType deviceType = this.getDeviceType(request);

            if (SessionMap.containsKey(userName)) { jsonObject = SessionMap.get(userName); }
            else{ jsonObject = new JSONObject(); }

            jsonObject.put(deviceType.getName(),request.getSession().getId());
            SessionMap.put(userName,jsonObject);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void removeSession(String userName, HttpServletRequest request){
        try{
            if (! SessionMap.containsKey(userName)) return;
            JSONObject jsonObject = SessionMap.get(userName);

            DeviceType deviceType = this.getDeviceType(request);

            if (jsonObject.has(deviceType.getName())) {
                jsonObject.remove(deviceType.getName());
                int devCount = 0;
                for(DeviceType deviceType1 : DeviceType.values()){
//                    System.out.println(deviceType1.getName());
                    if (jsonObject.has(deviceType1.getName())) devCount++;
                }
                if (devCount == 0) SessionMap.remove(userName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DeviceType getDeviceType(HttpServletRequest request){
        LiteDeviceResolver deviceResolver = new LiteDeviceResolver();
        Device device = deviceResolver.resolveDevice(request);
        DeviceType deviceType;
        if (device.isMobile()){ deviceType = DeviceType.MOBILE; }
        else if (device.isTablet()){ deviceType = DeviceType.TABLET; }
        else if (device.isNormal()){  deviceType = DeviceType.WEB; }
        else{ deviceType = DeviceType.WEB; }
        return deviceType;
    }


}
