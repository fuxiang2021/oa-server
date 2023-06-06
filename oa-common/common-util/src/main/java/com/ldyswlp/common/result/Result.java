package com.ldyswlp.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    /**
     * 成功
     * 200 成功无数据
     */
    public static <T> Result<T> success() {
        return build(ResultCodeEnum.SUCCESS, null);
    }

    /**
     * 成功
     * 200 成功并发送数据
     */
    public static <T> Result<T> success(T data) {
        return build(ResultCodeEnum.SUCCESS, data);
    }

    /**
     * 成功
     * 201 创建资源成功
     */
    public static <T> Result<T> createSuccess() {
        return build(ResultCodeEnum.CREATE_SUCCESS, null);
    }

    /**
     * 成功
     * 201 删除资源成功
     */
    public static <T> Result<T> deleteSuccess() {
        return build(ResultCodeEnum.DELETE_SUCCESS, null);
    }

    /**
     * 失败
     * 400 添加失败
     */
    public static <T> Result<T> createFail() {
        return build(ResultCodeEnum.CREATE_FAIL, null);
    }

    /**
     * 失败
     * 401 用户验证失败
     */
    public static <T> Result<T> authFail() {
        return build(ResultCodeEnum.LOGIN_AUTH, null);
    }

    /**
     * 失败
     * 403 无权访问资源
     */
    public static <T> Result<T> permissionFail() {
        return build(ResultCodeEnum.PERMISSION, null);
    }

    /**
     * 失败
     * 404 资源不存在
     */
    public static <T> Result<T> noFoundFail() {
        return build(ResultCodeEnum.NOT_FOUND, null);
    }

    /**
     * 失败
     * 406 更新数据失败
     */
    public static <T> Result<T> updateFail() {
        return build(ResultCodeEnum.UPDATE_FAIL, null);
    }

    /**
     * 错误
     * 500 服务器发送错误
     */
    public static <T> Result<T> error() {
        return build(ResultCodeEnum.ERROR, null);
    }

    private static <T> Result<T> build(ResultCodeEnum resultCodeEnum, T data) {
        Result<T> result = new Result<>();
        if (data != null) {
            result.setData(data);
        }
        result.setCode(resultCodeEnum.getCode());
        result.setMsg(resultCodeEnum.getMsg());
        return result;
    }
}
