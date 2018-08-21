package com.filter;

import javax.servlet.*;
import java.io.IOException;

public class RequestFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getInitParameter("filterParam"));
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request,response);
    }

    public void destroy() {

    }
}
