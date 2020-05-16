package org.fzu.cs03.daoyun.exception;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/5/16 16:13
 */
public class UserException extends Exception {
    public UserException(){
        super();
    }

    public UserException(String msg){
        super(msg);
    }
}
