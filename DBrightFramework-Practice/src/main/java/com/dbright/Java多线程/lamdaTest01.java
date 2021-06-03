package com.dbright.Java多线程;

public class lamdaTest01 {
    public static void main(String[] args) {

//        /**
//         * 多参数无返回
//         */
//        NoReturnMultiParam1 n1 = (int a,int b) ->{
//            System.out.println("多参数无返回:"+a+b);
//        };
//        n1.method(1,2);
//
//        /**
//         * 无参无返回值
//         */
//        NoReturnNoParam n2 = ()->{
//            System.out.println("无参无返回值");
//        } ;
//        n2.method();
//
//        /**
//         * 一个参数无返回
//         */
//        NoReturnOneParam n3 = (int a) -> {
//            System.out.println("一个参数无返回" + a);
//        };
//        n3.method(11);
//
//        /**
//         * 多个参数有返回值
//         */
//        ReturnMultiParam n4 = (int a,int b)->{
//            System.out.println("多个参数有返回值" + a);
//            return 1;
//        };
//        System.out.print("****"+n4.method(1, 3));
//
//        /**
//         * 无参有返回
//         */
//         ReturnNoParam n5 = ()->{
//             System.out.println("无参有返回");
//             return 1;
//         };
//        System.out.print("***"+n5.method());
//
//        /**
//         * 一个参数有返回值
//         */
//        ReturnOneParam n6 = (int a) ->{
//            System.out.println("一个参数有返回值"+a);
//            return a;
//        };
//        System.out.print("***"+n6.method(1));


        //1.简化参数类型，可以不写参数类型，但是必须所有参数都不写
        NoReturnMultiParam1 lamdba1 = (a, b) -> {
            System.out.println("简化参数类型");
        };
        lamdba1.method(1, 2);

        //2.简化参数小括号，如果只有一个参数则可以省略参数小括号
        NoReturnOneParam lambda2 = a -> {
            System.out.println("简化参数小括号");
        };
        lambda2.method(1);

        //3.简化方法体大括号，如果方法条只有一条语句，则可以胜率方法体大括号
        NoReturnNoParam lambda3 = () -> System.out.println("简化方法体大括号");
        lambda3.method();

        //4.如果方法体只有一条语句，并且是 return 语句，则可以省略方法体大括号
        ReturnOneParam lambda4 = a -> a+3;
        System.out.println(lambda4.method(5));

        ReturnMultiParam lambda5 = (a, b) -> a+b;
        System.out.println(lambda5.method(1, 1));
    }
}

/**多参数无返回*/
@FunctionalInterface
interface NoReturnMultiParam1 {
    void method(int a, int b);
}

/**无参无返回值*/
@FunctionalInterface
interface NoReturnNoParam {
    void method();
}

/**一个参数无返回*/
@FunctionalInterface
interface NoReturnOneParam {
    void method(int a);
}

/**多个参数有返回值*/
@FunctionalInterface
interface ReturnMultiParam {
    int method(int a, int b);
}

/*** 无参有返回*/
@FunctionalInterface
interface ReturnNoParam {
    int method();
}

/**一个参数有返回值*/
@FunctionalInterface
interface ReturnOneParam {
    int method(int a);
}