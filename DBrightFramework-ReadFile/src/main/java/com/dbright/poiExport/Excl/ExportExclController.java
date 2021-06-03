package com.dbright.poiExport.Excl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dbright.poiExport.utils.exclUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @Description: 导出excl
 * @Param: [params]
 * @return: java.util.Map<java.lang.String,java.lang.Object>
 * @说明  该导出有一定的限制性，通常情况我们为了保证数据的及时性，都是从库里面拿数据来做导出。
 *         该导出只能使用get请求，也就是前端只能用window.location.href来调取下载，因为ajax不支持response流
 * @Author: DingYongJun
 */
@RestController
@RequestMapping("/export")
public class ExportExclController {

    @RequestMapping(value = "/excelDownload",method = RequestMethod.GET)
    public void excelDownload(HttpServletResponse response,@RequestParam Map<String,Object> paramsMap) throws IOException {
        List<Map<String,Object>> stratList = new ArrayList<Map<String, Object>>();
        //模拟数据，前端传过来是以json格式传,前端如果是get请求，不同浏览器会对url的长度有限制，一般是2k字节左右。
        String str = "[{\n" +
                "\t\"suozaiquxian\": \"河东区\",\n" +
                "\t\"suoshuxingye\": \"危险化学品\",\n" +
                "\t\"qiyemingcheng\": \"中化道达尔燃油有限公司天津祁连路加油站\",\n" +
                "\t\"yizhenggai\": \"0\",\n" +
                "\t\"id\": \"1363\"\n" +
                "}, {\n" +
                "\t\"suozaiquxian\": \"河东区\",\n" +
                "\t\"suoshuxingye\": \"危险化学品\",\n" +
                "\t\"qiyemingcheng\": \"中国石化销售股份有限公司天津石油分公司河东东风桥加油站\",\n" +
                "\t\"yizhenggai\": \"0\",\n" +
                "\t\"id\": \"1125\"\n" +
                "}, {\n" +
                "\t\"suozaiquxian\": \"河东区\",\n" +
                "\t\"suoshuxingye\": \"危险化学品\",\n" +
                "\t\"qiyemingcheng\": \"中国石化销售股份有限公司天津石油分公司河东唐口加油站\",\n" +
                "\t\"yizhenggai\": \"0\",\n" +
                "\t\"id\": \"334\"\n" +
                "}, {\n" +
                "\t\"suozaiquxian\": \"河东区\",\n" +
                "\t\"suoshuxingye\": \"危险化学品\",\n" +
                "\t\"qiyemingcheng\": \"中国石化销售股份有限公司天津石油分公司河东真理道加油站\",\n" +
                "\t\"yizhenggai\": \"0\",\n" +
                "\t\"id\": \"339\"\n" +
                "}, {\n" +
                "\t\"suozaiquxian\": \"河东区\",\n" +
                "\t\"suoshuxingye\": \"危险化学品\",\n" +
                "\t\"qiyemingcheng\": \"中国石油化工股份有限公司天津石油分公司河东中北加油站\",\n" +
                "\t\"yizhenggai\": \"0\",\n" +
                "\t\"id\": \"327\"\n" +
                "}, {\n" +
                "\t\"suozaiquxian\": \"河东区\",\n" +
                "\t\"suoshuxingye\": \"危险化学品\",\n" +
                "\t\"qiyemingcheng\": \"中国石油化工股份有限公司天津石油分公司河东迎宾加油站\",\n" +
                "\t\"yizhenggai\": \"0\",\n" +
                "\t\"id\": \"282\"\n" +
                "}, {\n" +
                "\t\"suozaiquxian\": \"河东区\",\n" +
                "\t\"suoshuxingye\": \"危险化学品\",\n" +
                "\t\"qiyemingcheng\": \"中国石油化工股份有限公司天津石油分公司河东金三角加油站\",\n" +
                "\t\"yizhenggai\": \"0\",\n" +
                "\t\"id\": \"336\"\n" +
                "}, {\n" +
                "\t\"suozaiquxian\": \"河东区\",\n" +
                "\t\"suoshuxingye\": \"危险化学品\",\n" +
                "\t\"qiyemingcheng\": \"中国石油化工股份有限公司天津石油分公司钢板网厂加油站\",\n" +
                "\t\"yizhenggai\": \"0\",\n" +
                "\t\"id\": \"374\"\n" +
                "}, {\n" +
                "\t\"suozaiquxian\": \"河东区\",\n" +
                "\t\"suoshuxingye\": \"危险化学品\",\n" +
                "\t\"qiyemingcheng\": \"中国石油天然气股份有限公司天津销售分公司富民路加油站\",\n" +
                "\t\"yizhenggai\": \"0\",\n" +
                "\t\"id\": \"399\"\n" +
                "}, {\n" +
                "\t\"suozaiquxian\": \"河东区\",\n" +
                "\t\"suoshuxingye\": \"危险化学品\",\n" +
                "\t\"qiyemingcheng\": \"中海油销售天津有限公司耐火路加油站\",\n" +
                "\t\"yizhenggai\": \"0\",\n" +
                "\t\"id\": \"41\"\n" +
                "}]";


        //最好json格式是  List<Map<String,Object>> ，我们先将其解码转格式为 List<Map<String,Object>>
        JSONArray jsonArray = JSON.parseArray(str);
        for (int i = jsonArray.size() - 1; i >= 0; i--) {
            stratList.add(((JSONObject) jsonArray.get(i)).getInnerMap());
        }
        //如果是从数据库拿的数据，也就是接口拿的数据，本来就是这个格式的话，不需要做上面的转换，可以直接使用


        //该集合里面放我们需要去除的字段的key
        List<String> mapKey = new ArrayList<>();
        mapKey.add("id");
//        mapKey.add("qiyedaima");
        mapKey.add("yizhenggai");
        stratList  = exclUtils.deleteMapKey(stratList,mapKey);//调用工具类去除不需要导出的字段

        //该集合里面放我们是否需要导出的字段，该字段是判断选中状态用的，必传项，不可为空，要么为0，要么为1
        List<String> ifMapKey = new ArrayList<>();
        ifMapKey.add("yhsl");//隐患数量
        ifMapKey.add("zgl");//整改率
        ifMapKey.add("ljzf");//累计执法次数
        stratList = exclUtils.JudgeSelected(paramsMap,stratList,ifMapKey);


        //重新定义一个list，排序用，因为表头需要顺序
        List<TreeMap<String,Object>> reList = new ArrayList<>();
        //将map排序，导出时需要对应起来
        for (int i = 0; i < stratList.size(); i++) {
            Map<String,Object> map = new HashMap();
            if(stratList.get(i).containsKey("id")){
                map.put("1id",stratList.get(i).get("id").toString());
            }
            if(stratList.get(i).containsKey("qiyemingcheng")){
                map.put("2qiyemingcheng",stratList.get(i).get("qiyemingcheng").toString());
            }
            if(stratList.get(i).containsKey("suozaiquxian")){
                map.put("3suozaiquxian",stratList.get(i).get("suozaiquxian").toString());
            }
            if(stratList.get(i).containsKey("suoshuxingye")){
                map.put("4suoshuxingye",stratList.get(i).get("suoshuxingye").toString());
            }
            if(stratList.get(i).containsKey("yinhuanTotal")){
                map.put("5yinhuanTotal",stratList.get(i).get("yinhuanTotal").toString());
            }
            if(stratList.get(i).containsKey("baifenbi")){
                map.put("6baifenbi",stratList.get(i).get("baifenbi").toString());
            }
            if(stratList.get(i).containsKey("zhifaNum")){
                map.put("7zhifaNum",stratList.get(i).get("zhifaNum").toString());
            }

            TreeMap treeMap = new TreeMap(map);
            reList.add(treeMap);
        }

        Map<String,Object> headerMap =  new HashMap<>();//控制表头的map
        //判断返回数据是否为空，如果空，直接返回null，不为空才能执行下一步
        if(CollectionUtils.isNotEmpty(reList)){
            //接收到的第一个map，以此来确定表头。因为每个里面都是一样，我们只需要根据其中一个就可以确定该表格导出的表头
            headerMap = reList.get(0);
        }
        //将表头map中，根据key来确定导出所需要的表头，存到list中
        List<String> list = new ArrayList<>();
        for (Object key : headerMap.keySet()) {
            if(key.equals("1id")){
                list.add("id");
            }
            if(key.equals("2qiyemingcheng")){
                list.add("企业名称");
            }
            if(key.equals("3suozaiquxian")){
                list.add("所在区域");
            }
            if(key.equals("4suoshuxingye")){
                list.add("监管分类");
            }
            if(key.equals("5fadingdaibiaoren")){
                list.add("法定代表人");
            }
            if(key.equals("6yinhuanTotal")) {
                list.add("隐患数");
            }
            if(key.equals("7baifenbi")){
                list.add("整改率");
            }
            if(key.equals("8zhifaNum")){
                list.add("累计执法次数");
            }
        }

        //声明一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        //生成一个表格，设置表格名称为"对比分析表"
        HSSFSheet sheet = workbook.createSheet("对比分析表");

        //设置表格列宽度为10个字节
        sheet.setDefaultColumnWidth(10);

        //创建第一行表头
        HSSFRow headrow = sheet.createRow(0);

        //遍历添加表头(下面模拟遍历table，也是同样的操作过程)
        for (int i = 0; i < list.size(); i++) {
            //创建一个单元格
            HSSFCell cell = headrow.createCell(i);

            //创建一个内容对象
            HSSFRichTextString text = new HSSFRichTextString(list.get(i));

            //将内容对象的文字内容写入到单元格中
            cell.setCellValue(text);
        }

        for (int i = 0; i < reList.size(); i++) {
            //模拟遍历结果集，把内容加入表格
            //模拟遍历对比分析表
            int i1 = reList.get(i).size();
            HSSFRow row1 = sheet.createRow(i+1);
            Integer col =0;
            for (Object value : reList.get(i).values()) {
//                if(i<=reslutList.get(i).size()){
                    HSSFCell cell = row1.createCell(col++);
                    HSSFRichTextString text = new HSSFRichTextString(value.toString());
                    cell.setCellValue(text);
//                }
            }
        }

        //准备将Excel的输出流通过response输出到页面下载
        //八进制输出流
        response.setContentType("application/octet-stream");

        //这后面可以设置导出Excel的名称，此例中名为student.xls
        String fileName = "对比分析表";
        response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(fileName, "UTF-8")+".xlsx");
//        response.setHeader("Content-disposition", "attachment;filename=CAnalysis.xls");

        //刷新缓冲
        response.flushBuffer();

        //workbook将Excel写入到response的输出流中，供页面下载
        workbook.write(response.getOutputStream());
    }

}
