package org.fzu.cs03.daoyun;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/4/9 17:20
 */
public class GlobalConstant {
    static public final String sessionUser = "userName";

//    static public final String  resourceRoot = "g:/spring/";
    static public final String  resourceRoot = "/home/trivial-daoyun/resource/";
    static public final String  profilePhotoPath = resourceRoot + "profilePhoto/";
    static public final Integer tokenExpiryTime = 24 * 60 * 60 * 1000 ; // 24 hours 单位为ms
//    static public final Integer tokenExpiryTime = 5000 ; // 24 hours 单位为ms

}
