/**
 * @author [Arif Muhammed] - [arif_mohammad2@hotmail.com]
 * @since [20/04/2025]
 * <p>
 * Bu sınıf, gezegenler, kişiler ve uzay araçları gibi verileri dosyalardan okur.
 * Dosyalarda bulunan verileri işler ve uygun sınıf türlerine dönüştürür.
 * </p>
 */
package uzayproje;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DosyaOkuma {

    public static List<Gezegen> gezegenlerOku(String dosyaAdi) {
        System.out.println("Dosya okunuyor: " + dosyaAdi);       
        List<Gezegen> gezegenler = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("#");
                
                if (parts.length >= 3) {
                    String gezegenAdi = parts[0];
                    int gununKacSaatOldugu = Integer.parseInt(parts[1]);
                    String gezegendekiTarih = parts[2];
                    gezegenler.add(new Gezegen(gezegenAdi, gununKacSaatOldugu, gezegendekiTarih));
                } else {
                    System.out.println("Hatalı veri satırı: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gezegenler;
    }

    public static List<Kisi> kisilerOku(String dosyaAdi) {
        System.out.println("Dosya okunuyor: " + dosyaAdi);  
        List<Kisi> kisiler = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("#");
                
                if (parts.length >= 4) {
                    String isim = parts[0];
                    int yas = Integer.parseInt(parts[1]);
                    int kalanOmur = Integer.parseInt(parts[2]);
                    String uzayAraciAdi = parts[3];
                    kisiler.add(new Kisi(isim, yas, kalanOmur, uzayAraciAdi));
                } else {
                    System.out.println("Hatalı veri satırı: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return kisiler;
    }

    public static List<UzayAraci> araclarOku(String dosyaAdi) {
        System.out.println("Dosya okunuyor: " + dosyaAdi);  
        List<UzayAraci> araclar = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("#");
                
                if (parts.length >= 5) {
                    String uzayAraciAdi = parts[0];
                    String cikisGezegeni = parts[1];
                    String varisGezegeni = parts[2];
                    String cikisTarihi = parts[3];
                    int mesafeSaatOlarak = Integer.parseInt(parts[4]);

                    araclar.add(new UzayAraci(uzayAraciAdi, cikisGezegeni, varisGezegeni, cikisTarihi, mesafeSaatOlarak, "yolda", "Hedef Tarih Belirtilmemiş"));
                } else {
                    System.out.println("Hatalı veri satırı: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return araclar;
    }
}








