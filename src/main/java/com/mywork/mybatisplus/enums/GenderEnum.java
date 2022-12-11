package com.mywork.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p> 2022/12/11 14:38
 * </p>有两种方式，一种是在字段上加注解，一种是实现 IEnum<> 接口
 */
public enum GenderEnum {
    MEN(1, "男"), WOMAN(0, "女");

    @EnumValue // 标记数据库存的值是 code
    private final int code;
    @JsonValue
    private final String desc;

    GenderEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
