package com.dbright.Test;

public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);  //sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取系统类加载的父类加载器-->扩展类加载器
        ClassLoader parent = loader.getParent();
        System.out.println(parent);  //sun.misc.Launcher$ExtClassLoader@74a14482

        //获取扩展类加载器的父类加载器-->根加载器（C/C++）
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);  //null

        //测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("com.dbright.Test.Test02").getClassLoader();
        System.out.println(classLoader);  //sun.misc.Launcher$AppClassLoader@18b4aac2

        //测试JDK内部类是谁加载的
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);  //null

        // 如何获取系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        /*
        D:\Software\Java\jdk1.8\jre\lib\charsets.jar;
        D:\Software\Java\jdk1.8\jre\lib\deploy.jar;
        D:\Software\Java\jdk1.8\jre\lib\ext\access-bridge-64.jar;
        D:\Software\Java\jdk1.8\jre\lib\ext\cldrdata.jar;
        D:\Software\Java\jdk1.8\jre\lib\ext\dnsns.jar;
        D:\Software\Java\jdk1.8\jre\lib\ext\jaccess.jar;
        D:\Software\Java\jdk1.8\jre\lib\ext\jfxrt.jar;
        D:\Software\Java\jdk1.8\jre\lib\ext\localedata.jar;
        D:\Software\Java\jdk1.8\jre\lib\ext\nashorn.jar;
        D:\Software\Java\jdk1.8\jre\lib\ext\sunec.jar;
        D:\Software\Java\jdk1.8\jre\lib\ext\sunjce_provider.jar;
        D:\Software\Java\jdk1.8\jre\lib\ext\sunmscapi.jar;
        D:\Software\Java\jdk1.8\jre\lib\ext\sunpkcs11.jar;
        D:\Software\Java\jdk1.8\jre\lib\ext\zipfs.jar;
        D:\Software\Java\jdk1.8\jre\lib\javaws.jar;
        D:\Software\Java\jdk1.8\jre\lib\jce.jar;
        D:\Software\Java\jdk1.8\jre\lib\jfr.jar;
        D:\Software\Java\jdk1.8\jre\lib\jfxswt.jar;
        D:\Software\Java\jdk1.8\jre\lib\jsse.jar;
        D:\Software\Java\jdk1.8\jre\lib\management-agent.jar;
        D:\Software\Java\jdk1.8\jre\lib\plugin.jar;
        D:\Software\Java\jdk1.8\jre\lib\resources.jar;
        D:\Software\Java\jdk1.8\jre\lib\rt.jar;
        D:\NEU\learn\java\project\out\production\project;
        D:\NEU\learn\java\project\src\com\lib\commons-io-2.8.0.jar;
        D:\Software\IntelliJ IDEA 2020.1.4\lib\idea_rt.jar
         */
        //双亲委派机制：如果上层加载器存在不会使用下层定义类
    }
}
