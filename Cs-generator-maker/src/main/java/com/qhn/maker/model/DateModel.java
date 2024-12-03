package com.qhn.maker.model;

import lombok.Data;

/**
 * 动态模版配置
 */
@Data
public class DateModel {

    /**
     * 是否生成循环
     */
    private boolean loop;

    /**
     * 作者注释
     */
    private String author="qhn";

    /**
     * 输出信息
     */
    private String outputText="Res:";
}
