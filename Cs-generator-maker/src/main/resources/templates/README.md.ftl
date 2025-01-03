# ${name}

> ${description}
>
> 作者：${author}
>
> 基于 程序员鱼皮的 [鱼籽代码生成器项目](https://github.com/liyupi/yuzi-generator) 制作，感谢您的使用！

可以通过命令行交互式输入的方式动态生成想要的项目代码

## 使用说明

执行项目根目录下的脚本文件：

示例命令：

generator generate -a -o -l

<#list modelConfig.models as modelInfo>
    <#if modelInfo.groupKey??>
        <#list modelInfo.models as modelInfo>
        ${modelInfo.fieldName}

        类型：${modelInfo.type}

        描述：${modelInfo.description}

        默认值：${modelInfo.defaultValue?c}


        </#list>
    <#else>
        ${modelInfo.fieldName}

        类型：${modelInfo.type}

        描述：${modelInfo.description}

        默认值：${modelInfo.defaultValue?c}

    </#if>

</#list>
