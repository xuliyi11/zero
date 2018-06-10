package com.interceptors;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by xly on 2018/5/25.
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    private static AtomicLong requestCount = new AtomicLong();

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUrl = request.getRequestURI();
        String actionName = requestUrl.substring(1);
        Long requestNumber = requestCount.incrementAndGet();

        Parameters parameters = new Parameters();
        parameters.setRequestNumber(requestNumber);
        parameters.setActionName(actionName);

        MDC.put("actionName",actionName);
        MDC.put("requestNumber",requestNumber);
        String requestParam = JSONObject.toJSONString(request.getParameterMap());
        MDC.put("requestParam",requestParam);

        BeanUtils.populate(parameters,request.getParameterMap());

        JSONObject bodyObject = JSONObject.parseObject(parameters.getBody());
        for (Map.Entry<String,Object> entry : bodyObject.entrySet()){
            request.setAttribute(entry.getKey(),entry.getValue());
        }
        request.setAttribute("bodyObject",bodyObject);


        Parameters.set(parameters);
        logger.info(JSONObject.toJSONString(actionName));
        return true;
    }

}
