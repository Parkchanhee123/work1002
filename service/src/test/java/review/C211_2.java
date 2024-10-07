package review;

import edu.sm.dto.Review;
import edu.sm.service.ReviewService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class C211_2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ReviewService reviewService = (ReviewService) context.getBean("reviewService");

        Review review = Review.builder()
                .review_id(1)
                .build();

        try {
            boolean result = reviewService.C211_2(review);
            if (result) {
                System.out.println("Review deleted successfully.");
            } else {
                System.out.println("Review deletion failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
