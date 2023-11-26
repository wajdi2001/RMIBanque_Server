package java.rmiService;

import metier.Compte;

import java.rmi.Remote;

public interface IBanque extends Remote {
    String creerCompte(Compte c);
    String getInfoCompte(int code);
}
