package Voiture_RMI;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            IVoiture voitureService = new Voiture_Impl();
            Registry registry = LocateRegistry.createRegistry(1098);
            registry.rebind("VoitureService", voitureService);
            System.out.println("Service Voiture enregistré avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
