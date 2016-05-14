package com.example.rebeckareitmaier.faceless;

import java.sql.*;
import java.util.Properties;

/**
 * Created by gustav on 2016-05-14.
 */
public class DataBaseConnector {

    private static DataBaseConnector instance = null;

    private static final String USERNAME = "tda357_014";
    private static final String PASSWORD = "HfzUbAnh";

    private Connection conn;

    protected DataBaseConnector() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:postgresql://ate.ita.chalmers.se/";
        Properties props = new Properties();
        props.setProperty("user", USERNAME);
        props.setProperty("password", PASSWORD);
        try {
            conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DataBaseConnector getInstance() {
        if (instance == null) {
            instance = new DataBaseConnector();
        }

        return instance;
    }

    public void getUsers() throws SQLException {
        PreparedStatement st = conn.prepareStatement("SELECT userName FROM Users");
        ResultSet rs = st.executeQuery();

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        System.out.println("Users");
        if (rs.next()) {
            for (int i = 1; i < columnsNumber + 1; i++) {
                System.out.println(rs.getString(i));
            }
        }
        rs.close();
        st.close();
    }

}
