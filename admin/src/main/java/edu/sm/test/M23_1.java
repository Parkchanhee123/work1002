package edu.sm.test;

import edu.sm.service.TotalOrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class M23_1 {
    public static void main(String[] args) {
        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");
        TotalOrderService service = (TotalOrderService) factory.getBean("totalOrderService");

        try {
            service.M23_1();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
