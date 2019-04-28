package com.rollingstone.util;

import org.owasp.encoder.Encode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XSSUtil {

	static Logger log = LoggerFactory.getLogger("XSSUtil");

	public static boolean detectXSS(String input) {
		
		boolean isXss = false;
		if (isHTML(input)) {
			return true;
		}else if (isHTMLContent(input)) {
			return true;
		}
		else if (isHTMLContent(input)) {
			return true;
		}
		else if (isHTMLAttribute(input)) {
			return true;
		}
		else if (isCssString(input)) {
			return true;
		}
		else if (isCssUrl(input)) {
			return true;
		}
		else if (isJavaScript(input)) {
			return true;
		}
		else if (isJavaScriptAttribute(input)) {
			return true;
		}
		else if (isURI(input)) {
			return true;
		}
		
		return isXss;
	}
	
	public static boolean isHTML(String input) {
		log.info("Encode.forHtml(input)) :"+Encode.forHtml(input));

		log.info("input.equalsIgnoreCase(Encode.forHtml(input)) :"+input.equalsIgnoreCase(Encode.forHtml(input)));
		return !input.equalsIgnoreCase(Encode.forHtml(input));
	}
	
	public static boolean isHTMLContent(String input) {
		log.info("Encode.forHtmlContent(input)) :"+Encode.forHtmlContent(input));

		log.info("input.equalsIgnoreCase(Encode.forHtmlContent(input)) :"+input.equalsIgnoreCase(Encode.forHtmlContent(input)));
		return !input.equalsIgnoreCase(Encode.forHtmlContent(input));
	}
	
	public static boolean isHTMLAttribute(String input) {
		log.info("Encode.forHtmlAttribute(input)) :"+Encode.forHtmlAttribute(input));

		log.info("input.equalsIgnoreCase(Encode.forHtmlAttribute(input)) :"+input.equalsIgnoreCase(Encode.forHtmlAttribute(input)));
		return !input.equalsIgnoreCase(Encode.forHtmlAttribute(input));
	}
	
	public static boolean isCssString(String input) {
		log.info("Encode.forCssString(input)) :"+Encode.forCssString(input));

		log.info("input.equalsIgnoreCase(Encode.forCssString(input)) :"+input.equalsIgnoreCase(Encode.forCssString(input)));
		return !input.equalsIgnoreCase(Encode.forCssString(input));
	}
	
	public static boolean isCssUrl(String input) {
		log.info("Encode.forCssUrl(input)) :"+Encode.forCssUrl(input));

		log.info("input.equalsIgnoreCase(Encode.forCssUrl(input)) :"+input.equalsIgnoreCase(Encode.forCssUrl(input)));
		return !input.equalsIgnoreCase(Encode.forCssUrl(input));
	}
	
	public static boolean isJavaScript(String input) {
		log.info("Encode.forJavaScriptBlock(input)) :"+Encode.forJavaScriptBlock(input));

		log.info("input.equalsIgnoreCase(Encode.forJavaScriptBlock(input)) :"+input.equalsIgnoreCase(Encode.forJavaScriptBlock(input)));
		return !input.equalsIgnoreCase(Encode.forJavaScriptBlock(input));
	}
	
	public static boolean isJavaScriptAttribute(String input) {
		log.info("Encode.forJavaScriptAttribute(input)) :"+Encode.forJavaScriptAttribute(input));

		log.info("input.equalsIgnoreCase(Encode.forJavaScriptAttribute(input)) :"+input.equalsIgnoreCase(Encode.forJavaScriptAttribute(input)));
		return !input.equalsIgnoreCase(Encode.forJavaScriptAttribute(input));
	}
	
	public static boolean isURI(String input) {
		log.info("Encode.forUriComponent(input)) :"+Encode.forUriComponent(input));

		log.info("input.equalsIgnoreCase(Encode.forUriComponent(input)) :"+input.equalsIgnoreCase(Encode.forUriComponent(input)));
		return !input.equalsIgnoreCase(Encode.forUriComponent(input));
	}
}
