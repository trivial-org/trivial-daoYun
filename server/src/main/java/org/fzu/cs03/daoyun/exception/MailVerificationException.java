package org.fzu.cs03.daoyun.exception;

public class MailVerificationException extends Exception{
    public MailVerificationException(){
        super();
    }

    public MailVerificationException(String msg){
        super(msg);
    }
}
