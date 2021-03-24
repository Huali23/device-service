package com.hc.device.response;

/**
 * @author liujingeng
 * @description 请求结果枚举类
 * @create 2020/12/23
 */
public enum ResultStatus{

    STATUS_404(404),
    STATUS_500(500),
    STATUS_200(200),
    ;

    private int code;

    ResultStatus(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
