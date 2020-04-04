package org.fzu.cs03.daoyun.exception;

public class SignInException extends Exception {
    public SignInException(){
        super();
    }

    public SignInException(String msg){
        super(msg);
    }
}
