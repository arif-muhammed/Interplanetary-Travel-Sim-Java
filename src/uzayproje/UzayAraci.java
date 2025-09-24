/**
 * @author [Arif Muhammed] - [arif_mohammad2@hotmail.com]
 * @since [20/04/2025]
 * <p>
 * Bu sınıf, uzay aracının özelliklerini ve davranışlarını tanımlar.
 * Uzay aracının adı, çıkış gezegeni, varış gezegeni, mesafesi, durumu, hedef varış tarihi ve yolcuları gibi bilgileri içerir.
 * Ayrıca, uzay aracının mesafesinin nasıl güncelleneceğini ve hedef gezegenine ne zaman ulaşacağını simüle eder.
 * </p>
 */
package uzayproje;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UzayAraci {
    private String uzayAraciAdi;
    private String cikisGezegeni;
    private String varisGezegeni;
    private String cikisTarihi;
    private int mesafeSaatOlarak;
    private String durum;  
    private String hedefVaracagiTarih; 
    private List<Kisi> yolcular;  
    private Gezegen gezegen;     

    public UzayAraci(String uzayAraciAdi, String cikisGezegeni, String varisGezegeni, String cikisTarihi, int mesafeSaatOlarak, String durum, String hedefVaracagiTarih) {
        this.uzayAraciAdi = uzayAraciAdi;
        this.cikisGezegeni = cikisGezegeni;
        this.varisGezegeni = varisGezegeni;
        this.cikisTarihi = cikisTarihi;
        this.mesafeSaatOlarak = mesafeSaatOlarak;
        this.durum = durum;
        this.hedefVaracagiTarih = hedefVaracagiTarih;
        this.yolcular = new ArrayList<>();  
    }

    public String getUzayAraciAdi() {
        return uzayAraciAdi;
    }

    public String getCikisGezegeni() {
        return cikisGezegeni;
    }

    public String getVarisGezegeni() {
        return varisGezegeni;
    }

    public int getMesafeSaatOlarak() {
        return mesafeSaatOlarak;
    }

    public String getDurum() {
        return durum;
    }

    public String getHedefVaracagiTarih() {
        return hedefVaracagiTarih;
    }

    public void setGezegen(Gezegen gezegen) {
        this.gezegen = gezegen;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public void setMesafeSaatOlarak(int mesafeSaatOlarak) {
        this.mesafeSaatOlarak = mesafeSaatOlarak;
    }

    // Method to add passengers (ركاب)
    public void yolcuEkle(Kisi kisi) {
        yolcular.add(kisi);  
    }

    public String calculateArrivalDate() {
        if (gezegen == null) {
            return "--";  
        }

        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime arrivalDateTime = currentDateTime.plusHours(mesafeSaatOlarak);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return arrivalDateTime.format(formatter);
    }

    @Override
    public String toString() {
        return uzayAraciAdi + "#" + cikisGezegeni + "#" + varisGezegeni + "#" + cikisTarihi + "#" + mesafeSaatOlarak;
    }
}



