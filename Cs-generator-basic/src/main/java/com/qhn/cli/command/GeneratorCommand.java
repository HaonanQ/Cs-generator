package com.qhn.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.qhn.generator.MainGenerator;
import com.qhn.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "generate", description = "生成代码",mixinStandardHelpOptions = true)
@Data
public class GeneratorCommand implements Callable<Integer> {

    @CommandLine.Option(names = {"-l","--loop"}, description = "循环生成代码",arity = "0..1",interactive = true,echo = true)
    private boolean loop;
    @CommandLine.Option(names = {"-a","--author"}, description = "作者名称",arity = "0..1",interactive = true,echo = true)
    private String author;
    @CommandLine.Option(names = {"-o","--outputText"}, description = "输出文本",arity = "0..1",interactive = true,echo = true)
    private String outputText;
    @Override
    public Integer call() throws Exception {
        MainTemplateConfig config = new MainTemplateConfig();
        BeanUtil.copyProperties(this,config);
        System.out.println("配置信息："+config);
        MainGenerator.doGenerate(config);
        return 0;
    }
}
