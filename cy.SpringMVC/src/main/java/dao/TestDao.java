package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.TestService;

@Component
public class TestDao {

    public void testDao() {
        System.out.println("这是dao包下的testDao方法");
    }
}
