package com.dbright.readNC.Test;

import ucar.ma2.ArrayDouble;
import ucar.ma2.Index;
import ucar.nc2.Dimension;
import ucar.nc2.NetcdfFileWriteable;

import java.io.IOException;

public class Write3DNetCDF {
    public static void main(String[] args) throws IOException {
        NetcdfFileWriteable ncfile = NetcdfFileWriteable.openExisting("/root/testNC/PRE_cn_sichuan.nc", true);
        Dimension timeDim = ncfile.getDimensions().get(0);
        Dimension latDim = ncfile.getDimensions().get(1);
//        Dimension lonDim = ncfile.getDimensions().get(2);
//        ArrayDouble A = new ArrayDouble.D3(timeDim.getLength(), latDim.getLength(), lonDim.getLength());
        ArrayDouble A = new ArrayDouble.D2(timeDim.getLength(), latDim.getLength());
        int k, i;
        Index ima = A.getIndex();
        for (k = 0; k < timeDim.getLength(); k++) {
            for (i = 0; i < latDim.getLength(); i++) {
                    A.setDouble(ima.set(k, i), (double) (k + i));
            }
        }
        int[] origin = new int[2];
        System.out.println(origin[0]);
        System.out.println(origin[1]);
        try {
//            ncfile.write("temperature", origin, A);
            ncfile.close();
        } catch (IOException e) {
            System.err.println("ERROR writing file");
        }
    }
}