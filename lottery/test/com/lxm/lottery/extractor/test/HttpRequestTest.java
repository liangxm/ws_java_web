package com.lxm.lottery.extractor.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpRequestTest {

	@Test
	public void testPost() throws ClientProtocolException, IOException {
		 // TODO Auto-generated method stub  
        String url="http://blog.csdn.net/witsmakemen/article/details/12002961";  
        //POST的URL  
        HttpPost httppost=new HttpPost(url);  
        //建立HttpPost对象  
        List<NameValuePair> params=new ArrayList<NameValuePair>();  
        //建立一个NameValuePair数组，用于存储欲传送的参数  
        //params.add(new BasicNameValuePair("pwd","2544"));  
        //添加参数  
        httppost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));  
        //设置编码  
        HttpResponse response=new DefaultHttpClient().execute(httppost);  
        //发送Post,并返回一个HttpResponse对象  
                //Header header = response.getFirstHeader("Content-Length");  
        //String Length=header.getValue();  
                // 上面两行可以得到指定的Header  
        if(response.getStatusLine().getStatusCode()==200){//如果状态码为200,就是正常返回  
            String result=EntityUtils.toString(response.getEntity());  
            //得到返回的字符串  
            System.out.println(result);  
            //打印输出  
            //如果是下载文件,可以用response.getEntity().getContent()返回InputStream  
        }
	}
	
	
	@Test
	public void testGet() throws ClientProtocolException, IOException {
		 // TODO Auto-generated method stub  
        String url="http://blog.csdn.net/witsmakemen/article/details/12002961";  
        //POST的URL  
        HttpGet httpget=new HttpGet(url);  
        //建立HttpPost对象  
        List<NameValuePair> params=new ArrayList<NameValuePair>();  
        //建立一个NameValuePair数组，用于存储欲传送的参数  
        //params.add(new BasicNameValuePair("pwd","2544"));  
        //添加参数  
        //httpget.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
        //设置编码  
        HttpResponse response=new DefaultHttpClient().execute(httpget);  
        //发送Post,并返回一个HttpResponse对象  
                //Header header = response.getFirstHeader("Content-Length");  
        //String Length=header.getValue();  
                // 上面两行可以得到指定的Header  
        if(response.getStatusLine().getStatusCode()==200){//如果状态码为200,就是正常返回  
            String result=EntityUtils.toString(response.getEntity());  
            //得到返回的字符串  
            System.out.println(result);  
            //打印输出  
            //如果是下载文件,可以用response.getEntity().getContent()返回InputStream  
        }
	}
}
