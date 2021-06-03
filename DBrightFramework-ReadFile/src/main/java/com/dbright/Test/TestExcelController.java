package com.dbright.Test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ucar.nc2.Dimension;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Test")
public class TestExcelController {

    @ResponseBody
    @RequestMapping("/listJson")
    public List<Map<String,Object>> excelDownload(@RequestParam Map<String, Object> paramsMap) throws IOException {
        List<Dimension> listJson = new ArrayList<>();
        List<Map<String, Object>> reslutList = new ArrayList<>();//最终结果集
        String filename = "/root/testNC/PRE_cn_sichuan.nc";
        NetcdfFile ncfile = null;
        try {
            ncfile = NetcdfFile.open(filename);

            //read dimensions
            List<Dimension> list = ncfile.getDimensions();
            for (Dimension d : list) {
                System.out.println("name=" + d.getName() + " length=" + d.getLength());
                listJson.add(d);
            }
            //read variables
            List<Variable> variablesList = ncfile.getVariables();

            float[] dataLAT = (float[]) variablesList.get(1).read().copyTo1DJavaArray();
            float[] dataLON = (float[]) variablesList.get(0).read().copyTo1DJavaArray();
            float[] dataPRE = (float[]) variablesList.get(2).read().copyTo1DJavaArray();

            int LATlength = list.get(0).getLength();//LAT长度，也就是重复出现的次数
            int LONlength = list.get(1).getLength();//LON长度，也就是重复出现的次数

                for (int j=0;j<LONlength;j++){//190
                    for (int k=0;k<LATlength;k++){//240
                        Map<String, Object> relustMap = new HashMap<>();//每次存储的map
                        relustMap.put(variablesList.get(1).getName(),dataLAT[j]);
                        relustMap.put(variablesList.get(0).getName(),dataLON[k]);
                        relustMap.put(variablesList.get(2).getName(),dataPRE[k]);
                        reslutList.add(relustMap);
                    }
            }
        } catch (IOException ioe) {
        } finally {
            if (null != ncfile)
                try {
                    ncfile.close();
                } catch (IOException ioe) {
                }
        }
        return reslutList;
    }

}
