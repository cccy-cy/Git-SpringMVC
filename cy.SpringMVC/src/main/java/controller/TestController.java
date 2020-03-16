package controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.TestService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller//每个controller都要继承BaseController（自己写的） 主要是要用里面的一个writeJson这个方法
public class TestController extends BaseController{

    @Autowired
    private TestService testService;

    @ResponseBody//直接返回json 注解驱动
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public List<String> test(@RequestParam("a")String paramA,
                             @RequestParam("b")int paramB,
                             @CookieValue("cookie")String cookieValue,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        testService.testService();
        System.out.println(paramA);
        System.out.println(paramB);
        System.out.println(cookieValue);

        //继承BaseController这个类，调用里面的writeJSON方法
        //1需要引用fastjson这个jar包
//        JSONObject json = new JSONObject();
//        json.put("a", 1);
//        json.put("c", 2);
        //返回json
//        writeJSON(response, ResponseStatus.SUCCESS, "查询成功", json.toJSONString());

        //或者直接返回json（不需要继承BaseController） 实质就是用json返回，
        //1需要引用3个jar包 jackson-core jackson-databind jackson-annotations
        //2需要在上面的test方法上标注一个@ResponseBody注解
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        return list;
    }
}
