package Voiture_RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IVoiture extends Remote {
    int D_reparation(Voiture v) throws RemoteException;
    String Verif_Statut(String matricule) throws RemoteException;
    Voiture D_Sortie(String matricule) throws RemoteException;
}
