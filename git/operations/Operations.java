package git.operations;

import java.util.Date;

public class Operations {
    private int numero=0;
    private Date date;
    private double montant;

    public Operations( Date date, double montant) {
        this.numero = ++numero;
        this.date = date;
        this.montant = montant;
    }
    public double getMontant() {
        return montant;
    }
    public Date getDate() {
        return date;
    }

}
