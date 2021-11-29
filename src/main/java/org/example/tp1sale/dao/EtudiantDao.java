package org.example.tp1sale.dao;

import org.example.tp1sale.entity.Etudiant;

import java.util.List;

public interface EtudiantDao {
    void ajouter(Etudiant etudiant);

    List<Etudiant> lister();

    void update(Etudiant nouvelEtudiant, Long id);

    void delete(Long id);
}
