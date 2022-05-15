package yakıttutarı;

import java.util.Scanner;

public class YakıtTutarı {

    public static void main(String[] args) {
       
      /*    
        Bir aracın kilometre de ne kadar yaktığı ve kaç kilometre yol yaptığı bilgilerini alın ve 
        sürücünün toplam ne kadar ödemesini gerektiğini hesaplayın
        */  
        
      Scanner scanner = new Scanner(System.in);
       
        System.out.print("Aracınız km de kaç kuruş yakıyor? (Örnek : 0,36)");
        double sayi1 = scanner.nextDouble(); // kullanıcıdan sayı alındı
        System.out.println("Aracınız km de kaç km yol yapıyor? ");
        double sayi2 = scanner.nextDouble();
        double sonuc = sayi1*sayi2;
        System.out.println("Ödemeniz gereken tutar : " + sonuc);
        
    }
    
}
