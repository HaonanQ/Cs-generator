package com.qhn.maker.template.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileFilterConfig {
    //过滤范围，规则，值
    private String range;
    private String rule;
    private String value;
}
