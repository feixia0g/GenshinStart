package com.example.genshinstart_backend.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @version 1.0.0
 * @description: The type Html util.
 * @author feixia0g
 * @date 2024/7/11 9:30
 */
public class HtmlUtil {
    /**
     * Clear string.
     *
     * @param htmlStr the html str
     * @return the string
     */
    public static String clear(String htmlStr) {
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>";
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>";
        String regEx_html = "<[^>]+>";
        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll("");
        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll("");
        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll("");
        return htmlStr.trim();
    }
}
