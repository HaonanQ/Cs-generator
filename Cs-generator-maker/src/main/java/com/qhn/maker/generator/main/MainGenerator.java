package com.qhn.maker.generator.main;

import com.qhn.maker.meta.Meta;
import com.qhn.maker.meta.MetaManager;

public class MainGenerator {

    public static void main(String[] args) {
        Meta meta = MetaManager.getMetaObject();
        System.out.println(meta);
    }
}

