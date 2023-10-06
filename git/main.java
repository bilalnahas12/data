package git;

public class main {
    public static void main(String[] args) throws Exception{
        Compte ce = new CompteCourant(1500);
       Compte ce2 = new CompteEpargne(1500);
          System.out.println(ce.getSolde());
        ce.Versement(4000,ce2);

     
        System.out.println(ce2.getSolde());

        

}

      

    }
    

