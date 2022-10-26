package cn.vesns.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author arctique
 * @data 2020/9/16 10:31
 */
@Setter
@Getter
@ToString
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    private T data;

    public static <T> Result<T> success(int code) {
        return result(code, null, null);
    }

    public static <T> Result<T> success(int code, T data) {
        return result(code, null, data);
    }

    public static <T> Result<T> success(int code, String msg, T data) {
        return result(code, msg, data);
    }

    public static <T> Result<T> failure(int code) {
        return result(code, null, null);
    }

    public static <T> Result<T> failure(int code, String msg, T data) {
        return result(code, msg, data);
    }

    private static <T> Result<T> result(int code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
