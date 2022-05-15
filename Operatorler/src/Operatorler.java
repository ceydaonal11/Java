

public class Operatorler {

    public static void main(String[] args) {
       /*
        int a = 45, b = 100, c = 50, d = 12;
        a += 15;
        b -= 50;
        c *= 4;
        d /= 3;
        
         System.out.println(a);
         System.out.println(b);
         System.out.println(c);
         System.out.println(d);
        */
       
       /*
       int a = 46;
       int b = 49;
       int c = a = b;
       
        System.out.println(c);
        System.out.println(a);
        System.out.println(b);
       
       /* a yı b ye atarken a da c değişkenine atamış oluyoruz.
           Dolayısıyla en sağdaki değer olan a, bütün değişkenlere birden atanmış oluyor ve diğer 
          değişkenlerde b nin değerine sahip oluyorlar.*/
      
       /*
       
       // İKİ DEĞİŞKENİN DEĞERİNİN TAKAS YAPILMASI 
       int a = 7;
       int b = 6;
       int c;
       c = a;
       a = b;
       b = c;
       
        System.out.println("a nın değeri : " + a);
        System.out.println("b nin değiri  : " + b); 
       
        */
        
       /* İLİŞKİSEL OPERATÖRLER
       < Küçüktür
       > Büyüktür
       <= Küçük Eşittir
       >= Büyük Eşittir
       == Eşittir
       != Eşit Değildir  */   
       
       /*
       // ÖRNEK 1
       int x = 77;
       int y = 56;
       if (x>y)
            System.out.println("x y den büyüktür ");
       else if (x<y)
            System.out.println("x y den küçüktür ");
        
        */
       
       int a = 34;
       int b = 10;
        if(a==b)
            System.out.println("a sayısı b sayısına eşittir ");
        if(a!=b)
            System.out.println("a sayısı b sayısına eşit değildir ");
        if (a<b)
            System.out.println("a sayısı küçüktür b sayısından");
        if (a>b)
            System.out.println("a sayısı büyüktür b sayısından");
        if (a<=b)
            System.out.println("a sayısı b sayısından küçük ve eşittir ");
       
        // ARİTMETİK OPERATÖRLER
           // % Mod işlemi yapar, işlem sonucunda kalanı verir      
        
         int m = 60;
         int n = 4;
         System.out.println("Toplama işleminin sonucu : " + (m+n));
         System.out.println("Çıkarma işleminin sonucu : " + (m-n));
         System.out.println("Çarpma işleminin sonucu : " + (m*n));
         System.out.println("Bölme işleminin soncu : " + (m/n));
         
         // MOD OPERATÖRÜ
         int o = 77;
         int ö = 6;
         System.out.println("Sayının Modu : " + (o%ö));
           
           
           
           
           
           
           
           
           
        
    }   
}
