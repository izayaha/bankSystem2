package com.iza.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iza.common.JsonResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * projectName:  bankSystem
 *
 * @author: xuwei
 * ime:  2020/9/3 20:27
 * description:
 */
public class JsonUtils {
    public static void writeJsonInfo(int code, Object info, HttpServletResponse response){
        JsonResult jsonResult = new JsonResult(code, info);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = null;
        try {
            s = objectMapper.writeValueAsString(jsonResult);
            PrintWriter writer = response.getWriter();
            writer.print(s);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
