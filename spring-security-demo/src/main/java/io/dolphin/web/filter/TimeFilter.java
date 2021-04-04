package io.dolphin.web.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

import static java.lang.System.currentTimeMillis;

/**
 * @author Eric
 * @create 2019 07 20 9:12
 */
//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("time filter start");
        long start = currentTimeMillis();
        chain.doFilter(request, response);
        System.out.println("time filter 耗时:" + (currentTimeMillis() - start));
        System.out.println("time filter finish");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }
}
