package com.dbright.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.dbright.easyexcel.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DingYongJun
 */

//直接指定Danger类型，可以不指定
public class ExcelListenerJHA extends AnalysisEventListener<Employee> {

    //自定义用于暂时存储data,可以通过实例获取该值
    private List<Employee> datas = new ArrayList<>();

    //每解析一行调用一次invoke方法
    @Override
    public void invoke(Employee object, AnalysisContext context) {
        datas.add(object);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
    }

    //解析结束后销毁资源,clear()好像不能彻底回收内存。
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//        datas.clear();
    }

    //处理数据,将从excel中解析的数据处理成自己所需要的格式,下一步入库操作
    public void processDatas() throws NoSuchFieldException {

        //去除前面第一个表头数据
        datas.remove(datas.get(0));

        doSomething();//rpc入库操作

        datas.clear();//最后需要销毁资源
    }

    //根据自己的业务做处理，也就是用mapper层保存到数据库了
    private void doSomething() {

    }
}