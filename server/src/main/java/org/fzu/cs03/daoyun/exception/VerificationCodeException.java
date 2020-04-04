package org.fzu.cs03.daoyun.exception;

public class VerificationCodeException extends Exception {
    public VerificationCodeException(){
        super();
    }

    public VerificationCodeException(String msg){
        super(msg);
    }
}
