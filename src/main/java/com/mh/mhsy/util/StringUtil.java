package com.mh.mhsy.util;

import java.util.Random;

public class StringUtil {
    /**随机字符串生成载体*/
    public static final String A_Z_0 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";


    /**
     *  生成随机字符
     * @param num   字符数量  默认6个
     * @return
     */
    public static String createStr(int num){
        if (num <= 0 ){
            num = 6;
        }
        Random random = new Random();
        String str = "";
        for (int i=0;i<num;i++){
            str += A_Z_0.charAt(random.nextInt(A_Z_0.length()));

        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(createStr(7));
    }
}
