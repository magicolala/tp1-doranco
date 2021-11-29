package org.example.tp1sale.dao;

import org.example.tp1sale.entity.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDaoImpl implements EtudiantDao {

    private DaoFactory daoFactory;

    public EtudiantDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(Etudiant etudiant) {
        Connection        connection;
        PreparedStatement statement;

        try {
            connection = this.daoFactory.getConnection();
            statement =
                    connection.prepareStatement(
                            "INSERT INTO etudiant(nom, prenom, matricule) VALUES(?,?,?)");
            statement.setString(1, etudiant.getNom());
            statement.setString(2, etudiant.getPrenom());
            statement.setString(3, etudiant.getMatricule());
            statement.executeUpdate();
            System.out.println("------------Ajout Ok-------------");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public List<Etudiant> lister() {
        Connection     connection;
        Statement      statement;
        ResultSet      resultset;
        List<Etudiant> etudiants = new ArrayList<>();

        try {
            connection = daoFactory.getConnection();
            statement = connection.createStatement();
            resultset = statement.executeQuery("SELECT * FROM etudiant");

            while (resultset.next()) {
                String   id        = resultset.getString("id");
                String   nom       = resultset.getString("nom");
                String   prenom    = resultset.getString("prenom");
                String   matricule = resultset.getString("matricule");
                Etudiant etudiant  = new Etudiant(Long.parseLong(id), nom, prenom, matricule);
                etudiants.add(etudiant);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        System.out.println("------------ Liste des étudiants --------------");
        return etudiants;
    }

    @Override
    public void update(Etudiant nouvelEtudiant, Long id) {

        Connection        connection;
        PreparedStatement preparedStatement;

        try {
            connection = daoFactory.getConnection();
            preparedStatement =
                    connection.prepareStatement(
                            "UPDATE etudiant set nom=?, prenom=?, matricule=? WHERE id=?");
            preparedStatement.setString(1, nouvelEtudiant.getNom());
            preparedStatement.setString(2, nouvelEtudiant.getPrenom());
            preparedStatement.setString(3, nouvelEtudiant.getMatricule());
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();

            System.out.println("---------- Update Ok ------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {

        Connection        connection;
        PreparedStatement preparedStatement;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM etudiant WHERE id=?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            System.out.println("---------- Delete Ok ------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
