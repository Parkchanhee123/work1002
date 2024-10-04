package edu.sm.test;

import edu.sm.dao.ManagerDao;
import edu.sm.dto.Item;
import edu.sm.frame.ConnectionPool;
import edu.sm.service.AdminService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class M112_1 {
    public static void main(String[] args) {
        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");
        AdminService service = (AdminService) factory.getBean("adminService");

        // 삽입할 Item 객체 생성
        Item item = Item.builder()
                .category_id(10)               // 카테고리 ID 설정
                .item_name("바지5")             // 상품 이름 설정
                .itemPrice(6000)               // 상품 가격 설정
                .item_stock(5)                 // 상품 재고 설정
                .item_img("바지5_이미지.jpg")   // 상품 이미지 설정 (예시)
                .item_text("안찢어지는바지")          // 상품 설명 설정
                .build();

        try {
            service.M112_1(item);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
