package org.fzu.cs03.daoyun.service;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ResponseService {

    public String responseGET(String state,String msg, String result){
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("state",state);
            jsonObject.put("msg",msg);
            jsonObject.put("result",result);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public String responsePOST(String state, String msg){
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("state",state);
            jsonObject.put("msg",msg);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public String responsePUT(String state, String msg){
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("state",state);
            jsonObject.put("msg",msg);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

}
