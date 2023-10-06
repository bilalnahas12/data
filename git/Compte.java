package git;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import git.operations.Operations;
import git.operations.Retrait;
import git.operations.Versement;

public abstract class Compte {
    private int code;
    private static int nb=0;
    protected double solde;
    private StatutDeCompte statut;
    protected List<Operations> operations = new ArrayList<>();

    public Compte(int code, double solde ) {
        this.code = code;
        this.solde = solde;
        this.statut = StatutDeCompte.CREATED;
    }
    public Compte(){
          this.code = nb++;
        this.solde = 0;
        this.statut = StatutDeCompte.CREATED;
    }

    public abstract void verser(double montant) throws Exception;

    public abstract void retrait(double montant);

    public abstract void calculerInterets();

    public void ajouterOperation(Operations operation) {
        operations.add(operation);
    }
    public double getSolde() {
        return solde;
    }
    public void  Versement(double m,Compte c) throws Exception{
        retrait(m);
        c.verser(m);
    }
       public double totalRetrait() {
     double montantRetrait=0;
       if (operations instanceof Retrait) {
            Retrait retrait = (Retrait)operations;
             
            montantRetrait += retrait.getMontant();}
          return montantRetrait;
    }
      public double totalVersent() {
double montantRetrait=0;
       if (operations instanceof Versement) {
            Versement versement = (Versement)operations;
             
            montantRetrait += versement.getMontant();}
          return montantRetrait; 
       }
    

    public List<Operations> getOperations() {
        return operations;
    }
    public void enregistrerHistorique(String nomClient) {
        try {
            BufferedWriter writer = new BufferedWriter( new FileWriter(nomClient + "c.txt"));
            List<Operations> operations = getOperations();
            for (Operations operation : operations) {
                writer.write(operation.toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  
}
