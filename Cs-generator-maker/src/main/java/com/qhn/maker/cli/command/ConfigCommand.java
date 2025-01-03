package com.qhn.maker.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.qhn.maker.model.DateModel;
import picocli.CommandLine;

import java.lang.reflect.Field;

@CommandLine.Command(name = "config", description = "查看参数信息",mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {

    @Override
    public void run() {
        System.out.println("查看参数信息:");
        Field[] fields = ReflectUtil.getFields(DateModel.class);
        for (Field field : fields) {
            System.out.println("名称："+field.getName());
            System.out.println("类型："+field.getType());
            System.out.println("-----------");
        }
    }
}
