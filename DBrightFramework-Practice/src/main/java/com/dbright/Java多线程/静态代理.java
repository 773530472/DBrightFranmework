package com.dbright.Java多线程;

public class 静态代理 {
    public static void main(String[] args) {
        MyI myI  = new MyI();
        Agent agent = new Agent(myI);
        agent.Buy();
    }
}

//买房的公共接口
interface BuyHouse{
    void Buy();
}

class MyI implements BuyHouse {

    //对我来说，我只需负责拿钱，签字即可
    @Override
    public void Buy() {
        System.out.println("一百万，签合同，房子是我的了！");
    }
}

class Agent implements BuyHouse{
    private BuyHouse buyHouse;

    public Agent(BuyHouse buyHouse){
        this.buyHouse = buyHouse;
    }

    //先帮我准备合同等材料
    public void work1(){
        System.out.println("准备合同等材料~");
    }
    //带我去房管局办理手续
    public void work2(){
        System.out.println("带着客户去办手续~");
    }

    //中介收了我的钱，他得帮我准备购房材料，带着我跑购房流程等等
    @Override
    public void Buy() {
        work1();
        work2();
        //客户买房
        buyHouse.Buy();
    }
}
