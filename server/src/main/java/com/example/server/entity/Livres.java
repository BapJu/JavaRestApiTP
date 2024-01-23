package com.example.server.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "livres")
public class Livres {
    private @Id @GeneratedValue Long id;
    private String titre;
    private String auteur;
    private String edition;
    private String description;
    //Constructeur par défaut pour SPRING
    public Livres(){
    }

    //Constructeur surchargé pour initialiser les attributs
    public Livres(String titre, String auteur, String edition, String description){
        this.titre = titre;
        this.auteur = auteur;
        this.edition = edition;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }
    
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
