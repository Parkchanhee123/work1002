package edu.sm.test;

import edu.sm.dao.ManagerDao;
import edu.sm.dto.Review;
import edu.sm.frame.ConnectionPool;
import edu.sm.service.AdminService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.List;

public class M31_1 {
    public static void main(String[] args) {
        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");
        AdminService service = (AdminService) factory.getBean("adminService");

        try {
            service.M31_1();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
