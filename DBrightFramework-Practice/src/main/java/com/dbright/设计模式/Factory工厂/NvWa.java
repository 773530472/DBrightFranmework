package com.dbright.设计模式.Factory工厂;

//使用泛型来作为入参
public class NvWa {
    public static void main(String[] args) {
        //声明阴阳八卦炉
        AbstractHumanFactory YinYangLu = new HumanFactory();

        //女娲第一次造人，火候不够，变成白人
        System.out.println("造出的第一批人种是白人～");
        Human WhiteHuman = YinYangLu.createHuman(WhiteHuman.class);
        WhiteHuman.getclolor();
        WhiteHuman.talk();

        //女娲第二次造人，火候过大，变成黑人
        System.out.println("造出的第二批人种是黑人～");
        Human BlackHuman = YinYangLu.createHuman(BlackHuman.class);
        BlackHuman.getclolor();
        BlackHuman.talk();

        //女娲第三次造人，火候完美，变成黄种人
        System.out.println("造出的第三批人种是黄种人～");
        Human YellowHuman = YinYangLu.createHuman(YellowHuman.class);
        YellowHuman.getclolor();
        YellowHuman.talk();

        System.out.println("sout打印输出：System.out.println()");
        System.out.println("psvm打印输出：public static void main(String[] args){}");
        System.out.println("这是一个@controller注解,作用是将该注解的类变成控制器");
    }
}
