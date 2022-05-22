package carpimtablosuolusturma;

/**
 *
 * @author ceyda
 */
public class CarpimTablosuOlusturma {

    public static void main(String[] args) {
        // İç içe for döngüsü kullanarak çarpım tablosu oluşturma.
/*   int altcizgi, i, j; 
     System.out.println(" 1 2 3 4 5 6 7 8 9 10 ");  
     for(altcizgi=1; altcizgi<=40; altcizgi++) //döngüyle uzunca bir çizgi çizelim
      { 
        System.out.print("_"); 
       } 
     System.out.println(); 
     for (i =1; i<=10; i++) 
      { 
        System.out.print(i+" | "); 
        for (j=1 ; j<=10 ; j ++) 
         { 
           System.out.print(i*j +" "); 
          } 
        System.out.println(); 
       } */


       for (int i = 1 ; i <= 10 ; i++) {
          System.out.println("***********************************");
          for (int j = 1 ; j <= 10 ; j++) {
              
              System.out.println( i  + " x " + j + " = " + (i * j));
              
          }
          System.out.println("***********************************");
          
      }
    
    }
}

