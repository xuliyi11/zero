package com.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class HttpEndingInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(HttpEndingInterceptor.class);

    private static final String DEFAULT_CHARSET_VALUE = "utf-8";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if ("/favicon.ico".equalsIgnoreCase(request.getRequestURI())) {
            return false;
        }
        setResponseCharset(request, response);
        return true;
    }

    private void setResponseCharset(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            String charset = httpServletRequest.getHeader("accept-charset");
            if (charset != null && charset.length() > 0) {


                String[] charsets = charset.split(",");
                if (charsets.length > 0) {
                    httpServletResponse.setCharacterEncoding(charsets[0]);
                    httpServletRequest.setCharacterEncoding(charsets[0]);
                    httpServletResponse.addHeader("Content-Type", "text/plain;charset=utf-8");
                } else {
                    httpServletRequest.setCharacterEncoding(DEFAULT_CHARSET_VALUE);
                    httpServletResponse.setCharacterEncoding(DEFAULT_CHARSET_VALUE);
                    httpServletResponse.addHeader("Content-Type", "text/plain;charset=utf-8");
                }
            } else {
                httpServletRequest.setCharacterEncoding(DEFAULT_CHARSET_VALUE);
                httpServletResponse.setCharacterEncoding(DEFAULT_CHARSET_VALUE);
                httpServletResponse.addHeader("Content-Type", "text/plain;charset=utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            logger.error("不支持的字符集", e);
        }
    }

}
