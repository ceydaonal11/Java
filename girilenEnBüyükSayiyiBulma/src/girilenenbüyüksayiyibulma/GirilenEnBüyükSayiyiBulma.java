package girilenenbüyüksayiyibulma;

import java.util.Scanner;

/**
 *
 * @author ceyda
 */
public class GirilenEnBüyükSayiyiBulma {

    public static void main(String[] args) {
        /* 
        //Kullanıcıdan input almadan
        int s1 = 456;
        int s2 = 18;
        int s3 = 711;
        
        if(s1>s2 && s1>s3)
            System.out.println("En büyük sayı s1: " + s1 + " dir");
        else if(s2>s1 && s2>s3)
            System.out.println("En büyük sayı s2: " + s2 + " dir");
        else 
            System.out.println("En büyük sayı s3: " + s3 + " dir");
        */
        
        //Kullanıcıdan input alarak
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen 3 adet sayı giriniz..");
        int s1 = scanner.nextInt();
        int s2 = scanner.nextInt();
        int s3 = scanner.nextInt();
        System.out.println("Girdiğiniz 1.Sayı: " + s1 +" "+ "2.Sayı: " + s2 +" "+ "3.Sayı: " + s3);
        
        if(s1>s2 && s1>s3)
            System.out.println("En büyük sayı s1: " + s1 + " dir");
        else if(s2>s1 && s2>s3)
            System.out.println("En büyük sayı s2: " + s2 + " dir");
        else 
            System.out.println("En büyük sayı s3: " + s3 + " dir");
    }
    
}
