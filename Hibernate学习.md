# 基础知识

> Hibernate是一种高性能的对象/关系持久性与查询服务,开源可以免费下载,Hibernate不仅可以从java类到数据库表映射,还提供数据查询与检索功能

# 1.ORM概述

## 1.什么是JDBC?

> JDBC指Java数据库连接---Java DataBase Connection,提供了一组Java API,用于从Java程序访问关系数据库.这些API使Java程序可以执行SQL语句并与任何符合SQL的数据库进行交互.
>
> JDBC提供了一种灵活体系结构编写独立于数据库的程序,让其可以在不同平台上运行并与不容数据库管理系统进行交互.
>
> JDBC优缺点
>
> | JDBC优点         | JDBC缺点                 |
> | ---------------- | ------------------------ |
> | 简洁SQL处理语句  | 如果用于大型项目会很复杂 |
> | 大数据性能好     | 编程开销大               |
> | 非常适合小型应用 | 没有封装                 |
> | 语法简单易于学习 | 无法实施MVC概念          |
> |                  | 查询是特定与DBMS的       |

## 2.Hibernate特点---对象关系映射(ORM--Object Relational Mapping)

> 如果使用面向对象系统,对象模型与关系数据库之间不匹配,RDBMS以表格格式表示数据,而面向对象的语言(Java)则将其表示为对象的互连图
>
> java语言---实体类
>
> ```java
> public class Employee {
>    private int id;
>    private String first_name; 
>    private String last_name;   
>    private int salary;  
> 
>    public Employee() {}
>    public Employee(String fname, String lname, int salary) {
>       this.first_name = fname;
>       this.last_name = lname;
>       this.salary = salary;
>    }
>    
>    public int getId() {
>       return id;
>    }
>    
>    public String getFirstName() {
>       return first_name;
>    }
>    
>    public String getLastName() {
>       return last_name;
>    }
>    
>    public int getSalary() {
>       return salary;
>    }
> }
> ```
>
> RDBMS表
>
> ```mysql
> create table EMPLOYEE (
>    id INT NOT NULL auto_increment,
>    first_name VARCHAR(20) default NULL,
>    last_name  VARCHAR(20) default NULL,
>    salary     INT  default NULL,
>    PRIMARY KEY (id)
> );
> ```
>
> 存在问题:如果需要在开发了几天或者应用程序之后修改数据库的设计应该如何?其次,在关系数据库中加载和存储对象使将要面临五个不匹配问题
>
> | 序列号 | 不匹配说明                                                   |
> | :----- | ------------------------------------------------------------ |
> | 1      | 粒度:有时会拥有一个对象模型,该对象模型具有比数据库相对应表数量更多的类 |
> | 2      | 继承:RDBMS没有定义类似继承的关系,继承时面向对象编程语言中的自然范例 |
> | 3      | 身份识别:RDBMS确切定义"相同"这一概念:主键.但java也同时定义了对象标识(a==b)和对象相等性(a.equals(b)) |
> | 4      | 协作:面向对象语言使用对象进行关联,RDBMS将关联表示为外键      |
> | 5      | 导航:Java和RDBMS中访问对象方式不同                           |
>
> 所述ORM(对象关系映射)是处理所有上述不匹配的工具

## 3.ORM是什么?

> ORM代表用于将定向关系数据库与对象间数据的编程语言
>
> 与JDBC相比ORM的优点如下:
>
> | 序号 | 好处                               |
> | ---- | ---------------------------------- |
> | 1    | 使业务代码访问对象而不是访问数据库 |
> | 2    | 隐藏SQL查询的详细信息              |
> | 3    | 基于JDBC开发                       |
> | 4    | 不需要数据库就可以实现             |
> | 5    | 基于业务概念而不是数据库结构实体   |
> | 6    | 事务管理和自动密钥生成             |
> | 7    | 快速开发程序                       |
>
> ORM解决方案由以下四个实体组成
>
> | 序号 | 解决方案                                          |
> | ---- | ------------------------------------------------- |
> | 1    | 在持久性类的对象上执行基本CRUD操作API             |
> | 2    | 指定引用类和类属性查询的语言或者API               |
> | 3    | 指定映射元数据的可配置工具                        |
> | 4    | 与事务对象进行交互以执行检查,关联获取其他优化功能 |

## 4.JAVA ORM框架

> java中有几个持久性框架和ORM关联.持久性框架是一种ORM服务,用于将对象存储和检索到关系数据库中![image-20201014172308280](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201014172308280.png)

# 2.Hibernate-概述

> Hibernate是一款ORM的框架,它于2011年创建,是一款开源持久性框架.是一款强大,高性能的对象关系持久性还有查询服务的框架对于任何java应用程序来说.



> Hibernate将Java类映射到数据库表,从Java数据类型映射到SQL数据类型
>
> Hibernate位于传统的Java对象和数据库服务器之间,基于适当的O/R机制和模式处理持久化工作![image-20201014172639577](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201014172639577.png)

## 1.Hibernate优势

> HIbernate负责使用XML文件将Java类映射到数据库表,无需编写任何代码
>
> 提供简单的API,用于直接在数据库中存储Java对象和从检索Java对象
>
> 如果数据库或任何表中有更改,则仅需要改改XML文件属性
>
> 抽象出不熟悉的SQL类型,并提供一种解决熟悉的Java对象的方法
>
> Hibernate不需要应用程序服务器即可运行
>
> 操作数据库对象的复杂关联
>
> 通过智能访问策略最大程度减少对数据库的访问
>
> 提供简单的数据查询



> Hibernate具有分层的体系结构,可帮助用户进行操作而无需了解底层API,Hibernate利用数据库和配置数据为应用程序提供持久化服务.
>
> Hibernate应用程序体系结构的高级视图![image-20201014234546791](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201014234546791.png)
>
> Hibernate应用程序体系结构及重要核心类的详细视图![image-20201014234626202](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201014234626202.png)
>
> Hibernate使用各种现有的Java API,例如JDBC,Java Transaction API(JTA)和Java命名与目录接口(JNDI).JDBC提供了关系数据库共有功能的基本抽象级,允许Hibernate支持几乎所有具有JDBC驱动程序的数据库,JNDI和JTA允许Hibernate与J2EE应用服务器集成.

### 1.配置对象----Configuration

> Configuration对象是在任何Hibernate应用程序中创建的第一个Hibernate对象.通常在应用程序初始化期间仅创建一次,表示Hibernate所需的配置或属性文件.
>
> 配置对象提供两个关键组件-
>
> 1. 数据库连接-通过Hibernate支持的一个或多个配置文件处理,这些文件是hibernate.properties和hibernate.cfg.xml
> 2. 类映射设置-该组件创建Java类和数据库表之间的连接

### 2.SessionFactory对象

> 配置对象用于创建SessionFactory对象,然后使用提供的配置文件为应用程序配置Hibernate,并允许实例化Session对象,SessionFactory是线程安全的对象,并由应用程序的所有线程使用.
>
> SessionFactory是一个重量级对象.它通常是在应用程序启动期间创建的,并保留以备后用.使用单独的配置文件,每个数据库需要一个SessionFactory对象.因此,如果使用多个数据库,则必须创建多个SessionFactory对象.

### 3.会话对象--Session

> 会话用于获得与数据库的物理连接.Session对象是轻量级的,旨在在每次需要与数据库进行交互时实例化.持久化对象通过Session对象保存和检索.
>
> 会话对象不应长时间保持打开状态,因为它们通常线程不安全,因此应根据需要来创建和销毁

### 4.交易对象--Transaction Object

> 事务表示数据库的工作单元,并且大多数RDBMS支持事务功能,Hibernate中的事务由基础事务管理器和事务处理(来自JDBC或JTA)
>
> 这是一个可选对象,Hibernate应用程序可以选择不使用这个接口,以自己的应用程序代码管理事务.

### 5.查询对象--Query Object

> 查询对象使用SQL或Hibernate查询语言(HQL)字符串从数据库中检索数据并创建对象,Query实例用于绑定查询参数,限制查询返回的结果数,并最终执行查询

### 6.条件对象--Criteria Object

> 条件对象用于创建和执行面向对象的条件查询和检索对象

# 3.Hibernate---环境

## 1.下载Hibernate

1. 已经安装了JDK
2. 根据自身操作系统安装Hibernate,然后下载文件
3. 下载地址:http://www.hibernate.org/downloads
4. Hibernate目录结构![image-20201015001345648](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201015001345648.png)

## 2.Hibernate的前提条件

> 除需要Hibernate.jar包以外,还需要一下jar包作为环境参数
>
> | 序号 | 包/库                                                        |
> | ---- | ------------------------------------------------------------ |
> | 1    | dom4j:XML解析http://www.dom4j.org/                           |
> | 2    | Xalan:XSLT处理器https://xml.apache.org/xalan-j/              |
> | 3    | Xerces:Xerces Java分析器https://xml.apache.org/xerces-j/     |
> | 4    | cglib:在运行时对Java类进行适当的更改http://cglib.sourceforge.net/ |
> | 5    | log4j:记录Faremworeklog4jhttps://logging.apache.org/log4j    |
> | 6    | Commons:记录,电子邮件等https://jakarta.apache.org/commons    |
> | 7    | SLF4J:Java日志记录外观https://www.slf4j.org/download.html    |

# 4.Hibernate---配置

## 1.介绍

> Hibernate需要事先知道-在哪里可以找到定义Java类与数据库表的映射信息,Hibernate还需要一组与数据库和其他相关参数有关的配置设置.所有这些信息通常以标准Java属性文件Hibernate.properties或xml文件hibernate.cfg.xml形式提供.
>
> 一般会考虑xml格式文件hibernte.cfg.xml来指定必须的Hibernate属性.大多数属性采用默认值,除非确实需要,否则不需要在属性文件中指定它们.该文件保存在应用程序的类路径的根目录中.
>
> Hibernate属性
>
> 以下是重要属性的列表,将需要在独立情况下为数据库进行配置
>
> | 序号 | 属性和说明                                                   |
> | ---- | ------------------------------------------------------------ |
> | 1    | Hibernate:该属性使Hibernate为所选数据库生成适当的SQL         |
> | 2    | hibernate.connection.driver_class:指定JDBC驱动程序类         |
> | 3    | hibernate.connection.url:指定数据库的JDBC URL                |
> | 4    | hibernate.connection.username:指定数据库的用户名             |
> | 5    | hibernate.connection.password:指定数据库的密码               |
> | 6    | hibernate.connection.pool_size:限制Hibernate数据库连接池中等待的连接数 |
> | 7    | hibernate.connection.autocommit:允许将自动提交模式用于JDBC连接 |
>
> 如果将数据库与应用程序服务器和JNDI一起使用,则必须配以下属性
>
> | 序号 | 属性和说明                                                   |
> | ---- | ------------------------------------------------------------ |
> | 1    | hibernate.connection.datasource:在应用程序服务器上下文中定义的JNDI名称 |
> | 2    | hibernate.jndi.class:JNDI的initialContext类                  |
> | 3    | hibernate.jndi.<JNDIpropertyname>将喜欢的任何JNDI属性传递给JNDI initialContext |
> | 4    | hibernate.jndi.url:提供JNDI的URL                             |
> | 5    | hibernate.connection.username:数据库用户名                   |
> | 6    | hibernate.connection.password:数据库密码                     |

## 2.MYSQL搭配Hibernate使用

> Mysql是当今可用的开源数据库系统之一.创建hibernate.cfg.xml配置文件,并将其放置在应用程序的类路径的根目录中.必须确保mysql数据库中有符合的数据库,并且有可用的用户去测试来访问该数据库
>
> XML配置文件必须符合Hibernate 3 Configur DTD可从http://www.hibernate.ogr/dtd/hibernate-configuration-3.0.dtd获得
>
> ```xml
> <?xml version="1.0" encoding="utf-8"?>
> <!DOCTYPE hibernate-configuration SYSTEM
> "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
> <hibernate-configuration>
> 	<seesion-factory>
>     	<property name="hibernate.dialect">
>         	org.hibernate.dialect.MySQLDialect
>         </property>
>         <property name="hibernate.connection.driver_class">
>         	com.mysql.jdbc.Driver
>         </property>
>         <property name="hibernate.connection.username">
>         	root
>         </property>
>         <property name="hibernate.connection.password">
>         	123456
>         </property>
>         <mapping resource="Employee.hbm.xml"/>
>     </seesion-factory>
> </hibernate-configuration>
> ```
>
> 上面的配置文件包含mapping标记,这个标记域hibernatemapping文件有关.
>
> 各种重要数据库方言属性类型列表![image-20201015140245491](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201015140245491.png)
>
> ![image-20201015140313466](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201015140313466.png)
>
> ![image-20201015140326777](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201015140326777.png)

# 5.Hibernate---Session

> session用于获得与数据库的物理连接,session对象是轻量级的,旨在在每次需要与数据库进行交互时进行实例化.持久对象通过Session对象保存和检索.
>
> session对象不应该长时间处于打开状态,因为它们通常不是线程安全的,因此应该根据需要创建和销毁session,session的主要功能是为映射实体类的实例提供,创建,读取和删除操作.
>
> 在给定的时间点,实例可能存在以下三种状态之一:
>
> 1. 瞬态-持久类的新实例,该实例与session无关,并且在数据库中没有表示,并且Hibernate认为没有标识符值是瞬态的.
> 2. 持久-可以通过将临时实例与session相关联来使该实例持久化,持久实例在数据库中有表示形式,标识符值,并且与会话相关联
> 3. 分离-关闭Hibernate会话后,持久实例变为分离实例
>
> 如果会话实例的持久类是可序列化的,则它将是可序列化的.典型的事务应使用以下用法:
>
> ```java
> Session session=factory.openSession();
> Transaction tx=null;
> try{
>     tx=session.beginTransaction();
>     //do some work
>     ...
>     tx.commit();
> }catch(Execption e){
>     if(tx!=null)tx.rollback();
>     e.printStackTrace();
> }finally(){
>     session.close();
> }
> ```
>
> 如果会话引发异常,则必须回滚事务,并且必须丢弃会话.

## 1.Session接口方法

> Session接口提供了许多方法,以下列出一些重要方法
>
> | 序号 | Session方法和描述                                            |
> | ---- | ------------------------------------------------------------ |
> | 1    | Transaction beginTransaction():开始一个工作单元并且返回关联的Transaction对象 |
> | 2    | void cancelQuery():取消当前查询的执行                        |
> | 3    | void clear():完全的清除该会话                                |
> | 4    | Connection close():关闭会话通过释放JDBC连接                  |
> | 5    | Criteria createCriteria(Class persistentClass):为给定的实体类或实体类的超类创建一个新的Criteria实例 |
> | 6    | Criteria createCriteria(String entityName):创建一个新的Criteria实例根据给定的实体名称 |
> | 7    | Seaializable getIdentifier(Object object):返回与此会话关联的给定实体的标识符值 |
> | 8    | Query createFilter(Object collection,String queryString):为给定的集合和过滤器字符串创建Query的新实例 |
> | 9    | Query createQuery(String queryString):为给定的HQL查询字符串创建Query的新实例 |
> | 10   | SQLQuery createSQLQuery(String queryString):为给定的SQL查询字符串创建一个新的SQLQuery实例 |
> | 11   | void delete(Obecjt object):从数据存储中删除持久化实例        |
> | 12   | void delete(String entityName,Object object):从数据存储中删除持久化实例 |
> | 13   | Session get(String entityName,Seaializable id):返回具有给定标识符的给定命名实体的持久实例;如果不存在这样的持久实例,则返回null |
> | 14   | SessionFactory getSessionFactory():获取创建此session的会话工厂 |
> | 15   | void refresh(Object object):从底层数据库重新读取给定实例的状态 |
> | 16   | Transaction getTransaction():获取与此会话关联的交易实例      |
> | 17   | boolean isConnected():检查当前会话是否连接                   |
> | 18   | boolean isDirty():此会话是否包含必须与数据库同步的任何更改?  |
> | 19   | boolean isOpen():检查会话是否仍然打开                        |
> | 20   | Serializable save(Object object):坚持给定的瞬态实例,首先分配一个生产的标识符 |
> | 21   | void saveOrUpdate(Object object):给定实例的save或者update    |
> | 22   | void update(Object object):使用给定的分离实例的标识符更新持久实例 |
> | 23   | void update(String entityName,Object object):使用给定的分离实例的标识符更新持久实例 |

# 6.Hibernate--持久类

> Hibernate的整个概念是从Java类属性中获取值并将其持久化到数据库表中,映射文档可帮助Hibernate确定如何从类中提取值以及如何将他们与表和关联字段进行映射.
>
> 对象或实例将存储在数据库表中的java类在Hibernate中称为持久性类,如果这些类遵循一些简单规则(也称为普通旧Java对象(POJO)编程模型),Hibernate效果最佳.
>
> 持久类由以下主要规则,但是,这些规则都不是硬性要求
>
> 1. 将保留的所有Java类都需要一个默认的构造函数
> 2. 所有类都应包含一个ID,以便于轻松识别Hibernate和数据库中的对象,此属性映射到数据库表中的主键列
> 3. 应该保留所有属性都应声明为私有,并具有以JavaBean样式定义的getter和setter方法
> 4. Hibernate的一个主要功能是代理,它取决于持久类是否是最终类,还是声明所有公共方法的接口的实现
> 5. 没有扩展或实现EJB框架所需的某些专门类和接口的所有类
>
> POJO名称用于强调给定的对象是普通的Java对象,而不是特殊的对象,尤其不是Enterprise JavaBean

## 1.简单的POJO示例

```java
public class Employee {
   private int id;
   private String firstName; 
   private String lastName;   
   private int salary;  

   public Employee() {}
   public Employee(String fname, String lname, int salary) {
      this.firstName = fname;
      this.lastName = lname;
      this.salary = salary;
   }
   
   public int getId() {
      return id;
   }
   
   public void setId( int id ) {
      this.id = id;
   }
   
   public String getFirstName() {
      return firstName;
   }
   
   public void setFirstName( String first_name ) {
      this.firstName = first_name;
   }
   
   public String getLastName() {
      return lastName;
   }
   
   public void setLastName( String last_name ) {
      this.lastName = last_name;
   }
   
   public int getSalary() {
      return salary;
   }
   
   public void setSalary( int salary ) {
      this.salary = salary;
   }
}
```

# 7.Hibernate--映射文件

> 对象/关系映射通常在XML文档中定义,该映射文件只是Hibernate如何将已经定义的一个或者多个类映射到数据库表中.
>
> Hibernate用户可以选择手动编写XML,也存在许多工具来生成映射文档比如IDEA生成,例:![image-20201015175453873](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201015175453873.png)
>
> ![image-20201015175519451](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201015175519451.png)
>
> ![image-20201015175625753](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201015175625753.png)
>
> ![image-20201015175714835](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201015175714835.png)
>
> 下面进行手动编写
>
> 1. 创建POJO类,其对象将保留在下一部分定义的表中
>
>    ```java
>    public class Employee{
>        private int id;
>        private String firstName;
>        private String lastName;
>        private int salary;
>        public Employee(){}
>        public Employee(String fname,String lname,int salary){
>            this.firstName=fname;
>            this.lastName=lname;
>            this.salary=salary;
>        }
>        public int getId(){
>            return id;
>        }
>        public void setId( int id ) {
>          this.id = id;
>       }
>       
>       public String getFirstName() {
>          return firstName;
>       }
>       
>       public void setFirstName( String first_name ) {
>          this.firstName = first_name;
>       }
>       
>       public String getLastName() {
>          return lastName;
>       }
>       
>       public void setLastName( String last_name ) {
>          this.lastName = last_name;
>       }
>       
>       public int getSalary() {
>          return salary;
>       }
>       
>       public void setSalary( int salary ) {
>          this.salary = salary;
>       }
>    }
>    ```
>
>    然后数据库中会有一个表对应于愿意提供持久性的每个对象.
>
>    ```mysql
>    create table EMPLOYEE(
>    	id INT NOT NULL auto_increment,
>        first_name varchar(20) default null,
>        last_name varchar(20) default null,
>        salary int default null,
>        primary key(id)
>    );
>    ```
>
>    基于以上两个实体,可以定义映射文件,该文件只是Hibernate如何将已定义的一个或多个类映射到数据库表
>
>    ```xml
>    <?xml version="1.0" encoding="utf-8"?>
>    <!DOCTYPE hibernate-mapping PUBLIC
>    "-//Hibernate/Hibernate Mapping DTD//EN"
>    "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
>    <hibernate-mapping>
>    	<class name="Employee" table="EMPLOYEE">
>        	<meta attribute="class-description">
>            	This class contains the employee detail.
>            </meta>
>            <id name="id" type="int" column="id">
>            	<generator class="native"/>
>            </id>
>            <property name="firstName" column="first_name" type="string"/>
>            <property name = "lastName" column = "last_name" type = "string"/>
>          	<property name = "salary" column = "salary" type = "int"/>
>        </class>
>    </hibernate-mapping>
>    ```
>
>    应该将映射文档保存为格式为<classname>.hbm.xml的文件,比如该文件名为Employee.hbm.xml
>
>    映射文件细节:
>
>    1. 映射文档具有<hibernate-mapping>作为根元素的XML文档,其中包含所有<class>元素
>    2. 所述<class>元件用于从一个Java类的数据库表定义特定的映射.使用class元素的name属性指定Java类名称,并使用table属性指定数据库表名称.
>    3. 所述<meta>元素是可选的元件,并且可以被用来创建类描述
>    4. 所述的<id>元素映射类的数据库表中的主键的唯一ID属性.id元素的name属性引用该类中的属性,而column属性应用该数据库表中的列.该类型属性保存Hibernate映射类型,这种映射类型将转换为Java到SQL数据类型
>    5. id属性中的<generator>元素用于自动生成主键值.将generator元素中的class属性设置为native,以使休眠模式根据基础数据库的功能使休眠模式可以选择标识,序列来创建主键.
>    6. 所属<property>元素用于java类属性映射到数据库中的表中的列,元素name属性引用类中的属性,而column属性引用数据库表中的列,该类型属性保存Hibernate映射类型,这种映射类型将转换从Java到SQL数据类型

# 8.Hibernate---映射类型

> 准备Hibernate映射文档时,会发现将Java数据类型映射为RDBMS数据类型.映射文件中声明和使用的类型不是Java类型.也不是SQL数据库类型,这些类型称为Hibernate映射类型,可以将其从Java转换为SQL数据库类型,反之亦然.
>
> 基本类型:
>
> | 映射类型    | Java类型                     | ANSI SQL类型        |
> | ----------- | ---------------------------- | ------------------- |
> | integer     | int or java.lang.Integer     | INTEGER             |
> | long        | long or java.lang.Long       | BIGINT              |
> | short       | short or java.lang.Short     | SMALLINT            |
> | float       | float or java.lang.Float     | FLOAT               |
> | double      | double or java.lang.Double   | DOUBLE              |
> | big_decimal | java.math.BigDecimal         | NUMERIC             |
> | character   | java.lang.String             | CHAR(1)             |
> | string      | java.lang.String             | VARCHAR             |
> | byte        | byte ir java.lang.Byte       | TINYINT             |
> | boolean     | boolean or java.lang.Boolean | BIT                 |
> | yes/no      | boolean or java.lang.Boolean | CHAR(1)('Y' or 'N') |
> | true/false  | boolean or java.lang.Boolean | CHAR(1)('T' or 'F') |
>
> 日期和时间类型
>
> | 映射类型      | Java类型                             | ANSI SQL类型 |
> | ------------- | ------------------------------------ | ------------ |
> | data          | java.util.Date or java.sql.Date      | DATE         |
> | time          | java.util.Date or java.sql.Time      | TIME         |
> | timestamp     | java.util.Date or java.sql.Timestamp | TIMESTAMP    |
> | calendar      | java.util.Calendar                   | TIMESTAMP    |
> | calendar_date | java.util.Calendar                   | DATE         |
>
> 二进制和对象类型

| 映射类型     | java类型                                            | ANSI SQL类型       |
| ------------ | --------------------------------------------------- | ------------------ |
| binary       | byte[]                                              | VARBINARY(or BLOB) |
| text         | java.lang.String                                    | CLOB               |
| serializable | any java calss that implements java.io.Serializable | VARBINARY(or BLOB) |
| clob         | java.sql.Clob                                       | CLOB               |
| blob         | java.sql.Blob                                       | BLOB               |

# 9.Hibernate---示例

## 1.创建POJO类

> 创建应用程序第一步是构建Java POJO类,具体取决于将持久化到数据库的应用程序,考虑带有getter和setter方法的类,使其成为JavaBeans兼容的类.
>
> POJO(普通的旧java对象)是一种java对象,它没有扩展或实现EJB框架分别需要的某些专业类和接口,所有普通的java对象都是POJO.
>
> 当设计一个要由Hibernate持久化的类时,提供与JavaBeans兼容的代码以及一个属性非常重要.
>
> ```java
> @Entity
> @Table(name = "product_", schema = "test", catalog = "")
> public class ProductEntity {
>     private int id;
>     private String name;
>     private Double price;
> 
>     @Id
>     @Column(name = "id")
>     public int getId() {
>         return id;
>     }
> 
>     public void setId(int id) {
>         this.id = id;
>     }
> 
>     @Basic
>     @Column(name = "name")
>     public String getName() {
>         return name;
>     }
> 
>     public void setName(String name) {
>         this.name = name;
>     }
> 
>     @Basic
>     @Column(name = "price")
>     public Double getPrice() {
>         return price;
>     }
> 
>     public void setPrice(Double price) {
>         this.price = price;
>     }
> 
>     @Override
>     public boolean equals(Object o) {
>         if (this == o) return true;
>         if (o == null || getClass() != o.getClass()) return false;
>         ProductEntity that = (ProductEntity) o;
>         return id == that.id &&
>                 Objects.equals(name, that.name) &&
>                 Objects.equals(price, that.price);
>     }
> 
>     @Override
>     public int hashCode() {
>         return Objects.hash(id, name, price);
>     }
> }
> 
> ```

## 2.创建对应的数据库和表

> ```mysql
> create database test;
> use test;
> create table product_(
> 	id int(11) not null auto_increment.
>     name varchar(30),
>     price float,
>     primary key(id)
> )default charset=UTF8;
> ```

## 3.导入Hibernate所依赖的jar包

![image-20201015194650156](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201015194650156.png)

## 4.创建映射文件className.hbm.xml

```xml
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-mapping PUBLIC
    "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
    "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<hibernate-mapping package="bean">

    <class name="ProductEntity" table="product_" schema="test">
        <id name="id" column="id">
            <generator class="native"/>
        </id>
        <property name="name" column="name"/>
        <property name="price" column="price"/>
    </class>
</hibernate-mapping>
```

## 5.创建hibernate.cfg.xml

```xml
<?xml version="1.0"?>
        <!DOCTYPE hibernate-configuration PUBLIC
                "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
                "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>

        <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="connection.url">jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8</property>
        <property name="connection.username">root</property>
        <property name="connection.password">123456</property>

        <property name="dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="show_sql">true</property>
        <property name="hibernate.hbm2ddl.auto">update</property>
        <mapping resource="ProductEntity.hbm.xml"/>
    </session-factory>
</hibernate-configuration>
```

## 5.进行测试

测试类:

```java
public class ProductTest {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session s=sf.openSession();
        s.beginTransaction();
        ProductEntity p=new ProductEntity();
        p.setName("iphone7");
        p.setPrice(7000.0);
        s.save(p);
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
}
```

结果:![image-20201015195200728](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201015195200728.png)

![image-20201015195210914](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201015195210914.png)

# 10.Hibernate--O/R映射

## 1.集合映射

> 如果实体或类具有特定变量的值的集合,那么可以使用java中可用的任何一个集合接口来映射这些值,Hibernate可以持久化Java.util.Mapjava.util.Set,java.util.SortedMap,java.util.SortedSet,java.util.List和所有持久性实体或值数组的实例
>
> | 序号 | 集合类型和映射说明                                           |
> | ---- | ------------------------------------------------------------ |
> | 1    | java.util.Set:这与<set>元素映射,并由java.util.HashSet初始化  |
> | 2    | java.util.SortedSet:由<set>元素映射,使用java.util.TreeSet初始化,该类型属性可以被设置为一个比较器或者自然顺序 |
> | 3    | java.util.List:由<list>元素映射,由java.util.ArrayList初始化  |
> | 4    | java.util.Collection:由<bag>或<ibag>元素映射,由java.util.ArrayList初始化 |
> | 5    | java.util.Map:由<map>元素映射,并用java.util.HashMap初始化    |
> | 6    | java.util.SortedMap:由<map>元素映射,使用java.util.TreeMap初始化,该类型属性可以被设置为一个比较器或自然熟悉怒 |
>
> 

## 2.实体类之间的关联映射

> 实体类之间的关联以及表之间的关系的映射是ORM的灵魂,以下是表示对象之间关系基数的四种方式,关联映射可以是单向的也可以是双向的
>
> | 序号 | 映射类型和描述                     |
> | ---- | ---------------------------------- |
> | 1    | 多对一:使用Hibernate映射多对一关系 |
> | 2    | 一对一:使用Hibernate映射一对一关系 |
> | 3    | 一对多:使用Hibernate映射一对多关系 |
> | 4    | 多对多:使用Hibernate映射多对多关系 |

## 3.组件映射

> 实体类很可能可以引用另一个类作为成员变量,如果所引用的类没有自己的声明周期,并且完全取决于拥有实体类的生命周期,则因此将所引用的类称为Component类

# 11.Hibernate---注解

## 1.介绍

> Hibernate注解是为对象和关系表映射提供元数据的强大方法,所有元数据与代码一起被合并到POJO Java文件中,有助于用户在开发过程中同时理解表结构和POJO.
>
> 如果要使应用程序移植到其他符合EJB 3的ORM应用程序,则必须使用注解来表示映射信息,到那时,如果仍然希望更大的灵活性,则推荐使用XML文件映射

## 2.Hibernate注解的环境设置

> 首先确保JDK版本在JDK5.0以上,以利用对注解的支持.

## 3.带注释的类实例

> 表结构如图所示![image-20201015201116520](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201015201116520.png)
>
> 对Employee类进行注解映射
>
> ```java
> @Entity
> @Table(name="EMPLOYEE")
> public class Employee{
>     @Id @GeneratedValue
>     @Column(name="id")
>     private int id;
>     @Column(name="first_name")
>     private String firstName;
>     @Column(name="last_name")
>     private String lastName;
>     @Column(name="salary")
>     private int salary;
>     public Employee() {}
>    
>    public int getId() {
>       return id;
>    }
>    
>    public void setId( int id ) {
>       this.id = id;
>    }
>    
>    public String getFirstName() {
>       return firstName;
>    }
>    
>    public void setFirstName( String first_name ) {
>       this.firstName = first_name;
>    }
>    
>    public String getLastName() {
>       return lastName;
>    }
>    
>    public void setLastName( String last_name ) {
>       this.lastName = last_name;
>    }
>    
>    public int getSalary() {
>       return salary;
>    }
>    
>    public void setSalary( int salary ) {
>       this.salary = salary;
>    }
> }
> ```
>
> Hibernate检测到@Id注解位于字段上,并假定它应在运行时直接通过字段访问对象的属性.如果将@Id注解放在getId()方法上,则默认情况下将允许通过getter和setter方法访问属性,因此,遵循所选策略,所有有其他注释也将放置在字段或者getter方法上

## 4.注释详解

1. @Entity:     EJB3标准注解包含在javax.persistence包中,因此首先要导入此包,其次,在Employee类上使用@Entity注解,该类将此类标记为实体Bean,因此它必须具有无参数构造函数,该构造函数至少在保护范围内可见.

2. @Table:     该注解允许指定用于将实体保留在数据库中表的信息信息.

   1. @Table注解提供了四个属性,可以覆盖表的name名称,catalogue目录,schema架构,并对表中的列施加约束,上述示例仅使用表名

3. @Id and @GeneratedValue:每个实体bean将具有一个主键,可以在类上使用@Id主键对其进行注解,主键可以是单个字段,也可以是多个字段的组合,取决于表结构.

   默认情况下,@Id主键自动确定要使用的最合适的主键生成策略,但是可以通过应用@GeneratedValue主键覆盖这个策略,该注解采用两个参数,策略和生成器.

4. @Column:  该批注用于指定字段或属性将映射到的列的详细信息,可以将列注解与一下最常用的属性一起使用

   1. name属性允许显示指定列的名称
   2. length:属性允许用于映射值的列的大小
   3. nullable:允许在生成架构时将列标记为not null
   4. unique:允许将该列标记为仅包含唯一值.

## 5.进阶,使用Hibernate进行数据库的增删查改操作

```java
public class EmployeeTest {
    private static SessionFactory factory;

    public static void main(String[] args) {
        factory=new Configuration().configure().buildSessionFactory();
        addEmployee("A","b",100);
        addEmployee("C","d",200);
        addEmployee("E","f",300);
        listEmployee();
        updateEmployee(5,500);
        deleteEmployee(7);
        listEmployee();
    }

    private static void deleteEmployee(int id) {
        Session session=factory.openSession();
        session.beginTransaction();
        Employee employee= (Employee) session.get(Employee.class,id);
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
    }

    private static void updateEmployee(int id,int salary) {
        Session session=factory.openSession();
        session.beginTransaction();
        Employee employee= (Employee) session.get(Employee.class,id);
        employee.setSalary(salary);
        session.update(employee);
        session.getTransaction().commit();
        session.close();
    }

    private static void listEmployee() {
        Session session=factory.openSession();
        session.beginTransaction();
        List employees=session.createQuery("FROM Employee ").list();
        for (Object object : employees) {
            Employee employee= (Employee) object;
            System.out.print("FirstName: "+employee.getFirstName());
            System.out.print("LastName: "+employee.getLastName());
            System.out.print("salary: "+employee.getSalary());
            System.out.println();
        }
        session.getTransaction().commit();
        session.close();
    }

    private static void addEmployee(String firstName, String lastName, int salary) {
        Session session=factory.openSession();
        session.beginTransaction();
        Employee employee=new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setSalary(salary);
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }
}
```

# 12.Hibernate----查询语言

> Hibernate查询语言(HQL)是一种面向对象的查询语言,类似于SQL,但不是对表和列进行操作,而是与持久对象及其属性一起使用.Hibernate将HQL查询转换为常规的SQL查询,这些查询又对数据库执行操作.
>
> 诸如SELECT,FROM和WHERE等关键字不区分大小写,但是在HQL中,表和列名之类的属性区分大小写

## FROM 子句

> 如果要将完整的持久对象加载到内存,将会使用到FROM子句,例:
>
> ```java
> String hql="FROM Employee";
> Query query=session.createQuery(hql);
> List results=query.list();
> ```
>
> 如果需要完全限定HQL的类名,只需要指定包和类名就可以了,比如Employee在cn.f33v.bean包中
>
> ```java
> String hql="FROM cn.f33v.bean.Employee";
> Query query=session.createQuery(hql);
> List result=query.list();
> ```

## AS 子句

> AS子句可以用于分配别名类在HQL中查询,尤其有很长的查询时候,例:
>
> ```java
> String hql="FROM Employss AS E";
> Query query=session.createQuery(hql);
> List result=query.list();
> ```
>
> AS子句是可选的,即可以写也可以不写,可以在类名后面直接指定别名,例
>
> ```java
> String hql="FROM Employee E";
> Query query=session.createQuery(hql);
> List result=query.list();
> ```

## SELECT子句

> SELECT子句提供结果集然后FROM子句更多的控制,如果要获取对象的少数属性而不是完整的对象,可以使用SELECT子句,例
>
> ```java
> String hql="SELECT E.firstName FROM Employee E";
> Query query=session.createQuery(hql);
> List result=query.list();
> ```
>
> 注意:Employee.firstName是Employee对象的属性,而不是Employee表的字段

## WHERE子句

> 如果要缩小从存储返回的特定对象,可以使用WHERE子句.例:
>
> ```java
> String hql="FROM EMPLOYEE E WHERE E.id=10";
> Query query=session.createQuery(hql);
> List result=query.list();
> ```

## ORDER BY子句

> 要对HQL查询结果进行排序,可以使用ORDER BY子句,可以对结果集中的对象的任何属性进行排序(升序(ASC)或者降序(DESC)),例:
>
> ```java
> String hql="FROM Employee E WHERE E.id>10 ORDER BY E.salary.DESC";
> Query query=session.createQuery(hql);
> List result=query.list();
> ```
>
> 如果要按多个属性排序,只需要将其他属性添加到ORDER BY子句的末尾,以逗号分隔即可,例
>
> ```java
> String hql="FROM Employee E WHERE E.id>10 ORDER BY E.firstName DESC,E.salary DESC";
> Query query=session.createQuery(hql);
> List result=query.list();
> ```

## GROUP BY子句

> GROUP BY运行Hibernate从数据库中提取信息,并根据属性的值对信息进行分组,并且通常使用结果包括总值,例:
>
> ```java
> String hql="SELECT SUM(E.salary),E.firstName FROM Employee E GROUP BY E.firstName";
> Query query=session.createQuery(hql);
> List result=query.list();
> ```
>
> 

## Using Named Parameters

> Hibernate在HQL查询中支持命名参数,使编写接收用户输入的HQL查询变得容易,并且不必防御SQL注入攻击,以下是使用命名参数的示例:
>
> ```java
> String hql="FROM Employee E WHERE E.id= :employee_id";
> Query query=session.createQuery(hql);
> query.setParameter("qmployee_id",10);
> List result=query.list();
> ```
>
> 作用解析:使用employee_id作为E.id的参数绑定,然后设置值,然后使用setParameter进行值更新,就类似于SQL语句中的where id=?,只是这里用命名参数来代表,即查询id=10的行

## UPDATE子句

> 批量更新是Hibernate 3中HQL的新增功能,在Hibernate 3中删除工作的方式与Hibernate 2中进行删除的方式已经不同.查询接口现在包含一个称为executeUpdate()的方法,用于执行HQL UPDATE或者DELETE语句.
>
> UPDATE子句可以用于更新一个或多个对象的一个或多个属性,例:
>
> ```java
> String hql="SELECT Employee set salary= :salary WHERE id=:employee_id";
> Query query=session.createQuery(hql);
> query.setParameter("salary",1000);
> query.setParameter("employee_id",10);
> int result=query.executeUpdate();
> System.out.println("Rows affected:"+result);
> ```

## DELETE子句

> DELETE子句可以用于删除一个或多个对象,例
>
> ```java
> String hql="SELECT FROM Employee WHERE id=:employee_id";
> Query query=session.createQuery(hql);
> query.setParameter("employee_id",10);
> int result=query.executeUpdate();
> System.out.println("Rows affected:"+result);
> ```
>
> 

## INSERT INTO子句

> HQL仅可以将记录从一个对象插入到另一个对象的情况下才支持INSERT INTO子句,例
>
> ```java
> String hqp="INSERT INTO Employee(firstName,lastName,salary) SELECT firstName,lastName salary FROM old_employee";
> Query query=session.createQuery(hql);
> int result=query.executeUpdate();
> System.out.println("Rows affected:"+result);
> ```
>
> 

## 聚合方法

> HQL也支持聚合方法
>
> 1. avg(property name):平均值
> 2. count(property name or *):计数
> 3. max(property name):最大值
> 4. min(property name):最小值
> 5. sum(property name):和

## 分页查询

> 1. Query setFirstResult(int startPosition):此方法采用一个整数,该整数表示结果集中的第一行,从0开始
> 2.  Query setMaxResults(int maxResult):该方法告诉Hibernate检索固定数量的对象的maxResults
>
> ```java
> String hql="FROM Employee";
> Query query=session.createQuery(hql);
> query.setFirstResult(1);
> query.setMaxResults(10);
> List result=query.list();
> ```
>

# 13.Hibernate---Criteria Queries

> Hibernate提供了处理对象以及RDBMS表中可用数据的替代方法,方法之一就是Criteria API,它可以以编程方式去建立条件查询对象,在其中可以应用过滤规则和逻辑条件.
>
> Hibernate Session接口提供了createCriteria()方法,该方法可用于创建Criteria对象,当应用程序执行条件查询时,该Criteria对象返回持久性对象的类的实例.
>
> 示例:
>
> ```java
> Criteria cr=session.createCriteria(Employee.class);
> List results=cr.list();
> ```

## Restrictions with Criteria 限制条件

> 可以通过Criteria对象的add()方法为条件查询添加限制.示例:
>
> ```java
> Criteria cr=session.createCriteria(Employee.class);
> cr.add(Restrictions.eq("salary",2000));
> List reults=cr.list();
> ```
>
> 以下是一些涵盖不同场景的示例,可以根据需要使用
>
> ```java
> Criteria cr=session.createCriteria(Employee.class);
> //获取salary超过2000的记录
> cr.add(Restrictions.gt("salary",2000));
> //获取salary小于2000的记录
> cr.add(Restrictions.lt("salary",2000));
> //获取firstName以zara开头的记录
> cr.add(Restrictions.like("firstName","zara%"));
> //获取salary在1000到2000之间的记录
> cr.add(Restrictions.between("salary",1000,2000));
> //检查所给的属性是否为null
> cr.add(Restrictions.isNull("salary"));
> //检查所给的属性是否不为null
> cr.add(Restrictions.isNotNull("salary"));
> //检查所给的属性是否为empty
> cr.add(Restrictions.isEmpty("salary"));
> //检查所给的属性是否不为empty
> cr.add(Restrictions.isNotEmpty("salary"));
> ```
>
> 也可以使用LogicalExpression限制创建AND或者OR条件,
>
> ```java
> Criteria cr=session.createCriteria(Employee.class);
> Criterion salary=Restrictions.get("salary",2000);
> Criterion name=Restrictions.like("firstName","zara%");
> //获取记录通过OR
> LogicalExpression orExp=Restrictions.or(salary,name);
> cr.add(orExp);
> //获取记录通过AND
> LogicalExpression orExp=Restrictions.and(salary,name);
> cr.add(orExp);
> List results=cr.list();
> ```

## 使用条件分页

> 用于分页的Criteria接口有两种方法
>
> 1. public Criteria setFirstResult(int firstResult):此方法采用一个整数,该整数表示结果集中的第一行,从0开始
>
> 2. public Criteria setMaxResults(int maxResults):此方法告诉Hibernate检索固定数量的数量的maxResults
>
>    ```java
>    Criteria cr=session.createCriteria(Employee.class);
>    cr.setFirstRsult(1);
>    cr.setMaxResults(10);
>    List results=cr.list();
>    ```
>
>    结合上述两个方法,可以创建分页组件,一次获得10条记录

## Sorting the Results

> Criteria API提供org.hibernate.criterion.Order类,以根据对象的属性之一对结果集进行升序或降序排序.
>
> ```java
> Criteria cr=session.createCriteria(Employee.class);
> cr.add(Restrictions.gt("salary",2000));
> cr.addOrder(Order.desc("salary"));
> cr.addOrder(Order.asc("salary"));
> List results=cr.list();
> ```

## Projctions & Aggregations

> Criteria API提供了org.hibernate.criterion.Projections类,该类可用于获取属性值的平均值,最大值或最小值.Projections类和Restrictions类想死,因为它也提供了几种获取Projections实例的静态工厂方法
>
> ```java
> Criteria cr=session.createCriteria(Empolyee.class);
> //获取记录的条数
> cr.setProjection(Projections.rowCount());
> //获取属性的平均值
> cr.serProjection(Projections.avg("salary"));
> //获取没有重复的记录的条数
> cr.setProjection(Projections.countDistinct("firstName"));
> //获取最大值
> cr.setProjection(Projections.max("salary"));
> //获取最小值
> cr.setProjection(Projections.min("salary"));
> //获取属性和
> cr.setProjection(Projetcions.sum("salary"));
> ```

## Criteria示例

### 表

```mysql
create table EMPLOYEE(
	id int not null auto_increment,
    first_name varchar(20) default null,
    last_name varchar(20) default null,
    salary int default null,
    primary key(id)
);
```



### 实体类

```java
public class Employee {
   private int id;
   private String firstName; 
   private String lastName;   
   private int salary;  

   public Employee() {}
   
   public Employee(String fname, String lname, int salary) {
      this.firstName = fname;
      this.lastName = lname;
      this.salary = salary;
   }
   
   public int getId() {
      return id;
   }
   
   public void setId( int id ) {
      this.id = id;
   }
   
   public String getFirstName() {
      return firstName;
   }
   
   public void setFirstName( String first_name ) {
      this.firstName = first_name;
   }
   
   public String getLastName() {
      return lastName;
   }
   
   public void setLastName( String last_name ) {
      this.lastName = last_name;
   }
   
   public int getSalary() {
      return salary;
   }
   
   public void setSalary( int salary ) {
      this.salary = salary;
   }
}
```



### 映射

```xml
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE hibernate-mapping PUBLIC
"-//Hibernate/Hibernate Mapping DTD//EN"
"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<hibernate-mapping>
	<class name="Employee" table="EMPLOYEE">
    	<meta attribute="class-descriiption">
        	This class contains the employee detail
        </meta>
        <id name="id" type="int" column="id">
        	<generator class="nactive"/>
        </id>
        <property name="firstName" column="first_name" type="string"/>
        <property name="lastName" column="last_name" type="string"/>
        <property name="salary" column="salary" type="int"/>
    </class>
</hibernate-mapping>
```



#### 使用

```java
public class EmployeeTest2 {
    private static SessionFactory factory;
    public static void main(String[] args) {
        factory=new Configuration().configure().buildSessionFactory();
        
        addEmployee("Zara","Ali",2000);
        addEmployee("Daisy","Das",5000);
        addEmployee("John","Paul",5000);
        addEmployee("Mohd","Yasee",3000);

         
        listEmployees();
        countEmployee();
        totalSalary();
    }

    private static void totalSalary() {
        Session session=factory.openSession();
        session.beginTransaction();
        Criteria cr=session.createCriteria(Employee.class);
        cr.setProjection(Projections.sum("salary"));
        List totalSalary=cr.list();
        System.out.println("Total Salary:"+totalSalary.get(0));
        session.getTransaction().commit();
        session.close();
    }

    private static void countEmployee() {
        Session session=factory.openSession();
        session.beginTransaction();
        Criteria cr=session.createCriteria(Employee.class);
        cr.setProjection(Projections.rowCount());
        List rowCount=cr.list();
        System.out.println("Total Count:"+rowCount.get(0));
        session.getTransaction().commit();
        session.close();
    }

    private static void listEmployees() {
        Session session=factory.openSession();
        session.beginTransaction();
        Criteria cr=session.createCriteria(Employee.class);
        cr.add(Restrictions.gt("salary",2000));
        List employees=cr.list();
        for (Object object : employees) {
            Employee employee= (Employee) object;
            System.out.print("FirstName:"+employee.getFirstName()+"   LastName: "+employee.getLastName()+"   salary: "+employee.getSalary());
            System.out.println();
        }
        session.getTransaction().commit();
        session.close();
    }

    private static void addEmployee(String firstName, String lastName, int salary) {
        Session session=factory.openSession();
        session.beginTransaction();
        Employee employee=new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setSalary(salary);
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }


}

```

# 14.Hibernate----缓存

> 缓存是一种增强系统性能的机制.它是位于应用程序和数据库之间的缓冲存储器.告诉缓存存储器存储最近使用的数据项,以尽可能减少数据库命中的次数.
>
> 缓存对Hibernate也很重要,它利用了如下所示的所及缓存方案.![image-20201016225103508](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201016225103508.png)

## 一级缓存

> 一级缓存是会话缓存,它是所有请求都必须经过的强制性缓存,在讲对象提交到数据库之前,Session对象将自己保持在自己的缓存之下.
>
> 如果对一个对象发出多个更新,则Hibernate会尝试尽肯能延迟执行更新,以减少发出的更新SQL语句的数量.如果关闭会话,则所有正在缓存的对象都会丢失,并在数据库中保留或更新.

## 二级缓存

> 第二级缓存是可选的缓存,在尝试在第二级缓存中定位对象之前,始终会咨询第一级缓存,二级缓存可以基于每个类和每个集合进行配置,并且主要负责跨会话缓存对象.
>
> Hibernate可以使用任何第三方缓存.API提供了org.hibernate.cahce.CacheProvider接口,必须实现该接口才能为Hibernate提供缓存实现的句柄.

## 查询级缓存

> Hibernate还为查询结果集实现了一个缓存,该缓存与第二级缓存紧密集成.
>
> 这是可选功能,并且需要两个额外的物理缓存区域,这些区域保存缓存的查询结果和上次更新表的时间戳.仅对使用相同参数频繁运行的查询有用.

## 第二级缓存

> 默认情况,Hibernate都使用一级缓存,而开发人员无需使用一级缓存,因此直接进入可选的二级缓存,并非所有类都受益于缓存,因此能禁用二级缓存很重要.
>
> Hibernate二级缓存设置分为两个步骤,首先,必须决定使用哪种并发策略,之后,可以使用缓存提供程序配置缓存过期和物理缓存属性.

## 并发策略

> 并发策略是中介程序,负责将数据项存储在缓存中并从缓存中检索他们,如果要启用二级缓存,则必须为每个持久类和集合决定要使用的缓存并发策略
>
> 1. 事务性:对于很少读取的更新,在防止并发事务中过时的数据非常重要的情况下,可对大多数只读数据使用此策略.
> 2. 读写:对于罕见的更新,在防止并发事务中过时的数据至关重要的情况下,再次对大多数只读数据使用此策略.
> 3. 非严格读写:此策略无法保证缓存和数据库之间的一致性,如果数据几乎不变,并且陈旧数据的可能性很小,则不必使用此策略
> 4. 只读:适用于数据的并发策略,该策略永远不变,仅用于参考数据.
>
> 如果要对Employee类使用二级缓存,那么可以添加必要的映射元素,以告知Hibernate使用读写策略缓存Employee实例
>
> ```xml
> <?xml version="1.0" encoding="utf-8"?>
> <!DOCTYPE hibernate-mapping PUBLIC
> "-//Hibernate/Hibernate Mapping DTD//EN"
> "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
> <hibernate-mapping>
> 	<class name="Employee" table="EMPLOYEE">
>     	<meta attribute="class-descripton">
>         	This class contains the emloyee detail
>         </meta>
>         <chche usage="read-write"/>
>         <id name="id" type="int" column="id">
>         	<generator class="native"/>
>         </id>
>         <property name = "firstName" column = "first_name" type = "string"/>
>       <property name = "lastName" column = "last_name" type = "string"/>
>       <property name = "salary" column = "salary" type = "int"/>
>     </class>
> </hibernate-mapping>
> ```
>
> useage="read-write"属性告诉Hibernate对定义的缓存使用读写并发策略

## 缓存提供者

> 在考虑并发策略后的下一步,将使用缓存候选类选择一个缓存提供程序,Hibernate强制开发者为整个应用程序选择单个缓存提供程序
>
> 1. EHCache-高速缓存:可以缓存在内存或磁盘上,也可以缓存在集群缓存中,并且支持可选的Hiber查询结果缓存
> 2. OSCache-OS缓存:通过一组丰富的到期策略和查询缓存支持,支持在单个JVM中缓存到内存和磁盘.
> 3. warmCache:基于JGroups的集群缓存,它使用集群失效,但不支持Hibernate查询缓存
> 4. JBoss Cache:完全事务复制集群缓存也基于JGroups多博库,支持复制或失效,同步或异步通信
>
> 开发人员会在hibernate.cfg.xml配置文件中指定一个缓存提供程序,该示例选择EHCache作为二级缓存提供者
>
> ```xml
> <?xml version="1.0" encoding="utf-8"?>
> <!DOCTYPE hibernate-configuration SYSTEM
> "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
> <hibernate-configuration>
> 	<session-factory>
>     	<property name="hibernate.dialect">
>         	org.hibernate.dialect.MySQLDialect
>         </property>
>         <property name="hibernate.connection.driver_class">
>         	com.mysql.jdbc.Driver
>         </property>
>         <property name="hibernate.connection.url">
>         	jdbc:mysql://localhost/test
>         </property>
>         <property name="hibernate.connection.username">
>         	root
>         </property>
>         <property name="hibernate.connection.password">
>         	123456
>         </property>
>         <property name="hibernate.cache.provider_class">
>         	org.hibernate.cache.EHCacheProvider
>         </property>
>         <mapping resource="Employee.hbm.xml"/>
>     </session-factory>
> </hibernate-configuration>
> ```
>
> 然后,需要指定缓存区域的属性,EHCache具有自己的配置文件ehcache.xml,该文件应位于应用程序的CLASSPATH中,ehcache.xml中用于Employee类的缓存配置可能看起来像这样
>
> ```xml
> <diskStore path="java.io.tmdir"/>
> <defaultCache
>               maxElementsInMemory="1000"
>               eternal="false"
>               timeToIdleSeconds="120"
>               timeToLiveSecondes="120"
>               overflowToDisk="true"/>
> <cache name="Employee"
>        maxElementsInMemory="500"
>        eternal="true"
>        timeToIdleSeconds="0"
>        timeToLiveSeconds="0"
>        overflowToDisk="false"/>
> ```
>
> 这样Employee类和Hibernate启用了第二级缓存,当导航到Employee或按标识符加载Employee时,都会命中二级缓存.
>
> 应该分析所有类,并为每个类选择适当的缓存策略,有时,二级缓存可能会降低应用程序性能,因此,建议先对应用程序进行基准测试,而不启用缓存,然后在启用最适合的缓存并检查性能.如果缓存不能改善系统性能,则没必要启用任何类型缓存

## 查询级缓存

> 要使用查询级缓存,必须先使用配置文件中的hibernate.cache.use_query_cache="true"属性将其激活,通过将此属性设为true,可以使Hibernate内存中创建必要的缓存来保证查询和标识符集.
>
> 示例:
>
> ```java
> Session session=factory.openSession();
> Query query=session.createQuery("FORM Employee");
> query.setCacheable(true);
> List users=query.list();
> SessionFactory.closeSession();
> ```

# 14.Hibernate----批处理

> 考虑一种情况,当需要使用Hibernate将大量记录上载到数据库时,以下是使用Hibernate实现此目的的代码片段.
>
> ```java
> Session session=factory.openSession();
> Transaction rx=session.beginTransaction();
> for(int i=0;i<100000;i++){
>     Employee employee=new Employee(....);
>     session.save(employee);
> }
> tx.commit();
> session.close();
> ```
>
> 默认情况下,Hibernate将所有持久化的对象缓存在会话级缓存中,最终应用程序将在第50000行附近出现OutOfMemoryException崩溃,如果将批处理与Hibernate一起使用,则可以解决此问题.
>
> 要使用批处理功能,首先将hibernate.jdbc.batch_size设置为批处理大小,根据对象大小将其设置为20到50,这将告诉Hibernate容器每隔X行就进行批量插入.示例:
>
> ```java
> Session session=factory.opernSession();
> Transaction tx=session.beginTransaction();
> for(int i=0;i<100000;i++){
>     Employee employee=new Employee(...);
>     session.save(employee);
>     if(i%50==0){
>         session.flush();
>         session.clear();
>     }
> }
> tx.commit();
> session.close();
> ```
>
> 上面的代码对于INSERT操作可以很好的工作,但是如果愿意进行UPDATE操作,则可以使用以下代码实现
>
> ```java
> Session session=factory.openSession();
> Transaction tx=session.beginTransaction();
> ScrollableResulrs employeeCursor=session.createQuery("FROM Employee").scroll();
> int count=0;
> while(employeeCursor.next()){
>     Employee employee=(Employee)employeeCursor.get(0);
>     employee.updateEmployee();
>     session.update(employee);
>     if(++count%50==0){
>         session.flush();
>         session.clear();
>     }
> }
> tx.commit();
> session.close();
> ```
>
> 