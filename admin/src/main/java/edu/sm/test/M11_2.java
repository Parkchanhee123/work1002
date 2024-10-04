package edu.sm.test;

import edu.sm.dao.ManagerDao;
import edu.sm.dto.Item;
import edu.sm.frame.ConnectionPool;
import edu.sm.service.AdminService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class M11_2 {
    public static void main(String[] args) {
        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");
        AdminService service = (AdminService) factory.getBean("adminService");
        Item item = Item.builder()
                .item_id(1)
                .flag(false)
                .build();

        try {
            service.M11_2(item);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
