package whileatmprojesi;

import java.util.Scanner;

public class WhileAtmProjesi {

    public static void main(String[] args) {
        /* 
        While döngüsü kullanarak bir tane ATM programı yapma
        İşlemler
        1.İşlem : Bakiye Öğrenme
        2.İŞlem : Para Çekme
        3.İşlem : Para Yatırma
        Çıkış : q
        */
        Scanner scanner = new Scanner(System.in);
        int bakiye = 1000;
        String islemler = ("Lütfen yapmak istediğiniz işlemi seçiniz : \n "
                          + " 1.İşlem : Bakiye Öğrenme \n "+ " 2.İŞlem : Para Çekme \n "
                          + " 3.İşlem : Para Yatırma \n" 
                          + "  Çıkış için q'a basınız");
        System.out.println(islemler);
        System.out.println("*************************************************");
        
        while(true){
            System.out.println("İşlemi seçiniz ");
            String islem = scanner.nextLine();
            
            if(islem.equals("q")){
                System.out.println("Çıkış yapılıyor..");
                break;
            }
            else if(islem.equals("1")){
                System.out.println("Bakiyeniz: " + bakiye);
            }
            else if(islem.equals("2")){
                System.out.println("Çekmek istediğiniz tutar: ");
                int tutar = scanner.nextInt();
                int kalBakiye = bakiye-tutar;
                if(kalBakiye>0){
                    System.out.println("Kalan bakiye : " + kalBakiye);
                }else
                    System.out.println("Yeterli bakiye yok" + " " + "Bakiyeniz: " + bakiye);
                scanner.nextLine(); 
            }
            else if(islem.equals("3")){
                System.out.println("Yatırmak istediğiniz tutar: ");
                int tutar = scanner.nextInt();
                int topBakiye = bakiye+tutar;
                System.out.println("Toplam bakiyeniz: " + topBakiye);
                scanner.nextLine();
            }else
                System.out.println("Geçersiz işlem..");
            
        }
        
        
        
       
        
        
        
        
    }
    
}
