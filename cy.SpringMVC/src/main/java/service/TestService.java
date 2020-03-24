package service;

import dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestDao dao;

    public void testService() {
        System.out.println("这是一个service里面的方法");
        dao.testDao();
    }

}
