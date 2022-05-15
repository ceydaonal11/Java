
 /*
      Bu operatörler bir sayının değerini 1 artırır veya 1 azaltır. Değişkenlerin değereni arttıran ve azaltan ++ ve -- operatörlerinde
    bir istisna vardır. Bu operatörler, değişkeninin başına veya sonuna gelebilir.
    */
    /*
    public static void main(String[] args) {
   
        int sayi1 =10;
        int a,b;
        a=sayi1++;
        b=sayi1;
        System.out.println("Sona yazılırsa :" +a);
        System.out.println("Sayının yeni değeri :" +b);
        
    }*/

public class Arttırma_Azaltma_Operatörleri {
    public static void main(String[] args) {
        
        int sayi1=20;
        int a,b,c,d,e,f;
        a=++sayi1;
        b=sayi1--;
        c=--sayi1;
        d=++sayi1;
        e=sayi1++;
        f=sayi1;
        System.out.println(" A değeri " +a);
        System.out.println(" B değeri " +b);
        System.out.println(" C değeri " +c);
        System.out.println(" D değeri " +d);
        System.out.println(" E değeri " +e);
        System.out.println(" F değeri " +f);
    }
   
}
