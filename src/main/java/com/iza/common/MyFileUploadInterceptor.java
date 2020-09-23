package com.iza.common;

import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * projectName:  bankSystem2
 *
 * @author: xuwei
 * ime:  2020/9/17 20:18
 * description:
 */
public class MyFileUploadInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断上传文件大小
        ServletRequestContext servletRequestContext = new ServletRequestContext(request);
        // 文件大小 byte
        long l = servletRequestContext.contentLength();
        if (l>1048576) {
            throw new MaxUploadSizeExceededException(1048576);
        }
        //放行
        return true;
    }
}
