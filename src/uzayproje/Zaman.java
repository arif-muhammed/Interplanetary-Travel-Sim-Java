/**
 * @author [Arif Muhammed] - [arif_mohammad2@hotmail.com]
 * @since [20/04/2025]
 * <p>
 * Bu sınıf, zaman bilgisini tutar ve gezegenler arası zaman simülasyonunu yönetir.
 * Zaman, saat, gün, ay, yıl gibi bilgileri içerir ve bu bilgilerin güncellenmesini sağlar.
 * Ayrıca, zamanın "gün.ay.yıl saat:00" formatında formatlanmasını sağlar.
 * </p>
 */
package uzayproje;
public class Zaman {
    private int saat;  
    private int gun;    
    private int ay;    
    private int yil;   
    private int saatlerPerGun; 

    public Zaman(int saat, int gun, int ay, int yil, int saatlerPerGun) {
        this.saat = saat;
        this.gun = gun;
        this.ay = ay;
        this.yil = yil;
        this.saatlerPerGun = saatlerPerGun;
    }

    public int getSaat() {
        return saat;
    }

    public void setSaat(int saat) {
        this.saat = saat;
    }

    public int getGun() {
        return gun;
    }

    public void setGun(int gun) {
        this.gun = gun;
    }

    public int getAy() {
        return ay;
    }

    public void setAy(int ay) {
        this.ay = ay;
    }

    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }

    public int getSaatlerPerGun() {
        return saatlerPerGun;
    }

    public void setSaatlerPerGun(int saatlerPerGun) {
        this.saatlerPerGun = saatlerPerGun;
    }

    public void saatGuncelle() {
        this.saat++;
        if (this.saat >= saatlerPerGun) {
            this.saat = 0;
            this.gun++;
            if (this.gun > 30) { 
                this.gun = 1;
                this.ay++;
                if (this.ay > 12) { 
                    this.ay = 1;
                    this.yil++;
                }
            }
        }
    }

    public String getFormattedTime() {
        return gun + "." + ay + "." + yil + " " + saat + ":" + "00";
    }

    @Override
    public String toString() {
        return getFormattedTime();
    }
}

