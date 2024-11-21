package Voiture_RMI;

import java.io.Serializable;
import java.util.Date;

public class Voiture implements Serializable {
    private String matricule;
    private Date dateReparation;
    private VoitureStatut statut;

    public Voiture(String matricule, Date dateReparation, VoitureStatut statut) {
        this.matricule = matricule;
        this.dateReparation = dateReparation;
        this.statut = statut;
    }

    // Getters & setters
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Date getDateReparation() {
        return dateReparation;
    }

    public void setDateReparation(Date dateReparation) {
        this.dateReparation = dateReparation;
    }

    public VoitureStatut getStatut() {
        return statut;
    }

    public void setStatut(VoitureStatut statut) {
        this.statut = statut;
    }
}
