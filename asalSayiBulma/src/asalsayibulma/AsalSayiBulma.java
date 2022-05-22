package asalsayibulma;

public class AsalSayiBulma {

    public static void main(String[] args) {
        
        // 20 ile 90 arasındaki asal sayıları, uygun döngüleri kullanarak bulmaya çalışın.
            int sayac = 0;
            for(int sayi=20;sayi<90;sayi++)
            {
                int kontrol = 0;
                for (int i = 2; i < sayi; i++)
                {
                   if (sayi % i == 0)
                    {
                        kontrol = 1;
                        break;
                    } 
                }     
                if(kontrol==0)
                {
                    System.out.print(sayi+"\n");
                    sayac++; 
                }
            }

    }
}
