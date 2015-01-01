package com.et.login;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 图片处理
 * 
 * @author Administrator
 * 
 */
public class ImageUtil {
	/**
	 * src处理
	 * 
	 * @param content
	 * @param url
	 */
	public String replaceSRC(String html, String url) {
		String url_new =url;
		if(url.contains("/")){
			url_new =url.substring(0,url.lastIndexOf("/"));
		}
		Document doc = Jsoup.parse(html);
		Elements links = doc.getElementsByTag("img");
		for (Element link : links) {
			String linkHref = link.attr("src");
			if(linkHref.contains("http")||linkHref.contains("https")){
				System.out.println("不替换地址");
			}else{
				if(linkHref.contains("/")){
					link.attr("src", url_new + "/" + linkHref.substring(linkHref.indexOf("/"),linkHref.length()));
				}else{
					link.attr("src", url_new + "/" + linkHref);
				}
			}
		}
		System.out.println(doc.toString());
		return doc.toString();
	}

	/**
	 * 移除标题中来源
	 */
	public String removeTitle(String title) {
		String[] titlearray = title.split("_");
		if (titlearray.length < 1) {
			return title;
		} else {
			int maxlenght = 0;
			String maxtitle = "";
			for (int i = 0; i < titlearray.length; i++) {
				if (titlearray[i].length() > maxlenght) {
					maxlenght = titlearray[i].length();
					maxtitle = titlearray[i];
				}
			}
			return maxtitle;
		}
	}

	/**
	 * 测试去除特殊字符
	 * 适合在后面的标题
	 * @return
	 */
	public String removeChar(String title) {
		if (title.contains("_")) {
			title = title.substring(0, title.indexOf("_"));
			System.out.println(title);
		} else if (title.contains("-")) {
			title = title.substring(0, title.indexOf("-"));
			System.out.println(title);
		} else if (title.contains("--")) {
			title = title.substring(0, title.indexOf("--"));
			System.out.println(title);
		}
		return title;
	}
}
