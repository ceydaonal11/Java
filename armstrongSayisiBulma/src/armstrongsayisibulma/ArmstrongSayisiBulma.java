package armstrongsayisibulma;

import java.util.Scanner;

/**
 *
 * @author ceyda
 */
public class ArmstrongSayisiBulma {

    public static void main(String[] args) {
        /*
        Girilen bir sayının armstrong sayısı olup olmadığını bulmaya çalışın.
        Örn: 4 basamaklı bir sayının armstrong sayısı olması için şu şartı sağlaması gerekmektedir.
        1634 = 1^4 + 6^4 + 3^4 + 4^4 (Buradaki 4 basamak sayısı)
        
        Do-While döngüsüyle yapalım.
        */
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sayı giriniz: ");
        int sayi = scanner.nextInt();
        System.out.print("Basamak sayısını giriniz: ");
        int basamak_sayisi = scanner.nextInt();
        
        int gecici_sayi = sayi;
        int toplam = 0;
        
        do{
            
            int basamak_degeri = gecici_sayi %10;
            gecici_sayi /= 10;
            toplam += Math.pow(basamak_degeri, basamak_sayisi);
 
        }while(gecici_sayi>0); // Geçici sayı 0 olursa döngümüzü sonlandırması gerekir
        
         if(toplam==sayi){
                System.out.println("Armstrong sayıdır.");
            }else
                System.out.println("Armstrong sayı değildir.");
            
        
    }
    
}
