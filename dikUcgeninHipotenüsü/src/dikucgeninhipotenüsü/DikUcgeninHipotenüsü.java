
package dikucgeninhipotenüsü;

import java.util.Scanner;

/**
 *
 * @author ceyda
 */
public class DikUcgeninHipotenüsü {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen birinci kenarı giriniz");
        int birinci_kenar = scanner.nextInt();
        System.out.println("Birinci kenar: " + birinci_kenar);
        System.out.print("Lütfen ikinci kenarı giriniz");
        int ikinci_kenar = scanner.nextInt();
        System.out.println("İkinci kenar: " + ikinci_kenar);
        double h = Math.sqrt(birinci_kenar*birinci_kenar + ikinci_kenar*ikinci_kenar) ; // Math.sqrt --> Karekök almak için kullanılır. 
        System.out.println("Hipotenüs: " + h);
        
    }
    
}
