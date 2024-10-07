package item;

import edu.sm.dto.Item;
import edu.sm.service.ItemService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class C311_1 {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")) {
            ItemService itemService = (ItemService) context.getBean("itemService");

            int id = 1;
            Item item = itemService.C311_1(id);

            System.out.println(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
