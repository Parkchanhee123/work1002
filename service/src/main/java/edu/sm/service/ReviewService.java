package edu.sm.service;

import edu.sm.dao.ReviewDao;
import edu.sm.dao.TotalOrderDao;
import edu.sm.dto.Review;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class ReviewService implements MService<String, Review> {
    private ReviewDao dao;
    private ConnectionPool cp;

    public void setDao(ReviewDao dao) {
        this.dao = dao;
    }

    public void setCp(ConnectionPool cp) {
        this.cp = cp;
    }

    public Review C221_1(Review review) throws Exception {
        Connection con = null;
        try {
            con = cp.getConnection();
            return dao.C221_1(review, con);
        } finally {
            if (con != null) {
                cp.releaseConnection(con);
            }
        }
    }

    public boolean C211_2(Review review) throws Exception {
        Connection con = null;
        try {
            con = cp.getConnection();
            return dao.C211_2(review, con);
        } finally {
            if (con != null) {
                cp.releaseConnection(con);
            }
        }
    }
}
