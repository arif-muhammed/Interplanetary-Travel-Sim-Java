/**
 * @author [Arif Muhammed] - [arif_mohammad2@hotmail.com]
 * @since [20/04/2025]
 * <p>
 * Bu sınıf, programın ana giriş noktasıdır.
 * Dosyalardan gezegenler, kişiler ve uzay araçları verilerini okur ve simülasyonu başlatır.
 * </p>
 */
package uzayproje;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program başladı!");

        List<Gezegen> gezegenler = DosyaOkuma.gezegenlerOku("Gezegenler.txt");
        List<Kisi> kisiler = DosyaOkuma.kisilerOku("Kisiler.txt");
        List<UzayAraci> araclar = DosyaOkuma.araclarOku("Araclar.txt");

        for (Kisi kisi : kisiler) {
            for (UzayAraci arac : araclar) {
                if (arac.getUzayAraciAdi().equals(kisi.getUzayAraciAdi())) {
                    arac.yolcuEkle(kisi); 
                }
            }
        }

        Simulasyon simulasyon = new Simulasyon(gezegenler, araclar);
        simulasyon.simuleEt();
    }
}
