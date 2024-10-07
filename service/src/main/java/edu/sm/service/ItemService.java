package edu.sm.service;

import edu.sm.dao.ItemDao;
import edu.sm.dto.Item;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.util.List;

public class ItemService implements MService<Integer, Item> {
    private ItemDao dao;
    private ConnectionPool cp;

    public void setDao(ItemDao dao) {
        this.dao = dao;
    }

    public void setCp(ConnectionPool cp) {
        this.cp = cp;
    }

    public List<Item> C31_1() throws Exception {
        Connection con = cp.getConnection();
        List<Item> result = null;
        try {
            result = dao.C31_1(con);
        } finally {
            cp.releaseConnection(con);
        }
        return result;
    }

    public List<Item> C31_2(String s) throws Exception {
        Connection con = cp.getConnection();
        List<Item> result = null;
        try {
            result = dao.C31_2(s, con);
        } finally {
            cp.releaseConnection(con);
        }
        return result;
    }

    public Item C311_1(Integer i) throws Exception {
        Connection con = cp.getConnection();
        Item result = null;
        try {
            result = dao.C311_1(i, con);
        } finally {
            cp.releaseConnection(con);
        }
        return result;
    }

    public List<Item> C11_1() throws Exception {
        Connection con = cp.getConnection();
        List<Item> result = null;
        try {
            result = dao.C11_1(con);
        } finally {
            cp.releaseConnection(con);
        }
        return result;
    }
}
