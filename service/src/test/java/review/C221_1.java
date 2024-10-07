package review;

import edu.sm.dto.Review;
import edu.sm.service.ReviewService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class C221_1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ReviewService reviewService = (ReviewService) context.getBean("reviewService");

        Review review = Review.builder()
                .review_title("67522")
                .review_text("22222222")
                .review_star(4)
                .review_id(1)
                .build();

        try {
            reviewService.C221_1(review);
            System.out.println("Review updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
