package org.example.tp1sale.dao;

import java.util.List;
import org.example.tp1sale.entity.Etudiant;

public interface EtudiantDao {
  void ajouter(Etudiant etudiant);
  List<Etudiant> lister();
  void update(Etudiant nouvelEtudiant, Long id);
  void delete(Long id);
}
