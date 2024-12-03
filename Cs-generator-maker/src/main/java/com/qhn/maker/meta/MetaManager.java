package com.qhn.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

public class MetaManager {
    private static volatile Meta meta;
    private MetaManager(){
        // 私有构造器
    }
    public static Meta getMetaObject(){
        // 双重检查锁定
        // 最先检查是为了之后初始化后不再进入到锁，节省资源
        if(meta == null){
            synchronized(MetaManager.class){
                if(meta == null){
                    meta = initMeta();
                }
            }
        }
        return meta;
    }
    private static Meta initMeta(){
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta meta = JSONUtil.toBean(metaJson, Meta.class);
        Meta.FileConfig fileConfig = meta.getFileConfig();
        // todo: 校验和默认值设置
        return meta;
    }
}
