package org.example.tp1sale.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {

    private String url;
    private String username;
    private String password;

    public DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() throws IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Impossible de charger le pilote");
        }

        FileInputStream in         = new FileInputStream("src/main/resources/config.properties");
        Properties      properties = new Properties();

        properties.load(in);

        String bdd      = properties.getProperty("bdd");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        return new DaoFactory("jdbc:mysql://localhost:3306/" + bdd, username, password);
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url, this.username, this.password);
    }

    public EtudiantDao getEtudiantDao() {
        return new EtudiantDaoImpl(this);
    }
}
