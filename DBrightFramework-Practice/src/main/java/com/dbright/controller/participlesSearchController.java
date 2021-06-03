package com.dbright.controller;

import com.dbright.Test.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/anYuanLOL")
public class participlesSearchController extends BaseController {

    @RequestMapping(value = "/groupTeam", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> search(@RequestParam Map<String,Object> paramsMap){
            Map<String,Object> resultMap = new HashMap<>();
            String[] str={"朱亚东", "陶都", "王总", "大奔哥", "锁子哥", "夏维明", "逼哥", "凯哥", "项海峰", "徐国群"};
            List<String> list = new ArrayList<String>();
            for(int i = 0;i < str.length;i++){
                list.add(str[i]);
            }
            Random ran = new Random();
            String b;
            for(int j = 1;j <= 2;j++){
                System.out.println(j+"组");
                List<String> nameList = new ArrayList<>();
                for (int k = 0;k < 5;k++){
                    b = list.get(ran.nextInt(list.size()));
                    nameList.add(b);
                    System.out.print("   "+b);
                    list.remove(b);
                }
                resultMap.put(j+"组",nameList);
                System.out.println("\n");
            }
            System.out.println();
            return resultMap;
    }

}
