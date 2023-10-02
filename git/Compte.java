package git;


import java.io.FileWriter;
import java.io.IOException;
import java.rmi.server.Operation;
import java.util.ArrayList;
import java.util.List;

import git.operations.Operations;

public abstract class Compte {
    private String code;
    protected double solde;
    private StatutDeCompte statut;
    protected List<Operations> operations = new ArrayList<>();

    public Compte(String code, double solde, StatutDeCompte statut) {
        this.code = code;
        this.solde = solde;
        this.statut = statut;
    }

    public abstract void verser(double montant);

    public abstract void retrait(double montant);

    public abstract void calculerInterets();

    public void ajouterOperation(Operations operation) {
        operations.add(operation);
    }
    public abstract void effectuerOperation(Operations operation);
    public double getSolde() {
        return solde;
    }
    public void  Versement(double m,Compte c){
        
    }

    public List<Operations> getOperations() {
        return operations;
    }
    public void enregistrerHistorique(String nomClient) {
        try {
            FileWriter writer = new FileWriter(nomClient + "c.txt");
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
