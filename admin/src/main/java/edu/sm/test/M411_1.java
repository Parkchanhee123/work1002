package edu.sm.test;

import edu.sm.dao.ManagerDao;
import edu.sm.dto.Cust;
import edu.sm.frame.ConnectionPool;
import edu.sm.service.AdminService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class M411_1 {
    public static void main(String[] args) {
        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");
        AdminService service = (AdminService) factory.getBean("adminService");

        // 업데이트할 고객 정보 (cust_id는 존재하는 값이어야 함)
        Cust cust = Cust.builder()
                .cust_id("id02")             // 수정할 고객 ID
                .cust_name("이름 바뀜 테스트중")      // 새로운 이름
                .build();

        try {
            service.M411_1(cust);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
