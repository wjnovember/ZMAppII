package com.eric.zmappii.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by eric on 15/8/23.
 */
public class MatchUtils {
    /**
     * 判断是否为合法IP
     * @return the ip
     */
    public boolean isboolIp(String ipAddress)
    {
        String ip = "([1-9]|[1-9]//d|1//d{2}|2[0-4]//d|25[0-5])(//.(//d|[1-9]//d|1//d{2}|2[0-4]//d|25[0-5])){3}";
        Pattern pattern = Pattern.compile(ip);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }
}
