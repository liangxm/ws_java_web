package com.lxm.lottery.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;

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
    
    public static String getHostRate(JSONArray jsonArr,int category,int type) throws JSONException{
    	return jsonArr.getJSONArray(category).getString(type);
    }
    
    public static void main(String[] args) throws JSONException{
    	String s = "[[\"95%\",\"5%\",\"0%\"],[\"97%\",\"3%\",\"0%\"],[\"17%\",\"83%\",\"0%\"]]";
    	String result = getHostRate(new JSONArray(s),0,0);
    	System.out.println(result);
    }
}