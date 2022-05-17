package com.application.pichuser.exception;

public class MensajeError {
    private String code;
    private String eMsg;

    public MensajeError() {
    }

    public MensajeError(String code, String eMsg) {
        this.code = code;
        this.eMsg = eMsg;
    }

    public String getEMsg() {
        return this.eMsg;
    }

    public void setEMsg(String eMsg) {
        this.eMsg = eMsg;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}