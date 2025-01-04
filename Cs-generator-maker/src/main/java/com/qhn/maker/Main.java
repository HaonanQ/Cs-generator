package com.qhn.maker;

//import com.qhn.maker.CommandExecutor;

import com.qhn.maker.generator.main.GenerateTemplate;
import com.qhn.maker.generator.main.MainGenerator;
import com.qhn.maker.generator.main.ZipGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
//        GenerateTemplate generateTemplate = new MainGenerator();
        GenerateTemplate generateTemplate = new ZipGenerator();
        generateTemplate.doGenerate();
    }
}


