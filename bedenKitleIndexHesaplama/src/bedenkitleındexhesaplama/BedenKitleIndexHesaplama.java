package bedenkitleındexhesaplama;

import java.util.Scanner;

/**
 *
 * @author ceyda
 */
public class BedenKitleIndexHesaplama {

    // Beden kitle indeksi: Kilo/boy(m)*boy(m)
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen kilonuzu giriniz ");
        int kilo = scanner.nextInt();
        System.out.print("Kilonuz: " + kilo);
        System.out.print("Lütfen boyunuzu giriniz (1,75)");
        double boy = scanner.nextDouble();
        System.out.print("Boyunuz: " + boy);
        double bki = (kilo / (boy *boy));
        System.out.print("Beden kitle indeksiniz: " + bki);
    }
    
}
