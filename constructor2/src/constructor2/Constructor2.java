package constructor2;

public class Constructor2 {

    public static void main(String[] args) {
        
        account account1 = new account();
        //System.out.println(account1.getEmail());  // "Bilgi Yok" çıktısı verdi.
        
        account account2 = new account("Ceyda", "info@gmail.com","4565785");
        //System.out.println(account2.getEmail());
        //System.out.println(account2.getHesapNo());
        account2.bilgileriGoster();
    }
    
}
