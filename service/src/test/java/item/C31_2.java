package item;

import edu.sm.dto.Item;
import edu.sm.service.ItemService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class C31_2 {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")) {
            ItemService itemService = (ItemService) context.getBean("itemService");

            String s = "의류";
            List<Item> items = itemService.C31_2(s);

            System.out.println(items);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
