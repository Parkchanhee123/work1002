package edu.sm.test;

import edu.sm.dao.ManagerDao;
import edu.sm.dto.Answer;
import edu.sm.frame.ConnectionPool;
import edu.sm.service.AdminService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class M311_1 {
    public static void main(String[] args) {
        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");
        AdminService service = (AdminService) factory.getBean("adminService");

        Answer answer = Answer.builder()
                .review_id(4)
                .admin_id("admin02")
                .answer_detail("잘쓰세요")
                .build();

        try {
            service.M311_1(answer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
