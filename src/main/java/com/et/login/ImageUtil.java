package com.et.login;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 图片处理
 * @author Administrator
 *
 */
public class ImageUtil {
	/**
	 * src处理
	 * @param content
	 * @param url
	 */
	public  String  replaceSRC(String  html,String url){
		Document doc = Jsoup.parse(html);
		 Elements links = doc.getElementsByTag("img"); 
		 for (Element link : links) { 
			  String linkHref = link.attr("src"); 
			  link.attr("src", url+"/"+linkHref);
		 }
		System.out.println(doc.toString());
		return doc.toString();
	}
	/**
	 * 移除标题中来源
	 */
	public  String  removeTitle(String title){
		String[] titlearray = title.split("_");
		if (titlearray.length<1){
			return title;
		}else{
			int maxlenght =0;
			String maxtitle="";
			for(int i=0;i<titlearray.length;i++){
				if(titlearray[i].length()>maxlenght){
					maxlenght =titlearray[i].length();
					maxtitle =titlearray[i];
				}
			}
			return maxtitle;
		}
	}
}
