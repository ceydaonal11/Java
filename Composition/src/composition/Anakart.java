package composition;

public class Anakart {

private String model;
private String üretici;
private int yuvaSayisi;
private String isletimSistemi;

public void isletimSistemiYükle(String isletimSistemi){
    this.isletimSistemi = isletimSistemi; // Burayı kontrol et
    System.out.println("İşletim Sistemi Yülendi: " + isletimSistemi);
}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getÜretici() {
        return üretici;
    }

    public void setÜretici(String üretici) {
        this.üretici = üretici;
    }

    public int getYuvaSayisi() {
        return yuvaSayisi;
    }

    public void setYuvaSayisi(int yuvaSayisi) {
        this.yuvaSayisi = yuvaSayisi;
    }

    public String getIsletimSistemi() {
        return isletimSistemi;
    }

    public void setIsletimSistemi(String isletimSistemi) {
        this.isletimSistemi = isletimSistemi;
    }

    public Anakart(String model, String üretici, int yuvaSayisi, String isletimSistemi) {
        this.model = model;
        this.üretici = üretici;
        this.yuvaSayisi = yuvaSayisi;
        this.isletimSistemi = isletimSistemi;
    }
    
}
