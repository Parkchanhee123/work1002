package item;

import edu.sm.dto.Item;
import edu.sm.service.ItemService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class C31_1 {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")) {
            ItemService itemService = (ItemService) context.getBean("itemService");

            List<Item> items = itemService.C31_1();
            System.out.println(items);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
