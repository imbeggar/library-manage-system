package com.tlshzp.fliter;

import com.tlshzp.utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/common/*")
public class CommonFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        int identify = CookieUtils.checkIdentify(req.getCookies(), req.getSession(), resp);
        if (identify == 0) {
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<script>");
            out.println("window.open ('"+req.getContextPath()+"/index.jsp','_top')");
            out.println("</script>");
            out.println("</html>");
        }
        else filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
