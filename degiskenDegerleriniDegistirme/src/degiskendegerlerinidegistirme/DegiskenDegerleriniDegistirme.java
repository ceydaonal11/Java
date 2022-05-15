
package degiskendegerlerinidegistirme;

import java.util.Scanner;

/**
 *
 * @author ceyda
 */
public class DegiskenDegerleriniDegistirme {
    
    // Kullanıcıdan alınan iki sayının değerini değiştirme
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen 1. sayıyı giriniz: ");
        int sayi1 = scanner.nextInt();
        System.out.println("Sayi1: " + sayi1);
        System.out.print("Lütfen 2. sayıyı giriniz: ");
        int sayi2 = scanner.nextInt();
        System.out.println("Sayi2: " + sayi2);
        System.out.println("Değiştirilmeden önce..");
        System.out.println("Birinci Sayı: " + sayi1 +" "+ "İkinci Sayı: " + sayi2 );
        int sayi3= sayi2;
        sayi2 = sayi1;
        System.out.println("yeni sayi1: " + sayi3);
        System.out.println("yeni sayi2: " + sayi2);
        System.out.println("Değiştirildikten sonra..");
        System.out.println("Birinci Sayı: " + sayi3 + " " + "İkinci Sayı: " + sayi2);
        
        
        
        
        
        
    }
    
}
