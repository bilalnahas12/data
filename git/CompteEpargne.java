package git;


import java.util.Date;

import git.operations.Operations;
import git.operations.Retrait;
import git.operations.Versement;

public class CompteEpargne extends Compte {
    private double tauxInteret;

    public CompteEpargne(String code, double solde, StatutDeCompte statut, double tauxInteret) {
        super(code, solde, statut);
        this.tauxInteret = tauxInteret;
    }

    @Override
    public void effectuerOperation(Operations operation) {
        if (operation instanceof Retrait) {
            Retrait retrait = (Retrait) operation;
            double montantRetrait = retrait.getMontant();
            if (montantRetrait > 0 && super.getSolde() >= montantRetrait) {
                super.solde -= montantRetrait;
                super.getOperations().add(operation);
            } 
        } else if (operation instanceof Versement) {
            super.solde += operation.getMontant();
            super.getOperations().add(operation);
        }
    }

    @Override
    public void verser(double montant) {
        throw new UnsupportedOperationException("Unimplemented method 'effectuerVersement'");
    }

    @Override
    public void retrait(double montant) {
           if (montant > 0 && solde >= montant) {
            this.solde -= montant;
            int numeroOperation=0;
            operations.add(new Retrait(numeroOperation++, new Date(), -montant));
            
        }
    else{
        throw new UnsupportedOperationException("Unimplemented method 'effectuerRetrait'");}}
    

    @Override
    public void calculerInterets() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculerInterets'");
    }

  

}

