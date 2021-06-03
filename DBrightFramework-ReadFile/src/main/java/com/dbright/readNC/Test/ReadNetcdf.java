package com.dbright.readNC.Test;

import ucar.nc2.Dimension;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadNetcdf {
        public static void main(String[] args) {
            String filename = "/root/testNC/PRE_cn_sichuan.nc";
            NetcdfFile ncfile = null;
            try {
                ncfile = NetcdfFile.open(filename);

                //read dimensions
                List<Dimension> list =  ncfile.getDimensions();
                for(Dimension d : list){
                    System.out.println("name="+d.getName()+" length="+d.getLength());
                }
                //read variables
                List<Variable> variables = ncfile.getVariables();
                System.out.println();
                List<String> listJson = new ArrayList<>();
                for(Variable v : variables){
                    System.out.println("name="+v.getName()+" NameAndDimension="+v.getNameAndDimensions()+" ElementSize="+v.getElementSize());
                    float[] dataLAT = (float[]) v.read().copyTo1DJavaArray();
                    for(int i=0;i<dataLAT.length;i++){
                        System.out.print(v.getName()+":"+dataLAT[i]+"          ");
                    }
                    System.out.println();
                }

            } catch (IOException ioe) {
            } finally {
                if (null != ncfile)
                    try {
                        ncfile.close();
                    } catch (IOException ioe) {
                    }
            }
        }
    }