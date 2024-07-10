package com.example.genshinstart_backend.configuration.spring.security;

import com.example.genshinstart_backend.base.RestResponse;
import com.example.genshinstart_backend.base.SystemCode;
import com.example.genshinstart_backend.utility.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0.0
 * @description: The type Rest util.
 * @author feixia0g
 * @date 2024/7/10 9:45
 */
public class RestUtil {
    private static final Logger logger = LoggerFactory.getLogger(RestUtil.class);


    /**
     * Response.
     *
     * @param response   the response
     * @param systemCode the system code
     */
    public static void response(HttpServletResponse response, SystemCode systemCode) {
        response(response, systemCode.getCode(), systemCode.getMessage());
    }

    /**
     * Response.
     *
     * @param response   the response
     * @param systemCode the system code
     * @param msg        the msg
     */
    public static void response(HttpServletResponse response, int systemCode, String msg) {
        response(response, systemCode, msg, null);
    }


    /**
     * Response.
     *
     * @param response   the response
     * @param systemCode the system code
     * @param msg        the msg
     * @param content    the content
     */
    public static void response(HttpServletResponse response, int systemCode, String msg, Object content) {
        try {
            RestResponse res = new RestResponse<>(systemCode, msg, content);
            String resStr = JsonUtil.toJsonStr(res);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(resStr);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}

