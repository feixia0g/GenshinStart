package com.example.genshinstart_backend.configuration.property;

/**
 * @version 3.5.0
 * @description: The type Cookie config.
 * @author feixia0g
 * @date 2024/7/10 9:10
 */
public class CookieConfig {

    /**
     * Gets name.
     *
     * @return the name
     */
    public static String getName() {
        return "xzs";
    }

    /**
     * Gets interval.
     *
     * @return the interval
     */
    public static Integer getInterval() {
        return 30 * 24 * 60 * 60;
    }
}
