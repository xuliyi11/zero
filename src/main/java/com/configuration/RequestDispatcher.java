package com.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xly on 2018/4/16.
 */
public class RequestDispatcher extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestDispatcher.class);

    @Override
    public void init() throws ServletException{
        ServletConfig config = getServletConfig();
        LOGGER.info(config.getServletName());
    }

    /*@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException{
        LOGGER.info(req.getMethod());

    }*/
}
