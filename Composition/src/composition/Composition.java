
package composition;

public class Composition {

    public static void main(String[] args) {
        // HAS A 
        Resolution resolution = new Resolution(1920, 1080);
        Monitör monitör = new Monitör("VS197DE", "ASUS", "18.5", resolution);
        
        Kasa kasa = new Kasa("Shadow Blade", "Shadow", "Temperli Cam");
        
        Anakart anakart = new Anakart("B250-PRO","Asus",10,"Windows 10");
        
        Bilgisayar pc = new Bilgisayar(monitör, kasa, anakart);
        
        pc.getKasa().bilgisayarıAc();
        pc.getMonitör().monitörüKapat();
        pc.getAnakart().isletimSistemiYükle("Ubuntu 16.04");

    }
    
}
