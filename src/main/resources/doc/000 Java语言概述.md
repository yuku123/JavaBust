# Java语言概述

java已经发展了很多年头，当下互联网大部分用的是1.8(JDK8)版本，再往后可以预见的是11版本(JDK11),因为这两个版本是长期支持版本，较稳定。

一些传统的老公司用的可能是1.5，1.6; 1.5版本引入了很多高级特性，是一个万众瞩目的版本，同样，1.8也是一个里程碑式的版本，引入了一个有趣的特性。

## Java语言的运行机制

### 高级语言的运行机制

纵观整个it的发展史，刚开始是没有高级语言的，只有"机器语言"，类似于跑在单片机上那种机器可以直接识别的代码指令。

机器码执行效率很高，但是编写代码很费劲，开发效率极差。

我是机械专业的，接触过这种编程，苦不堪言，考试差点不及格。当时我就心里想，这个东西是人玩的吗？难不成我的智商有问题？

后来又聪明又懒惰的程序员们就开始动脑筋，一步一步把机器码的编程逐步逐步转换为对人类友好的编程模式，然后各种富有语义化的编程语言就诞生了。

这里就会有两种方式解决这样的问题：

1. 编译型执行方式
2. 解释型执行方式

先来第一种：什么叫编译型执行呢？

作为一个人，写出像文章一样的代码，但是机器肯定不能理解你写的是什么东西。

要解决这个问题，那么就造一个东西，这个东西可以一口气把你的文章转变成机器码(编译过程)，机器就知道你要干什么了。

目前类似于c,c++，就属于这种编译执行。

第二种：解释型执行方式

刚提到编译执行时一口气把所有的代码做转换告诉机器干什么，那我能不能一句一句翻译给机器听呢？

可以，这种方式就是解释型执行方式

当下很多脚本语言，例如python,shell就是这么玩儿的

两个有啥区别呢？

解释型执行方式启动快，但是执行过程慢一些，编译执行刚开始要花很多时间做编译，但是后面执行快一些，毕竟后面执行的都已经是机器码了。

### Java执行方式

java就比较特殊，她是编译+解释。

java编译之后生成的不是直接的机器码，而是字节码(.class文件)，然后这个.class文件给到JVM(虚拟机，当下可以理解为解释器)，在各个平台上的jvm不一样，但是可以接受同一份.class。

这样就可以做到，"一次编写，到处运行"，相同的class,能不能得到相同的结果全靠各个平台上的JVM。

JVM,我们成为虚拟机，也就是机器里面的虚拟化机器，因此JVM内部结构上是和实体机器有点类似，具体结构我们后面会谈到，这里的学问就太大了。

## Java JDK 安装

jdk安装很简单，windows傻瓜式install一下，配一下环境变量

mac也同样，dmg点击一下，也就自动安装了

linux不同版本安装方式有差异，但是问题不大，关键是JAVA_HOME的环境变量配置，可以使用命令傻瓜式安装

在此不做详细解释，做程序员的装软件的技能是一定要有的，耐心也一定要有，上网查资料->知道怎么搞->真正搞出来，这个过程都需要沉下心来搞一遍。

## 第一个java程序

入门嘛，helloWorld很重要，我还记得我上一任老板，老是问面试的候选人helloWorld怎么写，竟然还是有很多面试人写错。出发点是好的，但也仅限于怎么写。

按我的脾气，helloWorld深入问下去，可以问class的加载流程，jvm结构，字节码是怎么回事，这些都是很高级的话题了。平时工作基本用不着，但是却是区分高级工程师和弱鸡工程师的门槛。

### java helloWorld源码

```java
/**
 * hello word 程序
 * */
public class Day001 {
    public static void main(String[] args) {
        System.out.println("hello word");
    }
}
```

简单粗暴的程序，可以考量的点还是很多的。

当你jvm安装完之后，意味着在命令行上打java相关指令是有反应的

````
// terminal 打 java指令，会蹦出老长的东西
zifang@localhost ~ java
Usage: java [options] <mainclass> [args...]
           (to execute a class)
   or  java [options] -jar <jarfile> [args...]
           (to execute a jar file)
   or  java [options] -m <module>[/<mainclass>] [args...]
       java [options] --module <module>[/<mainclass>] [args...]
           (to execute the main class in a module)
   or  java [options] <sourcefile> [args]
           (to execute a single source-file program)

// 后面太长了，截去

// termial 打 javac指令 ， 会蹦出老长的东西
zifang@localhost ~ javac
Usage: javac <options> <source files>
where possible options include:
  @<filename>                  Read options and filenames from file
  -Akey[=value]                Options to pass to annotation processors
  --add-modules <module>(,<module>)*
        Root modules to resolve in addition to the initial modules, or all modules
        on the module path if <module> is ALL-MODULE-PATH.
  --boot-class-path <path>, -bootclasspath <path>
        Override location of bootstrap class files
  --class-path <path>, -classpath <path>, -cp <path>
        Specify where to find user class files and annotation processors
 // 后面太长了，截去

````

javac 是拿来编译(编译 .java文件 生成 .class)用的， java 则是执行(执行 .class)用的