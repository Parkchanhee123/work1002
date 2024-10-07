package cust;

import edu.sm.dto.Cust;
import edu.sm.service.CustService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class C4_1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        CustService custService = (CustService) context.getBean("custService");

        String id = "id01";
        Cust cust = null;
        try{
            cust = custService.C4_1(id);
            System.out.println(cust);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
