package edu.sm.service;

import edu.sm.dao.ManagerDao;
import edu.sm.dto.*;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.util.List;


public class AdminService implements MService<String, AdminInfo> {
    ManagerDao dao;
    ConnectionPool cp;
    public void setDao(ManagerDao dao) {
        this.dao = dao;
    }
    public void setCp(ConnectionPool cp) {
        this.cp = cp;
    }

    public AdminInfo loginCheck(String id, String pwd) throws Exception{
        Connection con = cp.getConnection();
        AdminInfo result = null;
        try{
            result = dao.selectByLogin(id, pwd, con);
        }catch(Exception e){
            throw e;
        }finally{
            cp.releaseConnection(con);
        }
        return result;
    }

    public List<Item> M11_1() throws Exception{
        Connection con = cp.getConnection();
        List<Item> result = null;
        try{
            result = dao.M11_1(con);
        }catch(Exception e){
            throw e;
        }finally{
            cp.releaseConnection(con);
        }

        return result;
    }
    public Boolean M11_2(Item i) throws Exception{
        Connection con = cp.getConnection();
        try{
            dao.M11_2(i, con);
        }catch(Exception e){

        }finally {
            cp.releaseConnection(con);
        }
        return false;
    }

    public Boolean M111_1(Item item) throws Exception{
        Connection con = cp.getConnection();
        Boolean isUpdated = false;
        try{
            isUpdated = dao.M111_1(item, con);
            if (isUpdated) {
                System.out.println("상품이 성공적으로 업데이트되었습니다.");
            } else {
                System.out.println("상품 업데이트에 실패했습니다.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            cp.releaseConnection(con);
        }

        return isUpdated;
    }

    public Item M112_1(Item item) throws Exception{
        Connection con = cp.getConnection();
        try{
            con.setAutoCommit(false);
            dao.M112_1(item, con);
            con.commit();
            System.out.println("정상적으로 상품이 등록되었습니다.");
        }catch(Exception e){
            throw e;
        }finally{
            cp.releaseConnection(con);
        }
        return item;
    }

    public List<Review> M31_1() throws Exception{
        Connection con = cp.getConnection();
        List<Review> result = null;
        try{
            dao.M31_1(con);
        }catch(Exception e){
            throw e;
        }finally{
            cp.releaseConnection(con);
        }
        return result;
    }

    public List<Cust> M41_1() throws Exception{
        Connection con = cp.getConnection();
        List<Cust> result = null;
        try{
            dao.M41_1(con);
        }catch(Exception e){
            throw e;
        }finally {
            cp.releaseConnection(con);
        }
        return result;
    }

    public Answer M311_1(Answer answer) throws Exception{
        Connection con = cp.getConnection();
        Answer result = null;
        try {
            dao.M311_1(answer, con);
        }catch(Exception e){
            throw e;
        }finally{
            cp.releaseConnection(con);
        }
        return result;
    }

    public Boolean M411_1(Cust cust) throws Exception{
        Connection con = cp.getConnection();
        Boolean result = false;
        try{
            dao.M411_1(cust, con);
        } catch (Exception e) {
            throw e;
        }finally{
            cp.releaseConnection(con);
        }
        return result;
    }
}
