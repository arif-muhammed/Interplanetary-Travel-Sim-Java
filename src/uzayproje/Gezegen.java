/**
 * @author [Arif Muhammed] - [arif_mohammad2@hotmail.com]
 * @since [20/04/2025]
 * <p>
 * Bu sınıf, gezegenin özelliklerini ve durumunu tutar.
 * Gezegenin adı, o gezegende bir günde kaç saat geçtiği ve gezegendeki tarih gibi bilgiler içerir.
 * Ayrıca, gezegen bilgileri formatlanarak yazdırılabilir.
 * </p>
 */

package uzayproje;

public class Gezegen {
    private String gezegenAdi; 
    private int gununKacSaatOldugu; 
    private String gezegendekiTarih; 

    public Gezegen(String gezegenAdi, int gununKacSaatOldugu, String gezegendekiTarih) {
        this.gezegenAdi = gezegenAdi;
        this.gununKacSaatOldugu = gununKacSaatOldugu;
        this.gezegendekiTarih = gezegendekiTarih;
    }

    public String getGezegenAdi() {
        return gezegenAdi;
    }

    public int getGununKacSaatOldugu() {
        return gununKacSaatOldugu;
    }

    public String getGezegendekiTarih() {
        return gezegendekiTarih;
    }

    @Override
    public String toString() {
        return gezegenAdi + "#" + gununKacSaatOldugu + "#" + gezegendekiTarih;
    }
}






