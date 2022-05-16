package gelismisnothesaplama;

import java.util.Scanner;

/**
 *
 * @author ceyda
 */
public class GelismisNotHesaplama {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen Vize1 Notunuzu giriniz ");
        int v1 = scanner.nextInt();
        System.out.print("Lütfen Vize2 Notunuzu giriniz ");
        int v2 = scanner.nextInt();
        System.out.print("Lütfen Final notunuzu giriniz ");
        int f = scanner.nextInt();
        System.out.println("Vize1 notunuz: " + v1 +" "+ "Vize2 notunuz: " + v2 + " " + "Final notunuz: " + f );
        double v1Oran = (v1 * 30)/100;
        double v2Oran = (v2 * 30)/100;
        double fOran = (f * 40)/100;
        double ort = v1Oran+v2Oran+fOran;
        System.out.println("Sınav ortalamanız: " + ort );
       
        
        if(ort >= 90){
            System.out.println("Harf Notunuz: AA");
        }
        else if (ort<=90 && ort>=85){
            System.out.println("Harf Notunuz: BA");
        }
        else if (ort<=85 && ort>=80){
            System.out.println("Harf Notunuz: BB");
        }
        else if (ort<=80 && ort>=75){
            System.out.println("Harf Notunuz: CB");
        }
        else if (ort<=75 && ort>=70){
            System.out.println("Harf Notunuz: CC");
        }
        else if (ort<=70 && ort>=65){
            System.out.println("Harf Notunuz: DC");
        }
        else if (ort<=65 && ort>=60){
            System.out.println("Harf Notunuz: DD");
        }
        else if (ort<=60 && ort>=55){
            System.out.println("Harf Notunuz: FD");
        }
        else
            System.out.println("Harf Notunuz: FF");
    }
    
}
