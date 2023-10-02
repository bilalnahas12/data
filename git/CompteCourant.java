package git;

import java.util.Date;

import git.operations.Operations;
import git.operations.Retrait;
import git.operations.Versement;

public class CompteCourant extends Compte {
    private double decouvert;

    public CompteCourant(String code, double solde, StatutDeCompte statut, double decouvert) {
        super(code, solde, statut);
        this.decouvert = decouvert;
    }

    @Override
    public void effectuerOperation(Operations operation) {
        if (operation instanceof Retrait) {
            Retrait retrait = (Retrait) operation;
            double montantRetrait = retrait.getMontant();
            if (montantRetrait > 0 && super.getSolde() - montantRetrait >= -decouvert) {
                super.solde -= montantRetrait;
                super.getOperations().add(operation);
            }
        } else if (operation instanceof Versement) {
            super.solde += operation.getMontant();
            super.getOperations().add(operation);
        }
    }

    @Override
    public void  verser(double montant) {
        throw new UnsupportedOperationException("Unimplemented method 'effectuerVersement'");
    }

    @Override
    public void retrait(double montant) {
        if (montant > 0 && solde - montant >= -decouvert) {
            this.solde -= montant;
            int numero=0;
            operations.add(new Retrait(numero++, new Date(), -montant));
            
        }
    else{
        throw new UnsupportedOperationException("Unimplemented method 'effectuerRetrait'");}
    }

    @Override
    public void calculerInterets() {
        throw new UnsupportedOperationException("Unimplemented method 'calculerInterets'");
    }

}
