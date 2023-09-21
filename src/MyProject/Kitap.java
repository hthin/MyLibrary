package MyProject;

import java.util.HashMap;
import java.util.Map;

public class Kitap {
    static Map<Integer, Kitap> kitaplarMap = new HashMap<>();
    private String name;
    private String yazar;
    private String fiyat;

    public Kitap(String name, String yazar, String fiyat) {
        this.name = name;
        this.yazar = yazar;
        this.fiyat = fiyat;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return "Kitap{" +
                "name='" + name + '\'' +
                ", yazar='" + yazar + '\'' +
                ", fiyat=" + fiyat +
                '}';
    }
}
