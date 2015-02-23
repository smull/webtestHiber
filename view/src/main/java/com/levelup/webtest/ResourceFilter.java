package com.levelup.webtest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by denis_zavadsky on 2/7/15.
 */
public class ResourceFilter implements Filter {

    private String CSS_URL_PART = "";
    private String JS_URL_PART = "";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        CSS_URL_PART = filterConfig.getInitParameter(Constants.CSS_PART_PARAMETER);
        JS_URL_PART = filterConfig.getInitParameter(Constants.JS_PART_PARAMETER);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String url = ((HttpServletRequest)request).getRequestURI();

        if (url.startsWith(CSS_URL_PART) || url.startsWith(JS_URL_PART)){
            chain.doFilter(request,response);
        } else {
            request.getRequestDispatcher("/main"+url).forward(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
