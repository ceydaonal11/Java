package constructor1;

public class account {
    private String hesapNo;
    private String isim;
    private double bakiye;
    private String email;
    private String telefon;
    
    public account(){
        System.out.println("Deneme account");
    }

    public account (String hesapNo, String isim, double bakiye, String email, String telefon){
        this.hesapNo = hesapNo;
        this.isim = isim;
        this.bakiye = bakiye;
        this.email = email;
        this.telefon = telefon;
        
    }
    
    
    public void paraCekme(double miktar){
        if(miktar > 1500){
            System.out.println("1500 tl den fazla para çekemezsiniz.");
        }if(bakiye - miktar <0){
            System.out.println("Yetersiz bakiye.. Bakiyeniz: " + bakiye);
        }else
            bakiye-=miktar;
            System.out.println("Yeni bakiye: " + bakiye);
            
    }
    
    public void paraYatirma(double miktar){
        bakiye+=miktar;
        System.out.println("Yeni bakiyeniz: " + bakiye);
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
