package Voiture_RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            IVoiture voitureService = (IVoiture) registry.lookup("VoitureService");

            // Exemple d'utilisation
            System.out.println("Ajout d'une voiture en réparation...");
            Voiture voiture = new Voiture("456", null, VoitureStatut.EN_PANNE);
            int result = voitureService.D_reparation(voiture);
            System.out.println("Résultat : " + (result == 1 ? "Voiture ajoutée" : "Erreur"));

            System.out.println("Vérification du statut de la voiture...");
            String statut = voitureService.Verif_Statut("456");
            System.out.println("Statut : " + statut);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

