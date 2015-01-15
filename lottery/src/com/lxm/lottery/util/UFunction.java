package com.lxm.lottery.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
* 定义EL自定义函数
*
*/  
public class UFunction {   
  
    /**
      * 获取一个字符串的长度
      *
      * @param str
      * @return int
      */  
    public static int getLen(String str) {   
        return str.length();   
     }   
  
    /**
      * 截取字符串
      *
      * @param str
      * @param start
      * @param end
      * @return String
      */  
    public static String substr(String str, int start, int end) {   
        return str.substring(start, end);   
     }   
  
    /**
      * 两数相除获取整数结果
      *  
      * @param first
      * @param second
      * @return int
      */  
    public static int chufa(int first, int second) {   
        return first / second;   
    }
    
    /**
     * Long转换成date
     * @param dateFormat
     * @param millSec
     * @return
     */
    public static String formatDate(String dateFormat,Long millSec){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date= new Date(millSec);
        return sdf.format(date);
    }
}