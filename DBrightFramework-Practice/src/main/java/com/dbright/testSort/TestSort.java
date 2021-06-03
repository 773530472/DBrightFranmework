package com.dbright.testSort;

public class TestSort {
    public static void main(String[] args) {
        int[] sortArr1 = new int[]{1, 2, 3, 4};
        int[] sortArr2 = new int[]{3, 4, 5, 8};

        int[] endArr = mergeSortedArray(sortArr1,sortArr2);

        for (int i : endArr){
            System.out.println(i+",");
        }

    }


    public static int[] mergeSortedArray(int[] A, int[] B) {
        int i = 0;
        int j = 0;
        int res[] = new int[A.length + B.length];
        int k = 0;
        while (i < A.length && j < B.length) {
            if (A[i] <= B[j]) {
                res[k++] = A[i++];
            } else {
                res[k++] = B[j++];
            }
        }

        if (i != A.length) {
            for (int a = i; a < A.length; a++) {
                res[k++] = A[a];
            }
        } else {
            for (int b = j; b < B.length; b++) {
                res[k++] = B[b];
            }

        }
        return res;
    }

}
