/**
 * @author [Arif Muhammed] - [arif_mohammad2@hotmail.com]
 * @since [20/04/2025]
 * <p>
 * Bu sınıf, gezegenler arası yolculuğu simüle eder. 
 * Zamanın ilerlemesiyle birlikte uzay araçlarının hedeflerine ulaşma süreci yönetilir.
 * Gezegenler ve uzay araçları arasındaki etkileşimler simüle edilir.
 * </p>
 */

package uzayproje;

import java.util.*;

public class Simulasyon {
    private List<Gezegen> gezegenler;
    private List<UzayAraci> uzayAraclari;
    private int saat;

    public Simulasyon(List<Gezegen> gezegenler, List<UzayAraci> uzayAraclari) {
        this.gezegenler = gezegenler;
        this.uzayAraclari = uzayAraclari;
        this.saat = 0;
    }

    public void saatGuncelle() {
        this.saat++;
    }

    private void printGezegenler() {
        System.out.println("Gezegenler:");
        System.out.printf("%-15s", "");
        for (Gezegen gezegen : gezegenler) {
            System.out.printf("--- %-9s", gezegen.getGezegenAdi());
        }
        System.out.println();

        System.out.printf("%-15s", "Tarih");
        for (Gezegen gezegen : gezegenler) {
            System.out.printf("%-13s", gezegen.getGezegendekiTarih());
        }
        System.out.println();

        System.out.printf("%-15s", "Nüfus");
        for (Gezegen gezegen : gezegenler) {
            System.out.printf("%-13d", gezegen.getGununKacSaatOldugu());
        }
        System.out.println();
    }

    public void simuleEt() {
        Map<String, Gezegen> planetMap = new HashMap<>();
        for (Gezegen g : gezegenler) planetMap.put(g.getGezegenAdi(), g);
        for (UzayAraci a : uzayAraclari) {
            a.setGezegen(planetMap.get(a.getCikisGezegeni()));
        }

        Map<UzayAraci, Integer> ilkSaatMap = new HashMap<>();
        for (UzayAraci arac : uzayAraclari) {
            ilkSaatMap.put(arac, arac.getMesafeSaatOlarak());
        }

        printGezegenler();
        System.out.println();

        boolean allArrived = false;

        while (!allArrived) {
        	clearConsole();
        	printGezegenler();
            System.out.println("Uzay Araclari:");
            System.out.printf("%-10s %-10s %-10s %-10s %-20s %-20s\n", "Araç Adı", "Durum", "Çıkış", "Varış", "Hedefe Kalan Saat", "Hedefe Varacağı Tarih");

            allArrived = true;

            for (UzayAraci arac : uzayAraclari) {
                if (arac.getMesafeSaatOlarak() > 0) {
                    arac.setDurum("Yolda");
                    arac.setMesafeSaatOlarak(arac.getMesafeSaatOlarak() - 1);
                } else {
                    arac.setDurum("Vardı");
                }

                String kalanSaat = arac.getDurum().equals("IMHA") ? "--" : String.valueOf(arac.getMesafeSaatOlarak());
                String hedefTarih = arac.getDurum().equals("IMHA") ? "--" : arac.calculateArrivalDate();

                System.out.printf("%-10s %-10s %-10s %-10s %-20s %-20s\n",
                        arac.getUzayAraciAdi(), arac.getDurum(), arac.getCikisGezegeni(),
                        arac.getVarisGezegeni(), kalanSaat, hedefTarih);

                if (arac.getDurum().equals("Yolda") || arac.getDurum().equals("Bekliyor")) {
                    allArrived = false;
                }
            }

            
            
            
            saatGuncelle();
            System.out.println();
        }
    }
    
    
    
    public static void clearConsole() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


