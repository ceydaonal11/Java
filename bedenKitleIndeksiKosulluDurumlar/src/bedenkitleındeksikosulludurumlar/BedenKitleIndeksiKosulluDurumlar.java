package bedenkitleındeksikosulludurumlar;

import java.util.Scanner;

/**
 *
 * @author ceyda
 */
public class BedenKitleIndeksiKosulluDurumlar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen kilonuzu giriniz ");
        int kilo = scanner.nextInt();
        System.out.println("Lütfen boyunuzu giriniz (örn:1,75)");
        double boy = scanner.nextDouble();
        double bki = kilo / (boy*boy);
        System.out.println("Beden kitle indeksiniz: " + bki);
        
        if(bki<18.5)
            System.out.println("Zayıf");
        else if(bki>18.5 && bki<25)
            System.out.println("Normal");
        else if(bki>25 && bki<30)
            System.out.println("Fazla Kilolu");
        else
            System.out.println("Obez");
    }
    
}
