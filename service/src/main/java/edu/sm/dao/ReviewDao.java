package edu.sm.dao;

import edu.sm.dto.Review;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class ReviewDao implements Dao<String, Review> {

    public Review C221_1(Review review, Connection con) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(Sql.C221_1);
            ps.setString(1, review.getReview_title());
            ps.setString(2, review.getReview_text());
            ps.setInt(3, review.getReview_star());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
        }
        return review;
    }

    public boolean C211_2(Review review, Connection con) throws Exception {
        boolean success = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(Sql.C211_2);
            ps.setInt(1, review.getReview_id());
            int result = ps.executeUpdate();
            if (result == 1) {
                success = true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
        }
        return success;
    }
}
