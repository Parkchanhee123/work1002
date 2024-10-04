package edu.sm.test;

import edu.sm.dto.Item;
import edu.sm.service.AdminService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class M111_1 {
    public static void main(String[] args) {
        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");
        AdminService service = (AdminService) factory.getBean("adminService");
        Item item = Item.builder()
                .item_id(1)
                .item_name("테스트")
                .build();

        try {
            service.M111_1(item);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
