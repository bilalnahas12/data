package git;

import java.util.Date;

import git.operations.Operations;
import git.operations.Retrait;
import git.operations.Versement;

public class CompteCourant extends Compte {
    private double decouvert;

    public CompteCourant(double decouvert) {
        super();
        this.decouvert = decouvert;
    }

  
 
    @Override
    public void verser(double mt) throws Exception {
        if(mt<100)throw new Exception("vous ne pouvez pas saisir ce montant");
        this.solde+=mt;
          operations.add(new Versement( new Date(), mt));

        
    }

    @Override
    public void retrait(double montant) {
        if (montant > 0 && solde - montant >= -decouvert) {
            this.solde -= montant;
            int numero=0;
            operations.add(new Retrait( new Date(), montant));
            
        }
    else{
        throw new UnsupportedOperationException("Unimplemented method 'effectuerRetrait'");}
    }

    @Override
    public void calculerInterets() {
        throw new UnsupportedOperationException("Unimplemented method 'calculerInterets'");
    }

}
