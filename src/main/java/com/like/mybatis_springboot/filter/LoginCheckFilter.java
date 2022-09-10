package com.like.mybatis_springboot.filter;


import com.alibaba.fastjson.JSON;
import com.like.mybatis_springboot.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//过滤器，防止未登录直接进入其他页面的手段，需要在启动类上加入相应的注解‘@ServletComponentScan’，’urlPatterns‘拦截路径
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    //路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER=new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        //1,获取本次拦截的url
        String requestURL=request.getRequestURI();
        //定义不需要处理的请求路径
        String [] urls=new String[]{
                "/user/login"
        };
        //2,判断本次是否需要处理
        boolean check =check(urls,requestURL);
        //3,如果不需要处理，直接放行
        if(check){
            //放行
            chain.doFilter(request,response);
            return;
        }
        //4,判断登录状态如果已登录，直接放行
        System.out.println("41"+request.getSession().getAttribute("User"));
       if (request.getSession().getAttribute("User")!=null){
           chain.doFilter(request,response);
           return;
       }
        //5,如果未登录返回未登录结果,通过输出流向客户端页面响应数据
        log.info("拦截请求： {}",request.getRequestURI());
//        chain.doFilter(request,response);
        //java response 解决请求跨域问题解决
        response.setHeader("Access-Control-Allow-Origin","*");
        response.getWriter().write(JSON.toJSONString(Result.error("NOTLOGIN")));
//        chain.doFilter(request,response);
    }

    /**
     * 路径请求，本次请求是否需要放行
     * @param requestURL
     * @param urls
     * @return
     */
    public boolean check(String[] urls,String requestURL){
        for(String url:urls){
            boolean match = PATH_MATCHER.match(url,requestURL);
            if(match){
                return true;
            }
        }
        return false;
    }
}
