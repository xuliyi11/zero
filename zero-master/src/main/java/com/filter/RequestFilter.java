package com.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("执行 RequestFilter init 方法");
        System.out.println(filterConfig.getInitParameter("filterParam"));

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //System.out.println(httpServletRequest.getRequestURI());
        //System.out.println("执行 RequestFilter doFilter 方法 ---- start");

        //chain.doFilter(request, response);

        //System.out.println("执行 RequestFilter doFilter 方法 ---- end");
    }

    public void destroy() {

        System.out.println("RequestFilter 容器销毁");

    }
}
