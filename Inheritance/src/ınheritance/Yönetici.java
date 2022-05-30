package ınheritance;
// Subclass (yani bir alt class)
public class Yönetici extends Calisan { //extends 'çalışan' classının özelliklerini ve methodlarını miras almamızı sağlar.

    private int sorumluKisi; // extra özellik
    
    public Yönetici(String isim, int maas, String departman, int sorumluKisi) {
       
        super(isim,maas,departman);
        this.sorumluKisi = sorumluKisi;
    }
    
    public void zamYap(int zamMiktarı){
        System.out.println("Çalışanlara " + zamMiktarı + "tl zam yapıldı");
    }
    
    public void bilgileriGoster(){
        super.bilgileriGoster();
        
        System.out.println("Sorumlu kişi sayısı: " + this.sorumluKisi);
    }
}
