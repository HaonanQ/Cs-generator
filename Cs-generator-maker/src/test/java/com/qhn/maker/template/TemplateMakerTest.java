package com.qhn.maker.template;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;
import com.qhn.maker.meta.Meta;
import com.qhn.maker.template.model.FileFilterConfig;
import com.qhn.maker.template.model.TemplateMakerConfig;
import com.qhn.maker.template.model.TemplateMakerFileConfig;
import com.qhn.maker.template.model.TemplateMakerModelConfig;
import com.qhn.maker.template.model.enums.FileFilterRangeEnum;
import com.qhn.maker.template.model.enums.FileFilterRuleEnum;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.qhn.maker.template.TemplateMaker.makeTemplate;
import static org.junit.Assert.*;

public class TemplateMakerTest {

    /**
     * 测试同配置多次生成时，强制变为静态生成
     */
    @Test
    public void testMakeTemplateBug1() {
        Meta meta = new Meta();
        meta.setName("acm-template-generator");
        meta.setDescription("ACM 示例模板生成器");

        String projectPath = System.getProperty("user.dir");
        String originProjectPath = new File(projectPath).getParent() + File.separator + "qhn-generator-demo-projects/springboot-init";
//        String inputFilePath = "src/main/java/com/yupi/springbootinit";
        String inputFilePath1 = "src/main/java/com/yupi/springbootinit/common";
//        String inputFilePath2 = "src/main/resources/application.yml";

        // 模型参数配置
        TemplateMakerModelConfig templateMakerModelConfig = new TemplateMakerModelConfig();

        // - 模型组配置
        TemplateMakerModelConfig.ModelGroupConfig modelGroupConfig = new TemplateMakerModelConfig.ModelGroupConfig();
        modelGroupConfig.setGroupKey("mysql");
        modelGroupConfig.setGroupName("数据库配置");
        templateMakerModelConfig.setModelGroupConfig(modelGroupConfig);

        // - 模型配置
        TemplateMakerModelConfig.ModelInfoConfig modelInfoConfig1 = new TemplateMakerModelConfig.ModelInfoConfig();
        modelInfoConfig1.setFieldName("className");
        modelInfoConfig1.setType("String");
        modelInfoConfig1.setReplaceText("BaseResponse");

//        TemplateMakerModelConfig.ModelInfoConfig modelInfoConfig2 = new TemplateMakerModelConfig.ModelInfoConfig();
//        modelInfoConfig2.setFieldName("username");
//        modelInfoConfig2.setType("String");
//        modelInfoConfig2.setDefaultValue("root");
//        modelInfoConfig2.setReplaceText("root");

//        List<TemplateMakerModelConfig.ModelInfoConfig> modelInfoConfigList = Arrays.asList(modelInfoConfig1, modelInfoConfig2);
        List<TemplateMakerModelConfig.ModelInfoConfig> modelInfoConfigList = Arrays.asList(modelInfoConfig1);
        templateMakerModelConfig.setModels(modelInfoConfigList);

        // 替换变量（首次）
//        String searchStr = "Sum: ";
        // 替换变量（第二次）
        String searchStr = "BaseResponse";

//         文件过滤
        TemplateMakerFileConfig templateMakerFileConfig = new TemplateMakerFileConfig();
        TemplateMakerFileConfig.FileInfoConfig fileInfoConfig1 = new TemplateMakerFileConfig.FileInfoConfig();
        fileInfoConfig1.setPath(inputFilePath1);
//        List<FileFilterConfig> fileFilterConfigList = new ArrayList<>();
//        FileFilterConfig fileFilterConfig = FileFilterConfig.builder()
//                .range(FileFilterRangeEnum.FILE_NAME.getValue())
//                .rule(FileFilterRuleEnum.CONTAINS.getValue())
//                .value("Base")
//                .build();
//        fileFilterConfigList.add(fileFilterConfig);
//        fileInfoConfig1.setFilterConfigList(fileFilterConfigList);
        templateMakerFileConfig.setFiles(Arrays.asList(fileInfoConfig1));
//        TemplateMakerFileConfig.FileInfoConfig fileInfoConfig2 = new TemplateMakerFileConfig.FileInfoConfig();
//        fileInfoConfig2.setPath(inputFilePath2);
//        templateMakerFileConfig.setFiles(Arrays.asList(fileInfoConfig1, fileInfoConfig2));

        // 分组配置
//        TemplateMakerFileConfig.FileGroupConfig fileGroupConfig = new TemplateMakerFileConfig.FileGroupConfig();
//        fileGroupConfig.setCondition("outputText");
//        fileGroupConfig.setGroupKey("test");
//        fileGroupConfig.setGroupName("测试分组");
//        templateMakerFileConfig.setFileGroupConfig(fileGroupConfig);

        long id = makeTemplate(meta, originProjectPath, templateMakerFileConfig, templateMakerModelConfig, 1870676898938982400L);
        System.out.println(id);
    }
    /**
     * 同文件目录多次生成时，会扫描新的 FTL 文件
     */
    @Test
    public void testMakeTemplateBug2() {
        Meta meta = new Meta();
        meta.setName("acm-template-generator");
        meta.setDescription("ACM 示例模板生成器");

        String projectPath = System.getProperty("user.dir");
        String originProjectPath = new File(projectPath).getParent() + File.separator + "qhn-generator-demo-projects/springboot-init";

        // 文件参数配置，扫描目录
        String inputFilePath1 = "src/main/java/com/yupi/springbootinit/common";
        TemplateMakerFileConfig templateMakerFileConfig = new TemplateMakerFileConfig();
        TemplateMakerFileConfig.FileInfoConfig fileInfoConfig1 = new TemplateMakerFileConfig.FileInfoConfig();
        fileInfoConfig1.setPath(inputFilePath1);
        templateMakerFileConfig.setFiles(Arrays.asList(fileInfoConfig1));

        // 模型参数配置
        TemplateMakerModelConfig templateMakerModelConfig = new TemplateMakerModelConfig();
        TemplateMakerModelConfig.ModelInfoConfig modelInfoConfig1 = new TemplateMakerModelConfig.ModelInfoConfig();
        modelInfoConfig1.setFieldName("className");
        modelInfoConfig1.setType("String");
        modelInfoConfig1.setReplaceText("BaseResponse");
        List<TemplateMakerModelConfig.ModelInfoConfig> modelInfoConfigList = Arrays.asList(modelInfoConfig1);
        templateMakerModelConfig.setModels(modelInfoConfigList);

        long id = TemplateMaker.makeTemplate(meta, originProjectPath, templateMakerFileConfig, templateMakerModelConfig, 1735281524670181376L);
        System.out.println(id);
    }
    /**
     * 使用 JSON 制作模板
     */
    @Test
    public void testMakeTemplateWithJSON() {
        String configStr = ResourceUtil.readUtf8Str("templateMaker.json");
        TemplateMakerConfig templateMakerConfig = JSONUtil.toBean(configStr, TemplateMakerConfig.class);
        long id = TemplateMaker.makeTemplate(templateMakerConfig);
        System.out.println(id);
    }
    /**
     * 制作 SpringBoot 模板
     */
    @Test
    public void makeSpringBootTemplate() {
        String rootPath = "examples/springboot-init/";
        String configStr = ResourceUtil.readUtf8Str(rootPath + "templateMaker.json");
        TemplateMakerConfig templateMakerConfig = JSONUtil.toBean(configStr, TemplateMakerConfig.class);
        long id = TemplateMaker.makeTemplate(templateMakerConfig);

        configStr = ResourceUtil.readUtf8Str(rootPath + "templateMaker1.json");
        templateMakerConfig = JSONUtil.toBean(configStr, TemplateMakerConfig.class);
        TemplateMaker.makeTemplate(templateMakerConfig);
        System.out.println(id);
    }


}