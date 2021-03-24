package com.hc.device.response;

public enum ResultMessage {

    SUCCESS("操作成功"),
    FAIL("操作失败"),
    ;

    private String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
