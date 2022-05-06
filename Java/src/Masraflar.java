
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ceyda
 */
public class Masraflar {
    
    String id;
    String date;
    String category;
    String price;

    public Masraflar(String id, String date, String category, String price) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }
    
    public Date getSimpleDateFormat() {
        try {
            return new SimpleDateFormat("d.M.yyyy").parse(getDate());
        } catch (ParseException ex) {
            Logger.getLogger(Masraflar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String getDay() {
        String nameofday = "";
        switch (getSimpleDateFormat().toString().split(" ")[0]) {
            case "Thu":
                nameofday = "Perşembe";
                break;
            case "Tue":
                nameofday = "Salı";
                break;
            case "Sat":
                nameofday = "Cumartesi";
                break;    
            case "Wed":
                nameofday = "Çarşamba";
                break;
            case "Fri":
                nameofday = "Cuma";
                break;
            case "Sun":
                nameofday = "Pazar";
                break;
            case "Mon":
                nameofday = "Pazartesi";
                break;            
        }        
        return nameofday;
    }
    
    public String getMonth() {
        String nameofmonth = "";
        switch (getSimpleDateFormat().toString().split(" ")[1]) {
            case "Jan":
                nameofmonth = "Ocak";
                break;
            case "Feb":
                nameofmonth = "Şubat";
                break;
            case "Mar":
                nameofmonth = "Mart";
                break;    
            case "Apr":
                nameofmonth = "Nisan";
                break;
            case "May":
                nameofmonth = "Mayıs";
                break;
            case "Jun":
                nameofmonth = "Haziran";
                break;
            case "Jul":
                nameofmonth = "Temmuz";
                break;            
            case "Aug":
                nameofmonth = "Ağustos";
                break;    
            case "Sep":
                nameofmonth = "Eylül";
                break;
            case "Oct":
                nameofmonth = "Ekim";
                break;
            case "Nov":
                nameofmonth = "Kasım";
                break;
            case "Dec":
                nameofmonth = "Aralık";
                break;            
        }        
        return nameofmonth;
    }
    
    public boolean isWeekend() {
        if (getDay().equals("Cumartesi") || getDay().equals("Pazar")) {
            return true;
        } else {
            return false;
        }
    }
    
}
