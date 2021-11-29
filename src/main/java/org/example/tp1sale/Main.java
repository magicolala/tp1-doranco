package org.example.tp1sale;

import org.example.tp1sale.dao.DaoFactory;
import org.example.tp1sale.dao.EtudiantDao;
import org.example.tp1sale.entity.Etudiant;

import java.io.IOException;
import java.util.List;

public class Main {

    static EtudiantDao etudiantDao;

    public static void main(String[] args) throws IOException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        etudiantDao = daoFactory.getEtudiantDao();
        ajouter();
        lister();
        update();
        lister();
        delete();
        lister();
    }

    private static void ajouter() {
        Etudiant etudiant = new Etudiant("Oloa", "Cédric", "12IHJ");
        etudiantDao.ajouter(etudiant);
    }

    private static void lister() {
        List<Etudiant> etudiants = etudiantDao.lister();
        etudiants.forEach(System.out::println);
    }

    private static void update() {
        Etudiant etudiant = new Etudiant("Oloa", "Cédric", "12IHJ");
        etudiantDao.update(etudiant, 2L);
    }

    private static void delete() {
        etudiantDao.delete(3L);
    }
}
