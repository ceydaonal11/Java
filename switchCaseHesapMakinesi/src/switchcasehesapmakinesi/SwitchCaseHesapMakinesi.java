package switchcasehesapmakinesi;
import java.util.Scanner;

public class SwitchCaseHesapMakinesi {

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------");
        String islemler = "1. Toplama İşlemi \n" 
                          +"2. Çıkarma İşlemi \n" 
                          +"3. Çarpma İşlemi \n" 
                          +"4. Bölme İşlemi \n";
        System.out.println(islemler);
        System.out.print("------------------------------------");
        int s1;
        int s2;
        System.out.println("Lütfen işlemi seçiniz");
        String islem = scanner.nextLine();
        
        switch(islem){
            case "1":
                System.out.println("Birinci sayıyı giriniz ");
                s1=scanner.nextInt();
                System.out.println("İkinci sayıyı giriniz ");
                s2=scanner.nextInt();
                System.out.println("Girilen değerlerin toplam: " + (s1+s2));
                break;
            case "2":
                System.out.println("Birinci sayıyı giriniz ");
                s1=scanner.nextInt();
                System.out.println("İkinci sayıyı giriniz ");
                s2=scanner.nextInt();
                System.out.println("Girilen değerlerin farkı: " + (s1-s2));
                break;
            case "3":
                System.out.println("Birinci sayıyı giriniz ");
                s1=scanner.nextInt();
                System.out.println("İkinci sayıyı giriniz ");
                s2=scanner.nextInt();
                System.out.println("Girilen değerlerin çarpımı: " + (s1*s2));
                break;
            case "4":
                System.out.println("Birinci sayıyı giriniz ");
                s1=scanner.nextInt();
                System.out.println("İkinci sayıyı giriniz ");
                s2=scanner.nextInt();
                System.out.println("Girilen değerlerin bölümü: " + ((double)s1/s2));  
                break;
        }
        
        
    }
    
}
