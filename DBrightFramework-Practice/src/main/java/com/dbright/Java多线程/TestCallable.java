package com.dbright.Java多线程;

import java.util.concurrent.*;

/**
 * 多线程的实现方式三：实现Callable接口，重写call方法
 * 需要有返回值
 */
public class TestCallable implements Callable<String> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable testCallable = new TestCallable();

        //创建执行服务,这是相当于线程池，本篇文章不展开讲，后面会详细介绍这几个参数和使用方法
        ExecutorService service = Executors.newFixedThreadPool(1);

        //执行
        Future<String> result = service.submit(testCallable);

        //可获取线程的返回值
        String result1 = result.get();
        System.out.println("我是线程的返回值："+result1);

        //停止线程
        service.shutdownNow();
    }

    @Override
    public String call() throws Exception {
        System.out.println("我当然也是一个线程啦啦啦啦德玛西亚~~~");
        return "我是一个线程";
    }
}
