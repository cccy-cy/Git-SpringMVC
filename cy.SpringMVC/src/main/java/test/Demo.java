package test;

import dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import service.TestService;

import java.lang.reflect.Field;

public class Demo {

    private static ApplicationContext cx;

    static {
//        cx = new ClassPathXmlApplicationContext("config/cccy.xml");//打包之后的
        cx = new FileSystemXmlApplicationContext("cy.SpringMVC/src/main/resources/config/cccy.xml");//打包之前的
    }

    public static void main(String[] args) {

        TestService service = (TestService) cx.getBean("testService");
        service.testService();
    }
}
