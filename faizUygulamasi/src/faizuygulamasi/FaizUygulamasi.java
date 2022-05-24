package faizuygulamasi;

import java.util.Scanner;

public class FaizUygulamasi {

    public static void main(String[] args) {
         /* Kullanıcıdan anapara değerini ve parasını kaç yıl vadeli yatırmak istediği
        bilgisini alın ve her sene sonunda toplam para miktarını ekrana yazdırın
        Faiz Oranı: %6 faiz oranı
        */
         System.out.println("Bankamıza Hoş Geldiniz.. Faiz Oranı : %6");
         double faizOrani = 0.06;
         Scanner scanner = new Scanner(System.in);
         System.out.print("Yatırmak istediğiniz miktar:  ");
         int anapara = scanner.nextInt();
         System.out.print("Paranızı kaç yıl vadeli yatırmak istersiniz? ");
         int vade = scanner.nextInt();
         double toplamPara = anapara;
         
         
         for(int i=1; i<=vade; i++){
             toplamPara = (toplamPara*faizOrani)+toplamPara;
             System.out.println(". yılın sonunda toplam para: " + (int)toplamPara);
         }
    }
    
}
