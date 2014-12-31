package com.et.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple Login.
 */
public class LoginTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LoginTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LoginTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testLogin()
    {
    	try {
	    	LoginUtil  loginUtil = new LoginUtil();
	    	//登录操作
	    	List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			formparams.add(new BasicNameValuePair("username", "dingyangfan"));
			formparams.add(new BasicNameValuePair("password", "admin888"));
			formparams.add(new BasicNameValuePair("FORM_HASH", "e29607b23783b676"));
			String loginurl ="http://twcms.meiyear.com/admin/index.php?u=index-login";
			HashMap<String,String>  map =loginUtil.login(formparams,loginurl);
			//发布文章操作
			String publishurl ="发布文章地址";
			List<NameValuePair> formparams2 = new ArrayList<NameValuePair>();
			formparams.add(new BasicNameValuePair("title", "标题"));
			formparams.add(new BasicNameValuePair("content", "内容"));
			formparams.add(new BasicNameValuePair("author", "作者"));
			String Cookie=map.get("Cookie");
			loginUtil.publishArticle(formparams2, publishurl, Cookie);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
