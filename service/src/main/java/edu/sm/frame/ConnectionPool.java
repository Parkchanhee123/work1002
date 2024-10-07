package edu.sm.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConnectionPool {

    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();
    private static final int INITIAL_POOL_SIZE = 3;
    static ResourceBundle rb;

    static {
        try {
            rb = ResourceBundle.getBundle("mysql", Locale.KOREA);
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL Driver not found!", e);
        } catch (Exception e) {
            throw new RuntimeException("Error loading database configuration!", e);
        }
    }

    public static ConnectionPool create() throws SQLException {
        String url = rb.getString("url");
        String user = rb.getString("user");
        String password = rb.getString("password");

        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.add(createConnection(url, user, password));
        }
        return new ConnectionPool(pool);
    }

    private ConnectionPool(List<Connection> connectionPool) {
        this.connectionPool = connectionPool;
    }

    public Connection getConnection() {
        if (connectionPool.isEmpty()) {
            throw new RuntimeException("All connections are in use!");
        }
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

    public int getUseSize() {
        return connectionPool.size();
    }
}
