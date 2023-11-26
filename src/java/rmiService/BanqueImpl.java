package java.rmiService;

import metier.Compte;

import java.util.HashMap;
import java.util.Map;

public class BanqueImpl implements IBanque {

    private Map<Integer, Compte> comptes;
    // Une structure de données pour stocker les comptes

    public BanqueImpl() {
        this.comptes = new HashMap<>();
    }

    @Override
    public String creerCompte(Compte c) {
        if (c != null && c.getCode() > 0) {
            // Vérifier si le compte existe déjà
            if (comptes.containsKey(c.getCode())) {
                return "Le compte existe déjà.";
            } else {
                comptes.put(c.getCode(), c);
                return "Compte créé avec succès.";
            }
        } else {
            return "Code de compte invalide.";
        }
    }

    @Override
    public String getInfoCompte(int code) {
        if (comptes.containsKey(code)) {
            Compte compte = comptes.get(code);
            return "Code: " + compte.getCode() + ", Solde: " + compte.getSolde();
        } else {
            return "Compte non trouvé.";
        }
    }
}
