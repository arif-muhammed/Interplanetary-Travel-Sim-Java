/**
 * @author [Arif Muhammed] - [arif_mohammad2@hotmail.com]
 * @since [20/04/2025]
 * <p>
 * Bu sınıf, uzay aracındaki yolcuların özelliklerini temsil eder.
 * Yolcuların isimleri, yaşları, kalan ömürleri ve hangi uzay aracında bulundukları gibi bilgileri içerir.
 * </p>
 */


package uzayproje;

public class Kisi {
    private String isim; 
    private int yas; 
    private int kalanOmur; 
    private String uzayAraciAdi;   

    public Kisi(String isim, int yas, int kalanOmur, String uzayAraciAdi) {
        this.isim = isim;
        this.yas = yas;
        this.kalanOmur = kalanOmur;
        this.uzayAraciAdi = uzayAraciAdi;        
    }

    public String getUzayAraciAdi() {
        return uzayAraciAdi; 
    }

    public void guncelleOmur() {
        if (kalanOmur > 0) {
            kalanOmur--;
        }
    }

    @Override
    public String toString() {
        return isim + "#" + yas + "#" + kalanOmur + "#" + uzayAraciAdi;
    }
}


