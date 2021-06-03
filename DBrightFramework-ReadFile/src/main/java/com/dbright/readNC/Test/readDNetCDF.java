package com.dbright.readNC.Test;

import ucar.ma2.InvalidRangeException;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

import java.io.IOException;

public class readDNetCDF {
    public static void main(String[] args) throws IOException, InvalidRangeException {
        NetcdfFile openNC = NetcdfFile.open("/root/testNC/PRE_cn_sichuan.nc");  //filePath:文件地址
        Variable LAT = openNC.findVariable("LAT");   //"n"这个方法是找到变量名称为n的变量
        Variable LON = openNC.findVariable("LON");   //"n"这个方法是找到变量名称为n的变量
        Variable PRE = openNC.findVariable("PRE");   //"n"这个方法是找到变量名称为n的变量
        float[] dataLAT = (float[]) LAT.read().copyTo1DJavaArray();
        float[] dataLON = (float[]) LON.read().copyTo1DJavaArray();
        float[] dataPRE = (float[]) PRE.read().copyTo1DJavaArray();
        for(int i=0;i<dataLON.length;i++){
            System.out.print("LAT:"+dataLAT[i]+"          ");
            System.out.print("LON:"+dataLON[i]+"            ");
            System.out.println("PRE:"+dataPRE[i]);
        }
        openNC.close();
    }
}