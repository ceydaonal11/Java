package constructor2;

public class account {
    private String hesapNo;
    private String isim;
    private double bakiye;
    private String email;
    private String telefon;
    
    public account(){
       /* this.hesapNo = "Bilgi Yok";
        this.isim = "Bilgi Yok";
        this.bakiye = 0.0;
        this.email = "Bilgi Yok";
        this.telefon = "Bilgi Yok"; */
        
        this("Bilgi Yok", "Bilgi Yok", 0.0, "Bilgi Yok", "Bilgi Yok" ); // Burada aşağıdaki account da yer alan ifadeleri çağırmış olduk.
                
    }
    
    public account(String hesapNo, String isim, double bakiye, String email, String telefon){
        this.hesapNo = hesapNo;
        this.isim = isim;
        this.bakiye = bakiye;
        this.email = email;
        this.telefon = telefon;
    }
    //overloading yaptık.
    public account(String isim, String email, String telefon){
        /*this.isim = isim;
        this.email = email;
        this.telefon = telefon;
        
        this.hesapNo = hesapNo;
        this.bakiye = bakiye; */
        
        this("Bilgi Yok",isim ,0.0, email, telefon);
    }
    
    public void bilgileriGoster(){
        System.out.println("Hesap No: " + this.hesapNo);
        System.out.println("İsim: " + this.isim);
        System.out.println("Bakiye" + this.bakiye);
        System.out.println("E-mail: " + this.email);
        System.out.println("Telefon: " + this.telefon);
    }
    
    public void paraCekme(double miktar){
        if(miktar > 1500 ){
            System.out.println("1500 tl'den fazla para çekemezsiniz.");
        }if(bakiye-miktar <0){
            System.out.println("Yetersiz bakiye. Bakiyeniz: " + bakiye);
        }else
            bakiye-=miktar;
            System.out.println("Kalan bakiye: " + bakiye);
    }
    
    public void paraYatırma(double miktar){
        bakiye+=miktar;
        System.out.println("Yeni bakiye: " + bakiye);
    }

    /**
     * @return the hesapNo
     */
    public String getHesapNo() {
        return hesapNo;
    }

    /**
     * @param hesapNo the hesapNo to set
     */
    public void setHesapNo(String hesapNo) {
        this.hesapNo = hesapNo;
    }

    /**
     * @return the isim
     */
    public String getIsim() {
        return isim;
    }

    /**
     * @param isim the isim to set
     */
    public void setIsim(String isim) {
        this.isim = isim;
    }

    /**
     * @return the bakiye
     */
    public double getBakiye() {
        return bakiye;
    }

    /**
     * @param bakiye the bakiye to set
     */
    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * @param telefon the telefon to set
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    
}
