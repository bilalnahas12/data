package git.operations;

import java.util.Date;

public class Operations {
    private int numero;
    private Date date;
    private double montant;

    public Operations(int numero, Date date, double montant) {
        this.numero = 0;
        this.date = date;
        this.montant = montant;
    }
    public double getMontant() {
        return montant;
    }

}
