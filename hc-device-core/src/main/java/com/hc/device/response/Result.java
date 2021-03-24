package com.hc.device.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author liujingeng
 * @description 交互模型
 * @create 2020/12/23
 */
@Getter
@Setter
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 7624922982506098948L;

    private boolean successful;
    private int code;
    private T data;
    private String message;

    private void setCode(int code) {
        this.code = code;
    }

    public void setCode(ResultStatus resultStatus) {
        this.setCode(resultStatus.getCode());
    }

    public Result(){

    }

    public Result(boolean successful) {
        this.successful = successful;
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(boolean successful, int code, T data, String message){
        this.successful = successful;
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static <T> Result<T> success(T data) {
        return Result.success(data, ResultMessage.SUCCESS.getMessage());
    }

    public static <T> Result<T> success(T data, String message) {
        return new Result<T>(true).code(ResultStatus.STATUS_200).data(data).message(message);
    }

    public static Result fail() {
        return Result.fail(ResultStatus.STATUS_500, ResultMessage.FAIL.getMessage());
    }

    public static Result fail_404() {
        return Result.fail(ResultStatus.STATUS_404, ResultMessage.FAIL.getMessage());
    }

    public static Result fail(ResultStatus resultStatus) {
        return Result.fail(resultStatus, ResultMessage.FAIL.getMessage());
    }

    public static Result fail(String message) {
        return Result.fail(ResultStatus.STATUS_500, message);
    }

    public static Result fail(ResultStatus resultStatus, String message) {
        return new Result(false).code(resultStatus).message(message);
    }

    public Result<T> data(T data){
        this.setData(data);
        return this;
    }

    public Result<T> message(String message) {
        this.setMessage(message);
        return this;
    }

    public Result<T> code(ResultStatus resultStatus) {
        this.setCode(resultStatus);
        return this;
    }

    public class Builder{
        private boolean successful;
        private int code;
        private T data;
        private String message;

        public Builder() {

        }

        public Builder successful(boolean successful) {
            this.successful = successful;
            return this;
        }

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder code(ResultStatus resultStatus) {
            this.code = resultStatus.getCode();
            return this;
        }

        public Builder data(T data) {
            this.data = data;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Result build() {
            return new Result<T>(this);
        }
    }

    public Result(Builder builder){
        successful = builder.successful;
        code = builder.code;
        data = builder.data;
        message = builder.message;
    }
}