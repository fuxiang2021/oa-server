package com.ldyswlp.common.result;

import lombok.Getter;

/**
 * 统一响应结果
 */

@Getter
public enum ResultCodeEnum {

    SUCCESS(200, "查询成功"),
    CREATE_SUCCESS(201, "创建成功"),
    DELETE_SUCCESS(203, "删除成功"),
    CREATE_FAIL(400, "添加失败"),
    LOGIN_AUTH(401, "用户验证失败"),
    PERMISSION(403, "无权访问"),
    NOT_FOUND(404, "资源不存在"),
    UPDATE_FAIL(406, "更新数据失败"),
    ERROR(500, "服务器异常");

    private final Integer code;
    private final String msg;

    private ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
