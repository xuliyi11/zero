package com.filter;

import javax.servlet.*;
import java.io.IOException;

public class TestFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("执行 TestFilter  init 方法");

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("执行 TestFilter  doFilter 方法");

    }

    public void destroy() {

        System.out.println("执行 TestFilter  destroy 方法");

    }
}
