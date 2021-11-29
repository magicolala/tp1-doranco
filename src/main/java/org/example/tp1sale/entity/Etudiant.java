package org.example.tp1sale.entity;

public class Etudiant {

  private Long id;
  private String nom;
  private String prenom;
  private String matricule;

  public Etudiant(Long id, String nom, String prenom, String matricule) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    this.matricule = matricule;
  }

  public Etudiant(String nom, String prenom, String matricule) {
    this.nom = nom;
    this.prenom = prenom;
    this.matricule = matricule;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public Etudiant setPrenom(String prenom) {
    this.prenom = prenom;

    return this;
  }

  public String getMatricule() {
    return matricule;
  }

  public void setMatricule(String matricule) {
    this.matricule = matricule;
  }

  @Override
  public String toString() {
    return (
      "Etudiant{" +
      "id=" +
      id +
      ", nom='" +
      nom +
      '\'' +
      ", prenom='" +
      prenom +
      '\'' +
      ", matricule='" +
      matricule +
      '\'' +
      '}'
    );
  }
}
