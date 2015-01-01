package com.et.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * 登录工具类
 * @author Administrator
 *
 */
public class LoginUtil {
	HttpClient httpclient = new DefaultHttpClient();
	/**
	 * 登录操作
	 * @param formparams --登录表单
	 * @param loginurl--登陆地址
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public HashMap<String,String> login(List<NameValuePair> formparams, String loginurl)
			throws ClientProtocolException, IOException {
		
		HashMap<String,String>  hashmap = new 	HashMap<String,String>();

		// 设置登陆时要求的信息，用户名和密码
		UrlEncodedFormEntity entity1 = new UrlEncodedFormEntity(formparams,	"UTF-8");
		// 新建Http post请求
		HttpPost httppost = new HttpPost(loginurl);
		httppost.setEntity(entity1);

		// 处理请求，得到响应
		HttpResponse response = httpclient.execute(httppost);
		String set_cookie = response.getFirstHeader("Set-Cookie").getValue();

		// 打印Cookie值
		String Cookie =set_cookie.substring(0, set_cookie.indexOf(";"));
	    System.out.println("Cookie值:"+Cookie);
		hashmap.put("Cookie", Cookie);

		// 打印返回的结果
		HttpEntity entity = response.getEntity();
		StringBuilder result = new StringBuilder();
		if (entity != null) {
			InputStream instream = entity.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					instream));
			String temp = "";
			while ((temp = br.readLine()) != null) {
				String str = new String(temp.getBytes(), "utf-8");
				result.append(str);
			}
		}
		System.out.println("html:" + result);
		hashmap.put("Html", result.toString());
		return hashmap;
	}

	/**
	 * 发布文章
	 * @param formparams --发布文章表单
	 * @param publishurl--发布地址
	 * @param Cookie--当前会话Cookie
	 * @throws UnsupportedEncodingException 
	 */
	public void publishArticle(List<NameValuePair> formparams, String publishurl,String Cookie) throws ClientProtocolException, IOException {
		// 根据获得的Cookie值，设置头信息，然后发送请求，获得内容
			UrlEncodedFormEntity entity1 = new UrlEncodedFormEntity(formparams,	"UTF-8");
			// 新建Http post请求
			HttpPost httppost = new HttpPost(publishurl);
			httppost.setEntity(entity1);
			httppost.setHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");  
			httppost.setHeader("Cookie",Cookie);
			//执行发布文章操作
			HttpResponse response = httpclient.execute(httppost);
			System.out.println("response结果:" + response);
			/*String set_cookie = response.getFirstHeader("Set-Cookie").getValue();

			// 打印Cookie值
			String Cookie_sss=set_cookie.substring(0, set_cookie.indexOf(";"));
		    System.out.println("Cookie值:"+Cookie_sss);*/
			// 打印返回的结果
			HttpEntity entity = response.getEntity();
			StringBuilder result = new StringBuilder();
			if (entity != null) {
				InputStream instream = entity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						instream));
				String temp = "";
				while ((temp = br.readLine()) != null) {
					String str = new String(temp.getBytes(), "utf-8");
					result.append(str);
				}
			}
			System.out.println("文章发布返回结果:" + result);
	}
}
