package com.et.login;

import junit.framework.TestCase;

public class ImageTest extends TestCase {
	/**
	 * 测试添加相对路劲
	 */
	public  void testImage(){
		ImageUtil   imageUtil =  new  ImageUtil();
		String html = "<html><head><title>First parse</title></head><body> <img src=\"http://www.baidu.comss/project.png\"> 开源软件 </img><p>Parsed HTML into a doc.</p><img src=\"../image/sss.jpg\"></body></html>";
		String url="http://www.baidu.com/1.html";
		String html_content =imageUtil.replaceSRC(html, url);
		ImageUtil testconten= new ImageUtil();
		testconten.replaceSRC("<img src='/test.jpg'>", "http://www.baidu.com/sdfsdf/a.html");
		testconten.replaceSRC("<img src='/test.jpg'>", "http://www.baidu.com/sdfsdf/");
		testconten.replaceSRC("<img src='/test.jpg'>", "http://www.baidu.com/sdfsdf");
		testconten.replaceSRC("<img src='/test.jpg'>", "http://www.baidu.com/sdfsdf.asp?aaa=3");
		
		testconten.replaceSRC("<img src='../test.jpg'>", "http://www.baidu.com/sdfsdf/a.html");
		testconten.replaceSRC("<img src='../test.jpg'>", "http://www.baidu.com/sdfsdf/");
		testconten.replaceSRC("<img src='../test.jpg'>", "http://www.baidu.com/sdfsdf");
		testconten.replaceSRC("<img src='../test.jpg'>", "http://www.baidu.com/sdfsdf.asp?aaa=3");	
		
		testconten.replaceSRC("<img src='./test.jpg'>", "http://www.baidu.com/sdfsdf/a.html");
		testconten.replaceSRC("<img src='./test.jpg'>", "http://www.baidu.com/sdfsdf/");
		testconten.replaceSRC("<img src='./test.jpg'>", "http://www.baidu.com/sdfsdf");
		testconten.replaceSRC("<img src='./test.jpg'>", "http://www.baidu.com/sdfsdf.asp?aaa=3");	
		
		testconten.replaceSRC("<img src='http://ww.baidu.com/sss/test.jpg'>", "http://www.baidu.com/sdfsdf/a.html");
		testconten.replaceSRC("<img src='http://ww.baidu.com/sss/test.jpg'>", "http://www.baidu.com/sdfsdf/");
		testconten.replaceSRC("<img src='http://ww.baidu.com/sss/test.jpg'>", "http://www.baidu.com/sdfsdf");
		testconten.replaceSRC("<img src='http://ww.baidu.com/sss/test.jpg'>", "http://www.baidu.com/sdfsdf.asp?aaa=3");		
		
		testconten.replaceSRC("<img src='data-img:sdkfjsduf'>", "http://www.baidu.com/sdfsdf/a.html");
		testconten.replaceSRC("<img src='data-img:sdkfjsduf'>", "http://www.baidu.com/sdfsdf/");
		testconten.replaceSRC("<img src='data-img:sdkfjsduf'>", "http://www.baidu.com/sdfsdf");
		testconten.replaceSRC("<img src='data-img:sdkfjsduf'>", "http://www.baidu.com/sdfsdf.asp?aaa=3");	
	}
	/**
	 * 去除标题中的来源
	 */
	public  void testremoveTitle(){
		ImageUtil   imageUtil =  new  ImageUtil();
		String title="休息嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻_广州在线";
		String maxtitle =imageUtil.removeTitle(title);
		System.out.println("处理后的标题："+maxtitle);
		System.out.println("================================");
		System.out.println("处理后的标题："+imageUtil.removeTitle("广州在线_休息嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻"));
		System.out.println("---------------------------------------------");
		System.out.println("sssssssss:"+imageUtil.removeChar("休息嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻_广州在线"));
	}
}
