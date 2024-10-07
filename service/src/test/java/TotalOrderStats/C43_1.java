package TotalOrderStats;

import edu.sm.dto.TotalOrder;
import edu.sm.service.TotalOrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class C43_1 {
    public static void main(String[] args) {
        // Spring 컨텍스트 로드
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")) {
            // TotalOrderService 빈 가져오기
            TotalOrderService totalOrderService = (TotalOrderService) context.getBean("totalOrderService");

            List<TotalOrder> totalOrders = null;
            String s = "id09";  // 조회할 고객 아이디

            try {
                // 주문 목록 가져오기
                totalOrders = totalOrderService.C43_1(s);
                for (TotalOrder totalOrder : totalOrders) {
                    System.out.println("주문번호: " + totalOrder.getOrder_id() +
                            " 주문날짜: " + totalOrder.getOrder_date() +
                            " 가격: " + totalOrder.getPay_price());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
