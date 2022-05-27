package oopgiris;

public class Araba {

private String renk;
private String model;
private int kapılar;
private int tekerlekler;

    /**
     * @return the renk
     */
    public String getRenk() {
        return renk;
    }

    /**
     * @param renk the renk to set
     */
    public void setRenk(String renk) {
        this.renk = renk;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the kapı
     */
    public int getKapılar() {
        return kapılar;
    }

    /**
     * @param kapı the kapı to set
     */
    public void setKapılar(int kapı) {
        if(kapı<0){
            System.out.println("Kapı sayısı 0'dan küçük olamaz");
        }else
            this.kapılar = kapılar;
    }

    /**
     * @return the tekerlekler
     */
    public int getTekerlekler() {
        return tekerlekler;
    }

    /**
     * @param tekerlekler the tekerlekler to set
     */
    public void setTekerlekler(int tekerlekler) {
        this.tekerlekler = tekerlekler;
    }
}
