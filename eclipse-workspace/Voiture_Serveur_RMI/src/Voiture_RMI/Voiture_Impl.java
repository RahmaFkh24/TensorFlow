package Voiture_RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class Voiture_Impl extends UnicastRemoteObject implements IVoiture {
    private ArrayList<Voiture> voitures;
    private int nbr_voiture = 0;
    private final int n_max = 5;

    protected Voiture_Impl() throws RemoteException {
        super();
        voitures = new ArrayList<>(); // Initialisation de la liste
        Voiture voiture1 = new Voiture("123", new Date(), VoitureStatut.EN_PANNE);
        voitures.add(voiture1);
    }

    @Override
    public int D_reparation(Voiture v) throws RemoteException {
        int res = -1;
        if (nbr_voiture < n_max) {
            v.setStatut(VoitureStatut.EN_COURS_REPARATION);
            v.setDateReparation(new Date());
            voitures.add(v); // Ajout de la voiture à la liste
            nbr_voiture++;
            res = 1;
        }
        return res;
    }

    @Override
    public String Verif_Statut(String matricule) throws RemoteException {
        Optional<Voiture> voiture = voitures.stream()
                .filter(v -> v.getMatricule().equals(matricule))
                .findFirst();

        if (voiture.isEmpty()) {
            throw new RemoteException("Le matricule " + matricule + " ne figure pas dans la liste.");
        }
        return voiture.get().getStatut().name();
    }

    @Override
    public Voiture D_Sortie(String matricule) throws RemoteException {
        Optional<Voiture> voitureOpt = voitures.stream()
                .filter(v -> v.getMatricule().equals(matricule))
                .findFirst();

        if (voitureOpt.isEmpty()) {
            throw new RemoteException("Voiture introuvable pour le matricule : " + matricule);
        }

        Voiture voiture = voitureOpt.get();
        voiture.setStatut(VoitureStatut.REPARE);
        nbr_voiture--; // Décrémenter le compteur
        return voiture;
    }

}
