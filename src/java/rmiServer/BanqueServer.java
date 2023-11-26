package java.rmiServer;

import rmiService.BanqueImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class BanqueServer {
    public static void main(String[] args) {

        try {
            // Création d'un registre RMI sur le port 1099
            LocateRegistry.createRegistry(1099);

            // Création d'une instance de la classe d'implémentation ConversionImpl
            BanqueImpl BanqueObject = new BanqueImpl();

            // Affichage de la représentation textuelle de l'objet créé (utile pour le débogage)
            System.out.println(BanqueObject.toString());

            // Liaison de l'objet avec le registre RMI sous le nom "ConversionObject"
            Naming.rebind("rmi://localhost:1099/BanqueObject",  BanqueObject);
        } catch (RemoteException | MalformedURLException e) {
            // En cas d'erreur, l'exception est encapsulée dans une RuntimeException
            throw new RuntimeException(e);
        }
    }
}
