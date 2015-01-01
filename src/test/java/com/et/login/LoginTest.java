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
			
			
			String publishurl ="http://twcms.meiyear.com/admin/index.php?u=article-add-ajax-1";
			String Cookie=map.get("Cookie");
			
			//发布文章操作
			List<NameValuePair> publishparam = new ArrayList<NameValuePair>();
			publishparam.add(new BasicNameValuePair("id", ""));
			publishparam.add(new BasicNameValuePair("color", ""));
			publishparam.add(new BasicNameValuePair("seo_title", ""));
			publishparam.add(new BasicNameValuePair("cid", "1"));
			publishparam.add(new BasicNameValuePair("title", "111111111111"));
			publishparam.add(new BasicNameValuePair("content", "2222222222"));
			publishparam.add(new BasicNameValuePair("alias", ""));
			publishparam.add(new BasicNameValuePair("tags", ""));
			publishparam.add(new BasicNameValuePair("intro", ""));
			publishparam.add(new BasicNameValuePair("pic", ""));
			publishparam.add(new BasicNameValuePair("source", ""));
			publishparam.add(new BasicNameValuePair("views", "0"));
			publishparam.add(new BasicNameValuePair("seo_keywords", ""));
			publishparam.add(new BasicNameValuePair("seo_description", ""));
			publishparam.add(new BasicNameValuePair("author", "dingyangfan"));
			
		
			for(int i=0;i<10000;i++){
				  Thread.sleep(5000);
				loginUtil.publishArticle(publishparam, publishurl, Cookie);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
