package controller;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseController {

    //参数从左到右依次是，response， 状态， 一个消息， 内容
    public void writeJSON(HttpServletResponse response, ResponseStatus status, String msg, JSONObject data) {
        writeJSON(response, status, msg, data.toJSONString());
    }

    public void writeJSON(HttpServletResponse response, ResponseStatus status, String msg, String data) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", status.getValue());
            jsonObject.put("msg", msg);
            jsonObject.put("data", data);
            response.getWriter().write(jsonObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

enum ResponseStatus {

    SUCCESS("success"), FAIL("fail");

    private String value;

    ResponseStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

