# springboot-init

> springboot示例模板生成器
>
> 作者：qhn
>
> 基于 程序员鱼皮的 [鱼籽代码生成器项目](https://github.com/liyupi/yuzi-generator) 制作，感谢您的使用！

可以通过命令行交互式输入的方式动态生成想要的项目代码

## 使用说明

执行项目根目录下的脚本文件：

示例命令：

generator generate -a -o -l

        password

        类型：String

        描述：密码

        默认值："123456"


        url

        类型：String

        描述：地址

        默认值："jdbc:mysql://localhost:3306/my_db"


        username

        类型：String

        描述：用户名

        默认值："root"



        description

        类型：String

        描述：接口文档描述

        默认值："springboot-init"


        title

        类型：String

        描述：接口文档标题

        默认值："接口文档"


        version

        类型：String

        描述：接口文档版本

        默认值："1.0"



        needDocs

        类型：boolean

        描述：是否开启接口文档功能

        默认值：true


        needPost

        类型：boolean

        描述：是否开启帖子功能

        默认值：true


        needCors

        类型：boolean

        描述：是否开启跨域功能

        默认值：true


        needEs

        类型：boolean

        描述：是否开启ES功能

        默认值：true


        basePackage

        类型：String

        描述：基础包名

        默认值："com.yupi"


        needRedis

        类型：boolean

        描述：是否开启Redis功能

        默认值：true


