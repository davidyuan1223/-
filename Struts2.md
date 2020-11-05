# 基本MVC架构

> Model View Controller 或者MVC,是一个用于开发Web应用程序的设计模式.Model View Controller模式由以下三个部分组成
>
> 1. Model:模式的最底层级别,负责维护数据
> 2. View:负责向用户显示全部或部分数据
> 3. Controller:控制Model和View之间交互的软件代码
>
> MVC之所以流行,是因为它将应用程序逻辑与用户界面层隔离开来,并支持关注点分离.此处,Controller接收对应程序的所有请求,然后与Model一起使用,以准备视图所需的任何数据,然后,View使用Controller准备的数据来生成最终的可表示响应.MVC抽象如下图所示![image-20201017153435823](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201017153435823.png)

## Model

> Model负责管理应用程序的数据,它响应来自视图的请求,也响应来自控制器的指令以更新自身.

## View

> 意味着以特定格式去呈现数据,这是由控制器决定程序数据触发的,基于脚本的模板系统,例如JSP,ASP,PHP,并且非常易于与AJAX技术集成

## Controller

> 控制器负责响应用户输入并在数据模型对象上执行交互,控制器接收输入,也验证输入,然后执行修改数据模型状态的业务操作.

# 1.Struts 2概述

> Struts 2是基于MVC设计模式的流行且成熟的Web应用程序框架,Struts2不仅是Struts1的新版本,而且是对Struts体系结构的完全重写.
>
> Webwork框架最初以Struts框架为基础,其目标是提供基于Struts的增强和改进框架,以使开发人员更轻松的进行Web开发
>
> 不就后Webwork框架和Struts社区携手创建了著名的Struts2框架.

## 1.Struts2框架功能

> 这是一些可以考虑使用Struts2的出色功能
>
> 1. POJO表单和POJO动作:Struts2取消了Struts框架不可或缺的动作表单,使用Struts2,可以使用任何POJO来接收表单输入,同样,现在可以将任何POJO视为Action类
> 2. 标签支持:Struts2改进了表单标签和新标签,使开发人员可以编写更少的代码
> 3. AJAX支持:Struts2已经意识到Web2.0技术的接管,并且通过创建AJAX标签将AJAX支持集成到产品中,此功能与标准Struts2标签非常相似.
> 4. 轻松集成:Struts2提供的各种集成使用Spring,Tiles和SiteMesh等其他框架的集成变得更加容易
> 5. 模板支持:支持使用模板生成视图
> 6. 插件支持:可以通过使用插件来增强Struts2的核心行为,Struts2提供了许多插件
> 7. 分析:Struts2提供了集成的分析功能来调试和分析应用程序,除此之外,Struts2还借助内置调试工具提供集成调试
> 8. 易于修改标签;Struts2中的标签标记可以使用Freemarker模板进行调整.不需要JSP或java知识.基本的html,xml和css知识足以修改标签
> 9. 减少配置:Struts2通过使用各种设置的默认值来减少配置,除非它偏离了Struts2设置的默认设置,否则无需进行任何配置
> 10. View Technologies:Struts2对多种视图选择(JSP,Freemarker,Velocuty)提供了强大的支持

## 2.Struts2的缺点

> 1. 更多的学习曲线:要将MVC与Struts一起使用,必须熟悉标准的JSP,Servlet API和庞大而精巧的框架.
> 2. 较差的文档:与标准servlet和JSP API相比,Struts在线资源较少
> 3. 透明度较差:与普通基于Java的web应用程序相比,Struts在幕后处理的时期要多很多,使得难以理解框架

Struts 2是最好的Web框架之一,被高度用于Rich Internet Applications(RIA)开发

# 2.Struts 2环境配置

> 1. JDK
> 2. 服务器,tomcat,apache,nginx
> 3. 设置Struts2库

# 3.Struts 2--结构

> 从架构上看,Strits2其实也算一个另类的MVC框架,它的Model-View-Controller模式由以下5个核心组件来组成
>
> 1. 动作
> 2. 拦截器
> 3. 价值栈/OGNL
> 4. 结果/结果类型
> 5. 查看技术



> Struts2与传统MVC架构略有不同,在传统MVC框架中,动作扮演的是Model而不是Controller,尽管会有一些重叠![image-20201030193833609](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201030193833609.png)
>
> 上图就是Struts2的MVC体系架构描述图

# 4.Struts示例

> 正如从Struts2架构中学到的一样,当单机超链接或者在Struts2 Web应用程序中提交HTML表单的时候,输入将由Controller去收集,并发送到名为Actions的Java类中.
>
> 执行动作后,结果将选择一个资源去呈现响应,该资源通常是JS{,但也可以是其他文件.

然后Struts2项目都必须创建一下四个组件

| 序号 | 组件&描述                                                    |
| ---- | ------------------------------------------------------------ |
| 1    | Action(动作):创建一个动作类,将包含完整的业务逻辑并控制用户,模型与视图之间的交互 |
| 2    | Interceptors(拦截器):根据需要来创建拦截器或者直接使用现有的拦截器,这是控制器的一部分 |
| 3    | View(视图):创建一个JSP,与用户交互以输入信息并呈现最终消息    |
| 4    | Configurations File(配置文件):创建配置文件以将操作,视图和控制器进行耦合.这些文件是struts.xml,web.xml,struts.properties |

## IDEA进行Struts2 Web项目创建

![image-20201031105935371](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201031105935371.png)

然后输入项目名![image-20201031110222839](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201031110222839.png)

导入struts2需要使用到的库文件

在web.xml中配置一个Filter,所有请求都需要过来给这个Filter

filter-class使用struts2自带的StrutsPrepareAbdExecuteFilter![image-20201031110638880](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201031110638880.png)

然后去配置struts.xml,struts.xml一般都在src目录下去创建![image-20201031111014603](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201031111014603.png)

有时候extends="struts-default"会报错,解决方法如下![image-20201031111045148](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201031111045148.png)

将struts-default.xml也加入进去

然后创建index.jsp

![image-20201031111135756](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201031111135756.png)

运行tomcat,结果如图所示![image-20201031111217839](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201031111217839.png)

# 5.Struts2  ---- 配置文件

> Struts2有许多重要的基础配置和配置文件,比如(web.xml,struts.xml,strutsconfig.xml,struts.properties)

## web.xml文件

> 众所周知,web.xml配置文件是J2EE的配置文件,该文件主要作用是确定servlet和filter的映射管理,他并不算是Struts2的配置文件,但它需要配置才可以使Struts2工作.
>
> 该文件为任何Web应用程序提供一个入口点,Struts2应用程序的入口点将是在部署描述符中定义的过滤器,因此需要在web.xml中定义FilterDispatcher类的条目.
>
> 上面示例中的web.xml
>
> ```xml
> <?xml version="1.0" encoding="UTF-8"?>
> <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
>          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
>          xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
>          version="4.0">
>     <filter>
>         <filter-name>struts2</filter-name>
>         <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
>     </filter>
>     <filter-mapping>
>         <filter-name>struts2</filter-name>
>         <url-pattern>/*</url-pattern>
>     </filter-mapping>
> </web-app>
> ```
>
> 除此之外,一般将Struts2过滤器映射到/*而不是/*.action,这意味着所有URL将有struts2过滤器去进行解析.

## Struts.xml文件

> 在Struts.xml文件中包含配置信息,作为行动的开发,会被修改.
>
> 该文件可用于覆盖应用程序的默认设置,例如struts.devMode=false和属性文件中定义的其他配置,一般在src目录下创建该文件
>
> ```xml
> <?xml version="1.0" encoding="UTF-8"?>
> 
> <!DOCTYPE struts PUBLIC
>         "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
>         "http://struts.apache.org/dtds/struts-2.0.dtd">
> 
> <struts>
>     <package name="test" extends="struts-default">
>         <action name="index">
>             <result>index.jsp</result>
>         </action>
>     </package>
> </struts>
> ```
>
> 首先是DOCTYPE,它的作用是声明该xml文件是struts的配置文件,struts则是根标签元素,在该元素下,使用package标签来声明不同的软件包,并且package允许分离和模块化配置,当有一个大型项目并将项目划分为不同的模块的时候,这回非常的有用.
>
> 例如,当项目具有三个域,bussiness,customer,staff时就可以创建三个package并将关联的操作来存储在适当的包里面.
>
> package标签具有以下属性:
>
> | 序号 | 属性&描述                                                    |
> | ---- | ------------------------------------------------------------ |
> | 1    | name(必填):package的标识符                                   |
> | 2    | extends:该软件包从哪个软件包扩展?默认情况下,都是以struts-default作为基本包 |
> | 3    | abstract:如果为true,则该软件包不可以供最终用户去使用         |
> | 4    | namespace:动作的名称空间                                     |
>
> 然后还有个constant标签元素,有两个主要属性name和value被用来覆盖任何定义下属性的default.properties
>
> 例:
>
> ```xml
> <?xml version="1.0" encoding="UTF-8"?>
> <!DOCTYPE struts PUBLIC "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
> "http://staruts.apache.org/dtds/struts-2.3.dtd">
> <struts>
> 	<!--所有匹配*.action的请求都由struts2处理-->
>     <constant name="struts.action.extension" value="action"/>
>     <!--是否启用开发模式-->
>     <constant name="struts.devMode" value="true"/>
>     <!--struts配置文件改动后,是否重新加载-->
>     <constant name="struts.configuratuon.xml.reload" value="true"/>
>     <!--设置浏览器是否还存静态内容-->
>     <constant name="struts.server.static.browserCache" value="false"/>
>     <!--请求参数的编码方式-->
>     <constant name="struts.i18n.encoding" value="utf-8"/>
>     <!--每次HTTP请求系统都重新加载资源文件,有助于开发-->
>     <constant name="struts.i18n.reload" value="true"/>
>     <!--文件上传最大值-->
>     <constant name="struts.muktipart.maxSize" value="12345"/>
>     <!--让struts2支持动态方法调用-->
>     <constant name="struts.enable.DynamicMethodInvocation" value="true"/>
>     <!--Action名称中是否还是用斜线-->
>     <constant name="struts.enable.SlashesInActionNames" value="false"/>
>     <!--允许标签中使用表达式语法-->
>     <constant name="struts.tag.altSyntax" value="true"/>
> </struts>
> ```
>
> 除此之外,Struts.xml文件会随着时间的增长而增长,因此可以通过打包将其拆分为一种模块化的方法,但是Struts提供了另一种模块化struts.xml文件方法,可以将文件拆分为多个xml文件,然后按一下方式导入
>
> ```xml
> <?xml version="1.0" Encoding="UTF-8"?>
> <!DOCTYPE struts PUBLIC
> 	"-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
> 	"http://struts.apache.org/dtds/struts-2.0.dtd">
> <struts>
> 	<include file="my-struts1.xml"/>
>     <include file="my-struts2.xml"/>
> </struts>
> ```

# 6.Struts2---动作(Action)

> 对于任何MVC(模型视图控制器)框架而言,动作都是Struts2框架的核心,每个URL都映射到一个特定的操作,该操作提供了处理来自用户的请求所必须的处理逻辑.
>
> 动作还具有其他两个重要作用,首先该动作在从请求到视图的数据传输中起着重要作用,无论是JSP还是其他类型的结果,其次,该操作必须帮助框架确定哪个结果应呈现将在对请求的响应中返回的视图.

## 创建动作

> Struts2中对动作的唯一要求是必须有一个noargument方法返回String或Result对象,并且必须是POJO,如果没有指定参数方法,则默认使用execute()方法.
>
> 除此之外,还可以扩展ActionSupport类,因为其继承了六个接口并且其中包括了Action接口,Action接口如下所示
>
> ```java
> public interface Action{
>     public static final String SUCCESS="success";
>     public static final String NONE="none";
>     public static final String ERROR="error";
>     public static final String INPUT="input";
>     public static final String LOGIN="login";
>     public String execute() throws Exception;
> }
> ```
>
> Action示例1
>
> ```java
> public class HelloWorldAction{
>     private String name;
>     public String executer() throws Exception{
>         return "success";
>     }
>     public String getName() {
>       return name;
>    }
> 
>    public void setName(String name) {
>       this.name = name;
>    }
> }
> ```
>
> Action示例2,对execute方法进行更改,扩展ActionSupport
>
> ```java
> public class HelloWorldAction2 extends ActionSupport{
>     private String name;
>     public String getName() {
>       return name;
>    }
> 
>    public void setName(String name) {
>       this.name = name;
>    }
>    	public String execute() throws Exception{
>         if("SECRET".equals(name)){
>             return SUCCESS;
>         }else{
>             return ERROR;
>         }
>     }
> }
> ```
>
> 在此示例中,在execute方法中具有的一些逻辑去查看name属性,再看struts.xml文件
>
> ```xml
> <?xml version = "1.0" Encoding = "UTF-8"?>
> <!DOCTYPE struts PUBLIC
>    "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
>    "http://struts.apache.org/dtds/struts-2.0.dtd">
>    
> <struts>
> 	<constant name="struts.devMode" value="true"/>
>     <package name="helloWorld" extends="struts-default">
>     	<action name="hello"
>                 class="HelloWorldAction2"
>                 method="execute">
>         	<result name="success">/HelloWorld.jsp</result>
>             <result name="error">/AccessDenid.jsp</result>
>         </action>
>     </package>
> </struts>
> ```

## 显示数据到JSP

> Model层创建一个Product用于存放数据
>
> ```java
> public class Product{
>     int id;
>     String name;
>     public int getId(){
>         return id;
>     }
>     public void setId(int id){
>         this.id=id;
>     }
>     public String getName() {
>         return name;
>     }
>     public void setName(String name) {
>         this.name = name;
>     }
> }
> ```
>
> 创建ProductAtcion用于控制
>
> ```java
> public class ProductAction{
>     private Product product;
>  
>     public String show() {
>         product = new Product();
>         product.setName("iphone7");
>         return "show";
>     }
>  
>     public Product getProduct() {
>         return product;
>     }
>  
>     public void setProduct(Product product) {
>         this.product = product;
>     }
> }
> ```
>
> 在struts.xml中配置跳转,该配置表示,访问路径/showProduct的时候会调用ProductAction类的show方法,然后服务端跳转到show.jsp
>
> ```xml
> <?xml version="1.0" encoding="UTF-8"?>
> <!DOCTYPE struts PUBLIC
>     "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
>     "http://struts.apache.org/dtds/struts-2.0.dtd">
> <struts>
> 	<package name="basicstruts" extends="struts-default">
>     	<action name="showProduct" class="ProductAction" method="show">
>         	<result name="show">show.jsp</result>
>         </action>
>     </package>
> </struts>
> ```
>
> show.jsp,通过EL表达式,取出product的name
>
> ```jsp
> <%@page isELIgnored="false"%>
> ${product.name}
> ```
>
> ![image-20201031162801444](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201031162801444.png)

原理

> 1. 访问路径/showProduct
> 2. 所有访问都被struts的filter拦截,并进入struts的工作流程
> 3. 根据配置文件struts.xml,会执行ProductAction中的show方法
> 4. 在show方法中将实例属性product指向一个新的对象,并设置名称为iphone7
> 5. 在服务端跳转到show.jsp
> 6. 在show.jsp中,访问ProductAction.getProduct()获取实例属性product,并显示其名称iphone7
>
> ![原理图](https://stepimagewm.how2j.cn/1871.png)

## 提交数据到JSP

> jsp提交product的name到action,然后action跳转会showProduct.jsp把提交上来的name显示出来
>
> addProduct.jsp
>
> ```jsp
> <html>
>     <form action="addProduct.action">
>         <input type="text" name="product.name">
> 		<br/>
>         <input type="submit" value="submit">
>     </form>
> </html>
> ```
>
> 为addProduct路径配置对应的action和方法以及返回:struts.xml
>
> ```xml
> <?xml version="1.0" encoding="UTF-8"?>
> <!DOCTYPE struts PUBLIC
>     "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
>     "http://struts.apache.org/dtds/struts-2.0.dtd">
>  
> <struts>
> 	<package name="basistruts" extends="struts-default">
>     	<action name="showProduct" class="ProductAction" method="show">
>         	<result name="show">show.jsp</result>
>         </action>
>         <action name="addProduct" class="ProductAction" method="add">
>         	<result name="show">show.jsp</result>
>         </action>
>     </package>
> </struts>
> ```
>
> 在addProduct.jsp中提交数据的field是product.name,会自动调用对应的Action的setProduct方法去进行数据的注入,所以ProductAction必须提供setProduct(Product product)方法
>
> ```java
> public class ProductAction{
>     private Product product;
>     public String show(){
>         product=new Product();
>         product.setName("iphone7");
>         return "show";
>     }
>     public String add(){
>         System.out.println("product.name:"+product.name());
>        	return "show";
>     }
>     public Product getProduct() {
>         return product;
>     }
>     public void setProduct(Product product) {
>         this.product = product;
>     }
> }
> ```
>
> ![image-20201031164003261](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201031164003261.png)
>
> ![image-20201031164014704](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201031164014704.png)
>
> 

原理

> 1. 访问路径/addProduct
> 2. 所有访问都被struts的filter拦截,进入struts的工作流程
> 3. 根据配置文件struts.xml,执行ProductAction的add方法
> 4. 在add方法执行之前,Struts生成一个新的product对象,并把页面传递过来的name设置在该对象中
> 5. 服务端跳转到show.jsp
> 6. 在show.jsp中访问ProductAction.getProduct()方法注入的product,并显示名称
>
> ![原理图](https://stepimagewm.how2j.cn/1874.png)

# 7.Struts2----拦截器--Interceptors

>拦截器在概念上与servlet过滤器或者JDK代理类相同.拦截器允许横切功能与操作以及框架分开实现,可以使用拦截器实现以下目标
>
>1. 在调用动作之前提供预处理逻辑
>2. 调用动作后提供处理逻辑
>3. 捕获异常,以便可以执行替代处理
>
>Struts2框架中提供的许多功能都是使用拦截器实现的.

## Struts2框架的拦截器

> Struts 2框架提供了许多拦截器,这些拦截器已经预先配置好并可以使用
>
> | 序号 | 拦截器&描述                                                  |
> | ---- | ------------------------------------------------------------ |
> | 1    | alias(别名):允许参数在请求中具有不同的名称别名               |
> | 2    | checkbox(复选框):通过未选中的复选框添加参数值false来辅助管理复选框 |
> | 3    | conversionError:将错误信息从字符串转为参数类型再转换为操作的字段错误 |
> | 4    | createSession:如果一个HTTP会话尚不存在,则自动创建            |
> | 5    | debugging(调试):为开发人员提供不同的调试屏幕                 |
> | 6    | execAndWait:在后台执行操作时将用户发送到中间等待页面         |
> | 7    | exception:将从操作引发的异常映射到结果,从而允许通过重定向自动处理异常 |
> | 8    | fileUpload(上传文件):方便上传文件                            |
> | 9    | i18n:在用户会话期间跟踪选定的语言环境                        |
> | 10   | logger(记录器):通过输出正在执行的动作的名称来提供简单的日志记录 |
> | 11   | params(参数):在操作上设置请求参数                            |
> | 12   | prepare(准备):通常用于执行预处理工作,例如设置数据库连接      |
> | 13   | profile(资料):允许为操作记录简单的概要信息                   |
> | 14   | scope(范围):在会话或应用程序范围内存储和检索操作的状态       |
> | 15   | ServletConfig:为操作提供对各种基于Servlet的信息的访问权限    |
> | 16   | timer(计时器):以执行动作需要多长时间的形式提供简单的概要信息 |
> | 17   | token:检查操作以获取有效令牌,防止重复提交表单                |
> | 18   | validation(验证):为操作提供验证支持                          |

## 如何使用拦截器?

> 以timer和params拦截器作实例,测量执行一个动作方法花费的时间和将请求参数发送到操
>
> 在struts.xml添加拦截器![image-20201031172516891](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201031172516891.png)

# 8.Struts 2 -结果和结果类型

> 在struts.xml中,results标记在Struts2 MVC框架中扮演着视图角色.
>
> 它负责执行业务逻辑,执行业务逻辑后的下一步是使用results标记去显示视图.
>
> 通常,结果中会附带一些导航规则,例如,如果操作方法是对用户进行身份验证,则有三种可能的结果:
>
> 1. 成功登录
> 2. 登录失败-用户名或密码错误
> 3. 账户被锁定
>
> 在这种情况下,将为action方法配置三个可能的结果字符串和三个不同的视图去呈现结果.
>
> 在这种情况下,将为action方法配置三个可能的结果字符串和三个不同的视图去呈现结果.
>
> 除此之外,Struts不会将JSP作为视图技术来使用.还可以是JSOn或者XML
>
> Struts带有许多预定义的结果类型,并且可以看到默认的结果类型是dispatcher,用于分配到JSP页面,Struts允许将其标记语言用于视图技术呈现结果.

## The Dispatcher Result Type

> dispatcher结果类型是默认的类型,如果没有指定其他结果类型被使用,它会用于转发到服务器上的servlet,JSP,HTML页面等,它使用RequestDispatcher.forward()方法去转发.
>
> 示例1
>
> ```xml
> <result name="success">
> 	/HelloWorld.jsp
> </result>
> ```
>
> 还可以使用<result...>元素中的<param name="location">标记去指定JSP文件,如下所示
>
> ```xml
> <result name="success" type="dispatcher">
> 	<param name="location">
>     	/HelloWorld.jsp
>     </param>
> </result>
> ```
>
> 还可以提供一个parse参数,默认为true,作用是确定是否为OGNL表达式解析location参数

## FreeMarker结果类型

> FreeMarker也可以去用作视图技术,FreeMarker是一种流行的模板引擎,用于使用预定义的模板生成输出.
>
> 创建一个名为hello.fm的FreeMarker模板文件
>
> ```
> Hello World ${name}
> ```
>
> 上面文件是一个模板,其中name是将使用定义的操作从外部传递的参数.
>
> 在struts.xml指定结果
>
> ```xml
> <?xml version = "1.0" Encoding = "UTF-8"?>
> <!DOCTYPE struts PUBLIC
> "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
> "http://struts.apache.org/dtds/struts-2.0.dtd">
> <struts>
> 	<constant name="struts.devMode" value="true"/>
>     <package name="helloworld" extends="struts-default">
>     	<action name="hello"
>                 class="HelloWorldAction"
>                 method="execute">
>         	<result name="success" type="freemarker">
>             	<param name="location">
>                 	/hello.fm
>                 </param>
>             </result>
>         </action>
>     </package>
> </struts>
> ```

## 重定向结果类型

> 重定向的结果类型调用表中response.sendRedirect()方法,使所述浏览器以创建给定位置的新情求.
>
> 可以在<result...>元素主体或作为<param name="location">元素的形式来提供位置
>
> ```xml
> <action name="hello"
>         class="HelloWorldAction"
>         method="execute">
> 	<result name="success" type="redirect">
>     	<param name="location">
>         	/NewWorld.jsp
>         </param>
>     </result>
> </action>
> ```

# 9.Struts 2---值堆栈/OGNL

## The Value Stack(价值栈)

值堆栈是几个对象的合计,这些对象按提供的顺序保持以下对象

| 序号 | 对象&描述                                                    |
| ---- | ------------------------------------------------------------ |
| 1    | Temporary Objects(临时对象):在页面执行期间会创建各种临时对象,例如在JSP标记中循环的集合的当前迭代值 |
| 2    | The Model Object(模型对象):如果在struts应用程序中使用模型对象,则当前模型对象将放在值堆栈的操作之前 |
| 3    | The Action Object(动作对象):这将是当前正在执行的动作对象     |
| 4    | Names Objects(命名对象):这些对象包括#application,#session,#request,#attr和#parameters并引用相应的servlet作用域. |

> 可以通过为JSP,Velocity或者Freemarker提供的标签来访问值堆栈.
>
> 一旦有了ValueStack对象,就可以使用一下方法来操作该对象
>
> | 序号 | ValueStack方法和说明                                         |
> | ---- | ------------------------------------------------------------ |
> | 1    | Object findValue(String expr):通过默认的搜索顺序针对堆栈评估给定表单式来查找值 |
> | 2    | CompoundRoot getRoot():获取CompoundRoot,该对象将对象压入堆栈 |
> | 3    | Object peek():在不更改堆栈情况下,将对象放在堆栈顶部          |
> | 4    | Object pop():将对象放在堆栈顶部,然后将其从堆栈中删除         |
> | 5    | void push(Object o):将此对象放在堆栈顶部                     |
> | 6    | vodi set(String key,Object o):使用给定的键在堆栈上设置一个对象,以便通过findValue(key...)进行检索 |
> | 7    | void setDefaultType(Class defaultType):设置获取值时未提供任何类型的默认类型以转换为该类型 |
> | 8    | void setValue(String expr,Object value):尝试使用默认搜索顺序使用给定的表达式在堆栈中的bean上设置属性 |
> | 9    | int size():获取堆栈中的对象数                                |

## OGNL

> OGNL---对象-图像导航语言,用于参考并操作值栈数据的表达式语言,OGNL还有助于数据传输和类型转换.
>
> OGNL与JSP表达语言类型,OGNL基于在上下文中具有根对象或默认对象的思想,可以使用标记符号(#)来引用默认对象或根对象属性.
>
> 如上所述,OGNL基于上下文,Struts构建一个ActionContext映射以与OGNL一起使用,ActionContext映射包含以下内容
>
> 1. Application--应用范围变量
> 2. Session--会话范围变量
> 3. Root/value stack---所有的操作变量都存储在此处
> 4. Request--请求范围变量
> 5. Parameters--请求参数
> 6. Atributes--存储在页,请求,会话和应用范围的属性
>
> 可以使用#符号去引用ActionContext中的对象,但是,也可以直接引用值堆栈中的对象.
>
> 如:
>
> ```
> <s:property value="name"/>
> ```
>
> 可以替代为
>
> ```
> <s:property value="#name"/>
> ```
>
> 如果会话中有一个名为login的属性,则可以按一下方式去检索
>
> ```
> <s:property value="#session.login"/>
> ```
>
> OGNL还支持处理集合Map,List,Set.例如要显示颜色的下拉列表,可以执行一下操作
>
> ```
> <s:select name="color" list="{'red','yellow','green'}"/>
> ```

## ValueStack/OGNL示例

创建动作

```java
public class HelloWorldAction extends ActionSupport{
    private String name;
    public String execute() throws Exception{
        ValueStack stack=ActionContext.getContext().getValueStack();
        Map<String,Object> context=new HashMap<String,Object>();
        context.put("key1",new String("This is key1"));
        context.put("key2",new String("This is key2"));
        stack.push(context);
        System.out.println("Size of the valueStack:"+stack,size());
        return "success";
    }
     public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
```

创建视图HelloWorld.jsp

```jsp
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>Hello World</title>
    </head>
    <body>
        Entered value: <s:property value="name"/><br/>
        Value of key1: <s:property value="key1"/><br/>
        value of key2: <s:property value="key2"/><br/>
    </body>
</html>
```

index.jsp

```jsp
<%@ page language="java" contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tag"%>
<!DOCTYPE html PUBLIC
	"-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Hello World</title>
    </head>
    <body>
        <h1>
            Hello World Ftom Struts2
        </h1>
        <form action="hello">
            <label for="name">Please enter your name</label><br/>
            <input type="text" name="name"/>
			<input type="submit" value="Say Hello"/>
        </form>
    </body>
</html>
```

struts.xml

```xml
<?xml version = "1.0" Encoding = "UTF-8"?>
<!DOCTYPE struts PUBLIC
   "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
   "http://struts.apache.org/dtds/struts-2.0.dtd">
<struts>
	<constant name="struts.devMode" value="true"/>
    <package name="helloWorld" extends="struts-default">
    	<action name="hello"
                class="HelloWorldAction"
                method="execute">
        	<result name="success">/HelloWorld.jsp</result>
        </action>
    </package>
</struts>
```

web.xml

```xml
<?xml version = "1.0" Encoding = "UTF-8"?>
<web-app xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
   xmlns = "http://java.sun.com/xml/ns/javaee" 
   xmlns:web = "http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
   xsi:schemaLocation = "http://java.sun.com/xml/ns/javaee 
   http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
   id = "WebApp_ID" version = "3.0">
  	<web-app>
    	<display-name>Struts 2</display-name>
    <welcome-file-list>
    	<welcome-file>index.jsp</welcome-file>
    </welcome-file-list>
    <filter>
    	<filter-name>struts2</filter-name>
        <filter-class>
        	org.apache.struts2.dispatcher.FilterDispatcher
        </filter-class>
    </filter>
    <filter-mapping>
    	<filter-name>struts2</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    </web-app>
```

# 10.Struts 2---文件上传

> Struts 2框架提供了内置的支持,可以使用"html中基于表单的文件上传"去处理文件上传.上传文件后,通常会将其存储在一个临时目录中,并且Action类应将其处理或移动到永久目录中,以确保数据不会丢失.
>
> 注意:服务器可能具有适当的安全策略,该策略可能会禁止写入除临时目录和属于Web应用程序目录以外的目录.
>
> 通过预定义的拦截器FileUpload拦截器,可以在Struts中上传文件,该拦截器可以通过org.apache.struts2.interceptor.FileUploadInterceptor类获得,并作为defaultStack的一部分包含在内,仍然可以在struts.xml中使用它来设置各种参数.

## 创建查看文件

从创建视图开始,这是浏览器和上传选定文件所必须的,因此,创建具有纯html上传格式的index.jsp,该格式允许用户上传文件

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>FileUpload</title>
  </head>
  <body>
    <form action="upload" method="post" enctype="multipart/form-data">
      <label for="myFile">Upload your file</label>
      <input type="file" name="myFile">
      <input type="submit" value="UpLoad">
    </form>
  </body>
</html>
```

注意,首先将表单的enctype设置为multipart/form-data,应该进行设置,以便文件上传拦截器成功处理文件上传,然后注意表单的操作方法上传以及文件上传字段的名称,即myFile,需要此信息创建操作方法和struts配置.

然后创建success.jsp,显示文件上传成功后的结果

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>File UpLoad Success</title>
</head>
<body>
    You have successfully uploaded <s:property value="myFileFileName"/>
</body>
</html>
```

除了上传成功页面外还得有失败页面,error.jsp

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>File UpLoad Error</title>
</head>
<body>
    There has bean an error in uploading the file
</body>
</html>
```

## 创建动作类

创建uploadFile类,复制上传文件并将该文件存储在安全的位置

```java
public class upload extends ActionSupport {
    private File myFile;
    private String myFileContentType;
    private String myFileFileName;
    private String destPath;

    @Override
    public String execute() throws Exception {
        destPath="D:/code/";
        try {
            System.out.println("Src File name:"+myFile);
            System.out.println("Dst File name:"+myFileFileName);
            File destFile=new File(destPath,myFileFileName);
            FileUtils.copyFile(myFile,destFile);
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    public File getMyFile() {
        return myFile;
    }

    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }

    public String getMyFileContentType() {
        return myFileContentType;
    }

    public void setMyFileContentType(String myFileContentType) {
        this.myFileContentType = myFileContentType;
    }

    public String getMyFileFileName() {
        return myFileFileName;
    }

    public void setMyFileFileName(String myFileFileName) {
        this.myFileFileName = myFileFileName;
    }

    public String getDestPath() {
        return destPath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }
}
```

除此之外,还需要一个FileUpload拦截器与Parameter Interceptor一起完成所有繁重的工作.

默认情况下,FileUpload拦截器有三个参数可用,以以下模式命名

1. [your file name parameter(文件名)]-这是用户已上传的实际文件,即myFile
2. [your file name parameter(文件名参数)]ContentType-这是上传文件的内容类型,即myFileContentType
3. [your file name parameter(文件名参数)]FileName--上传的文件名,即myFileFileName

配置文件

以下是控制文件上传过程的Struts2配置属性

| 序号 | 属性&说明                                                    |
| ---- | ------------------------------------------------------------ |
| 1    | struts.multipart.maxSize:作文文件上传可接受文件的最大大小(以字节为单位),默认值250m |
| 2    | struts.multipart.parser:用于上传多部分表单,默认情况下是jakarta |
| 3    | struts.multipart.saveDir:存储临时文件的位置,                 |

struts.xml

```xml
<?xml version="1.0" Encoding="UTF-8"?>
<!DOCTYPE struts PUBLIC
	"-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
	"https://struts.apache.org/dtds/struts-2.0.dtd">
<strutrs>
	<constant name="struts.devMode" value="true"/>
    <constant name="struts.multipart.maxSize" value="1000000"/>
    <package name="helloworld" extends="struts-default">
    	<action name="upload" class="upload">
        	<result name="success">/success.jsp</result>
            <result name="error">/error.jsp</result>
        </action>
    </package>
</strutrs>
```

由于FileUpload拦截器是默认拦截器堆栈一部分,因此无需显示配置,但是可以在action里面添加interceptor-ref标签

web.xml

```xml
<?xml version = "1.0" Encoding = "UTF-8"?>
<web-app xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
   xmlns = "http://java.sun.com/xml/ns/javaee" 
   xmlns:web = "http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
   xsi:schemaLocation = "http://java.sun.com/xml/ns/javaee 
   http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
   id = "WebApp_ID" version = "3.0">
   
   <display-name>Struts 2</display-name>
   
   <welcome-file-list>
      <welcome-file>index.jsp</welcome-file>
   </welcome-file-list>
   
   <filter>
      <filter-name>struts2</filter-name>
      <filter-class>
         org.apache.struts2.dispatcher.FilterDispatcher
      </filter-class>
   </filter>

   <filter-mapping>
      <filter-name>struts2</filter-name>
      <url-pattern>/*</url-pattern>
   </filter-mapping>
</web-app>
```

运行![image-20201101124305395](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201101124305395.png)

![image-20201101124317771](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201101124317771.png)

![image-20201101124339278](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201101124339278.png)

# 11.Struts 2---访问数据库

> Struts是MVC框架而不是数据库框架,但也为JPA/Hibernate集成提供了出色的支持.现在先集成普通的JDBC来访问数据库
>
> 建立数据库,以已有数据库为基础,减少操作步骤![image-20201101130102260](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201101130102260.png)

## 建立动作

> 动作类具有与数据库表中列相对应的属性,在操作方法中,检测列是否存在,如果存在则显示,如果输入了错误信息,再次将其发送到登录屏幕
>
> ```java
> public class LoginAction extends ActionSupport {
>     private String name;
>     private String gender;
>     private String qq;
>     private int age;
>     private String address;
>     private String email;
> 
>     @Override
>     public String execute() throws Exception {
>         String ret=ERROR;
>         Connection connection=null;
>         try {
>             String URL="jdbc:mysql://localhost/anli";
>             Class.forName("com.mysql.jdbc.Driver");
>             connection= DriverManager.getConnection(URL,"root","123456");
>             String sql="select * from user where";
>             sql+="user=?";
>             PreparedStatement ps=connection.prepareStatement(sql);
>             ps.setString(1,"zhangsan");
>             ResultSet rs=ps.executeQuery();
>             while (rs.next()){
>                 name=rs.getString(2);
>                 gender=rs.getString(5);
>                 age=rs.getInt(4);
>                 address=rs.getString(5);
>                 qq=rs.getString(6);
>                 email=rs.getString(7);
>                 ret=SUCCESS;
>             }
>         }catch (Exception e){
>             ret=ERROR;
>         }finally {
>             if (connection != null) {
>                 connection.close();
>             }
>         }
>         return ret;
>     }
> 
>     public String getName() {
>         return name;
>     }
> 
>     public void setName(String name) {
>         this.name = name;
>     }
> 
>     public String getGender() {
>         return gender;
>     }
> 
>     public void setGender(String gender) {
>         this.gender = gender;
>     }
> 
>     public String getQq() {
>         return qq;
>     }
> 
>     public void setQq(String qq) {
>         this.qq = qq;
>     }
> 
>     public int getAge() {
>         return age;
>     }
> 
>     public void setAge(int age) {
>         this.age = age;
>     }
> 
>     public String getAddress() {
>         return address;
>     }
> 
>     public void setAddress(String address) {
>         this.address = address;
>     }
> 
>     public String getEmail() {
>         return email;
>     }
> 
>     public void setEmail(String email) {
>         this.email = email;
>     }
> }
> ```

配置struts.xml![image-20201101132456284](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201101132456284.png)

创建查询页面,query.jsp

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>查询</title>
</head>
<body>
    <form action="query.action" method="post">
        <label>
            User:
            <input type="text" name="user">
        </label><br>
        <input type="submit" value="query">
    </form>
</body>
</html>
```

创建success1.jsp

```jsp
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>查询成功</title>
    </head>
    <body>
        Hello:
        name:<s:property value="name"/>
        gender:<s:property value="gender"/>
        age:<s:property value="age"/>
        address:<s:property value="address"/>
        qq:<s:property value="qq"/>
        email:<s:property value="email"/>
    </body>
</html>
```

error1.jsp

```jsp
<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>查询失败</title>
    </head>
    <body>
        查询失败
    </body>
</html>
```

# 12.Struts 2--发送电子邮件

## 建立动作

```java
public class Emailer extends ActionSupport {
    private String from;
    private String password;
    private String to;
    private String subject;
    private String body;
    static Properties properties=new Properties();
    static {
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.scoketFactory.port","456");
        properties.put("mail.smtp.scoketFactory.class","javax.net.ssl.SSLScoketFactory");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.port","456");
    }

    @Override
    public String execute() throws Exception {
        String ret=SUCCESS;
        try {
            Session session=Session.getDefaultInstance(properties,new Authenticator(){
                protected PasswordAuthentication
                getPasswordAuthentication(){
                    return new
                    PasswordAuthentication(from,password);
                }
            });
            Message message=new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
        }catch (Exception e){
            ret=ERROR;
            e.printStackTrace();
        }
        return ret;

    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static void setProperties(Properties properties) {
        Emailer.properties = properties;
    }
}
```

如上所示,Emailer具有与先给定的email.jsp页面中的表单属性相对应的属性,这些属性是:

1. from:发件人电子邮件地址,当使用Google的SMTP时,需要一个有效的gtalk ID
2. password:上述账户密码
3. to:电子邮件发送目标
4. subject:电子邮件主题
5. body:实际信息.

配置struts.xml![image-20201101141648330](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201101141648330.png)

创建主页email.jsp

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>发送邮件</title>
</head>
<body>
    <em>The form below uses Google's SMTP server.
        So you need to enter a gemil username and password.
    </em>
    <form action="emailer.action" method="post">

        <label for="from">
            From:
            <input type="text" name="from" id="from">
        </label>
        <br/>
        <label for="password">password: </label><input type="password" name="password" id="password"><br/>
        <label for="to">To: </label><input type="text" name="to" id="to"><br/>
        <label for="subject">subject: </label><input type="text" name="subject" id="subject"><br/>
        <label for="body">body: </label><input type="text" name="body" id="body"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
```

# 13.Struts 2---验证

> 在Struts核心中,具有验证框架,该框架可以帮助应用程序在执行action方法之前运行规则去执行验证.
>
> 客户端验证通常使用JavaScript实现,但是不应该只依赖客户端去验证,最好的方法是在应用程序框架的所有级别来进行验证.
>
> Struts项目添加验证一般有两种方法.
>
> 实例:以雇员为例,该雇员的姓名和年龄应该使用一个简单的页面来捕获,然后进行两次验证,确保用户输入的姓名和年龄始终在28到150之间
>
> 建立动作EmployeeAction
>
> ```java
> public class EmployeeAction extends ActionSupport {
>     private String name;
>     private int age;
> 
>     @Override
>     public String execute() throws Exception {
>         return SUCCESS;
>     }
>     public void validate(){
>         if (name==null||name.trim().equals("")){
>             addFieldError("name","The name is required");
>         }
>         if (age<28||age>65){
>             addFieldError("age","age must be in between 28 and 65");
>         }
>     }
>     public String getName() {
>         return name;
>     }
> 
>     public void setName(String name) {
>         this.name = name;
>     }
> 
>     public int getAge() {
>         return age;
>     }
> 
>     public void setAge(int age) {
>         this.age = age;
>     }
> }
> ```
>
> 配置struts.xml![image-20201101170605261](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201101170605261.png)
>
> 创建主页employee.jsp
>
> ```jsp
> <%@ page contentType="text/html;charset=UTF-8" language="java" %>
> <%@ taglib prefix="s" uri="/struts-tags" %>
> <html>
> <head>
>     <title>雇员</title>
> </head>
> <body>
>     <s:form action="empinfo" method="POST">
>         <s:textfield name="name" label="Name" size="20"/>
>         <s:textfield name="age" label="Age" size="20"/>
>         <s:submit name="submit" label="Submit" align="center"/>
>     </s:form>
> </body>
> </html>
> ```
>
> 运行结果
>
> ![image-20201101170916057](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201101170916057.png)
>
> 验证是如何工作的?
>
> 用户按下提交按钮时,Struts 2自动执行validate方法,并且如果该方法中列出的任何"if"语句为true,则Struts 2调用其addFieldError方法,如果添加了任何错误,则Struts 2将不会继续调用execute方法,相反,Struts 2框架将返回输入作为调用操作的结果.
>
> 因此,当验证失败并且Struts 2返回input时,Struts 2框架将重新显示index.jsp文件.并且会在表单字段上方添加错误信息.

# 14.Struts 2---本地语言/其他语言

> 国家化(i18n)是规划和实施产品和服务的过程,以便可以轻松将其适应特定的本地语言和文化,即本地化.
>
> 国际化过程称为翻译或本地化支持.
>
> 国际化缩写为i18n,因为以i开头,n结尾,并且第一个i和最后一个n之间有18个字符
>
> Struts 2通过以下位置资源包,拦截器与标签库去提供本地化,即国际化(i18n)支持
>
> 1. UI标签
> 2. 消息和错误
> 3. Action中

## 资源包

> Struts 2使用资源包为Web应用程序用户提供多种语言和区域设置选项.无需担心用不同语言编写页面,要做的就是位所需的每种语言创建一个资源包.
>
> 资源包将包含标题,消息和其他以用于语言去显示的文本.
>
> 资源包是包含应用程序默认语言的键/值对文件.即properties
>
> 资源文件命名格式
>
> ```
> bundlename_language_country.properties
> ```
>
> bundlename可以是ActionClass,Interfaces,SuperClass,Model,Package,Global资源属性.下一部分,language_country表示国家/地区语言环境.
>
> 当通过消息元素的键引用消息元素的时候,Struts框架将按以下顺序搜索相应的消息
>
> ```
> ActionClass.properties
> Interface.properties
> SuperClass.properties
> model.properties
> package.properties
> struts.properties
> global.properties
> ```
>
> 要使用多种语言开发应用程序,应该去维护这些语言环境相对应的多个属性文件,并根据键值对去定义所有内容.

## 示例

> 为美国英语(默认),西班牙语和法语开发应用程序,则必须创建三个属性文件,在这里,仅使用global.properties文件,也可以使用不同的属性文件分隔不同类型消息.
>
> - global.properties:默认情况下应用英语
> - global_fr.properties:用于法语环境
> - global_es.properties:用于西班牙语言环境

### 访问消息

> 有多种访问消息资源的方法,包括getTest,文本标记,UI标记和键属性和i18n标记.
>
> 要显示i18n标记,得在property标签或任何其他标签中使用getText调用
>
> ```
> <s:property value="getText('some key')"/>
> ```
>
> 该文本标签从默认资源包检索信息,即struts.properties
>
> ```
> <s:text name="some key"/>
> ```
>
> 在国际化标签推导值栈中的任意资源包,i18n标签范围内的其他标签可以显示来自该资源的消息
>
> ```
> <s:i18n name="some.package.budle">
> 	<s:text name="some key"/>
> </s:i18n>
> ```
>
> 大多数UI标签的key属性可以用于从资源包生成消息
>
> ```
> <s:textfield key="some.key" name="textfieldName"/>
> ```



### 资源文件

global.properties

```properties
global.name=Name
global.age=Age
global.submit=Submit
global.heading=Select Locale
global.success=Successfully authenticated
```

global_fr.properties

```properties
global.name=Nom d'utilisateur
global.age = l'âge
global.submit = Soumettre des
global.heading = Sé lectionnez Local
global.success = Authentifi	é  avec succès
```

global_es.propertis

```properties
global.name = Nombre de usuario
global.age = Edad
global.submit = Presentar
global.heading = seleccionar la configuracion regional
global.success = Autenticado correctamente
```

![image-20201102105245209](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201102105245209.png)

### 创建动作

> 需要创建两个动作
>
> 1. 一个动作用于照顾语言环境,并以不同语言显示相同的index.jsp文件
> 2. 另一个动作是照顾提交表单本身
>
> 两个动作都会返回success,但是将基于返回值去执行不同动作

照顾语言环境的动作

```java
public class Locale extends ActionSupport {
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
```

提交表格的动作

```java
public class Employee extends ActionSupport {
    private String name;
    private int age;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

```

### 配置struts.xml

![image-20201102105850654](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201102105850654.png)

### i18n.jsp

```jsp
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/2
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>多种语言环境</title>
</head>
<body>
    <h1><s:text name="global.heading"/></h1>
    <s:url id="indexEN" namespace="/" action="locale">
        <s:param name="request_locale">en</s:param>
    </s:url>
    <s:url id="indexES" namespace="/" action="locale">
        <s:param name="request_locale">es</s:param>
    </s:url>
    <s:url id="indexFR" namespace="/" action="locale">
        <s:param name="request_locale">fr</s:param>
    </s:url>
    <s:a href="%{indexEN}">English</s:a>
    <s:a href="%{indexES}" >Spanish</s:a>
    <s:a href="%{indexFR}" >France</s:a>
    <s:form action="employee" method="post" namespace="/">
        <s:textfield name="name" key="global.name" size="20"/>
        <s:textfield name="age" key="global.age" size="20"/>
        <s:submit name="submit" key="global.submit"/>
    </s:form>
</body>
</html>
```

# 15.Struts 2---类型转换

> HTTP协议会将HTTP请求上的所有内容都视为字符串,包括数字,布尔值,整数,日期,小数等,但是,在Strust类中,可以具有任何类型的数据.
>
> Struts如何自动连接属性?
>
> Struts在工具下使用各种类型的转换器来进行繁重工作.
>
> 例如,在Action类中有一个integer属性,则Struts会自动将请求参数转换为integer属性,无需进行任何操作,默认情况下,Struts带有许多类型转换器.
>
> 有时在使用自己的数据类型时,有必要添加在即的转换器使Struts在显示之前指定如何转换这些值.
>
> POJO类,Environment.java
>
> ```java
> public class Environment {
>  private String name;
> 
>  public String getName() {
>      return name;
>  }
> 
>  public void setName(String name) {
>      this.name = name;
>  }
> 
>  public Environment(String name) {
>      this.name = name;
>  }
> }
> ```
>
> 上述是一个简单类,具有name属性
>
> 动作类,SystemDetails
>
> ```java
> public class SystemDetails extends ActionSupport {
>  private Environment environment=new Environment("Development");
>  private String operatingSystem="Windows XP SP3";
> 
>  @Override
>  public String execute() throws Exception {
>      return SUCCESS;
>  }
> 
>  public Environment getEnvironment() {
>      return environment;
>  }
> 
>  public void setEnvironment(Environment environment) {
>      this.environment = environment;
>  }
> 
>  public String getOperatingSystem() {
>      return operatingSystem;
>  }
> 
>  public void setOperatingSystem(String operatingSystem) {
>      this.operatingSystem = operatingSystem;
>  }
> }
> ```
>
> 配置struts.xml![image-20201102112504048](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201102112504048.png)
>
> System.jsp
>
> ```jsp
> <%@ page contentType="text/html;charset=UTF-8" language="java" %>
> <%@taglib prefix="s" uri="/struts-tags" %>
> <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
> "http://www.w3.org/TR/html4/loose.dtd">
> <html>
> <head>
>     <title>show</title>
> </head>
> <body>
> Environment:
> <s:property value="environment"/><br>
> Operating System:
> <s:property value="operatingSystem"/>
> </body>
> </html>
> ```
>
> ![image-20201102140831246](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201102140831246.png)
>
> 如上图所示,输出其实存在问题,因为String指定如何去显示Windows XP SP3和其他内置数据类型,但是它不知道如何去处理Environment类型的属性,在类上简称为toString()方法.
>
> 要解决类型问题,就需要为Environment类创建并注册一个简单的TypeConverter.
>
> EnvironmentConverter.java
>
> ```java
> public class EnvironmentConverter extends StrutsTypeConverter {
>     @Override
>     public Object convertFromString(Map map, String[] strings, Class aClass) {
>         return new Environment(strings[0]);
>     }
> 
>     @Override
>     public String convertToString(Map map, Object o) {
>         Environment environment= (Environment) o;
>         return environment==null?null:environment.getName();
>     }
> }
> ```
>
> EnvironmentConverter扩展了StrutsTypeConverter类,告诉Struts如何通过重写这两个方法把对象转换为字符串,
>
> 1. convertFromString():将字符串转换为对象
> 2. convertToString():将对象转换为字符串
>
> 写好转换器以后,还需要去注册转换器,然后再在应用程序中去使用.
>
> 有两种注册转换器的方法:
>
> 如果仅仅需要在特定操作下去使用转换器,则可以创建一个属性文件,该文件需要命名'[action-class]'converstion.properties
>
> 创建SystrmDetails-converstion.propertis
>
> ```properties
> environment=action.Environm
> ```
>
> 此文件中,environment是SystemDetails类中属性名,并且告诉Struts使用EnvironmentConverter进行属性转换.
>
> 第二种方式则是在全局范围使用转换器,也是最常用的一种,因为这样可以在整个应用程序中去使用.
>
> 创建一个名为属性文件xwork-converstion.properties在WEB-INF/classes中