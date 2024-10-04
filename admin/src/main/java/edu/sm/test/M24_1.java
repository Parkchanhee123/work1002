package edu.sm.test;

import edu.sm.service.TotalOrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class M24_1 {
    public static void main(String[] args) {
        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");
        TotalOrderService service = (TotalOrderService) factory.getBean("totalOrderService");

        try {
            service.M24_1();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
