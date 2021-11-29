package org.example.tp1sale.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

  private String url;
  private String username;
  private String password;

  public DaoFactory(String url, String username, String password) {
    this.url = url;
    this.username = username;
    this.password = password;
  }

  public static DaoFactory getInstance() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("Impossible de charger le pilote");
    }

    DaoFactory instance = new DaoFactory(
      "jdbc:mysql://localhost:3306/bdtp",
      "root",
      ""
    );

    return instance;
  }

  public Connection getConnection() throws SQLException {
    return DriverManager.getConnection(this.url, this.username, this.password);
  }

  public EtudiantDao getEtudiantDao() {
    return new EtudiantDaoImpl(this);
  }
}
