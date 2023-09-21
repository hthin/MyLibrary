package MyProject;


import java.util.Map;
import java.util.Scanner;

public class Islemler {
    static String c_RESET  = "\u001B[0m";
    static String BOLD     = "\033[0;1m";
    static String c_BLUE   = "\u001B[34m";
    static String c_RED    = "\u001B[31m";
    static String c_GREEN  = "\u001B[32m";
    static String c_CYAN   = "\u001B[36m";
   static String c_PURPLE = "\u001B[35m";
   static Scanner scan = new Scanner(System.in);



    static int kitapNo = 999;

    public static void bookAdding () throws InterruptedException {
        kitapNo++;
        System.out.print("\nEklemek istediğiniz kitabın adını giriniz : ");
        String kitabAdi = TryCatch.stringGirisi();

        System.out.print("Eklemek istediğiniz kitabın yazarını giriniz : ");
        String yazarAdi = TryCatch.stringGirisi();

        System.out.print("Eklemek istediğiniz kitabın fiyatını giriniz : ");
        String fiyat = TryCatch.stringGirisi();

        Kitap obje = new Kitap(kitabAdi,yazarAdi,fiyat);
        Kitap.kitaplarMap.put(kitapNo,obje);
        System.out.println(BOLD+c_CYAN+"\nKitap kaydı başarıyla yapıldı."+c_RESET);

        Menuler.anaMenu();

    }
    public static void bookSearching () throws InterruptedException {
        System.out.println("\nKitap no ile görüntülemek için 1'e ");
        System.out.println("Kitap adı ile görüntülemek için 2'e ");
        System.out.print("Seçiniz : ");

        String secim = TryCatch.stringGirisi();

        if (secim.equals("1")) {
            System.out.print("\nGörüntülemek istediğiniz kitap numasarını giriniz : ");
            int no = TryCatch.intGirisi();
            if (Kitap.kitaplarMap.containsKey(no)) {
                System.out.printf(BOLD+c_BLUE+"%20s%20s%20s%20s","Kitap No","Kitap Adı","Yazar","Fiyat"+c_RESET);
                System.out.println();
                System.out.printf("%20s%20s%20s%16s\n",no, Kitap.kitaplarMap.get(no).getName(),
                        Kitap.kitaplarMap.get(no).getYazar(),Kitap.kitaplarMap.get(no).getFiyat());
                Menuler.anaMenu();
            }
            else {
                System.out.println(BOLD+c_RED+"\nBöyle bir kitap kaydı bulunmamaktadır. "+c_RESET);
                Menuler.anaMenu();
            }
        }
        else if (secim.equals("2")) {
            System.out.print("\nGörüntülemek istediğiniz kitap adını giriniz : ");
            String isim = TryCatch.stringGirisi();

            int count = 0;
            for (Map.Entry<Integer,Kitap> val : Kitap.kitaplarMap.entrySet()) {
                if (val.getValue().getName().equalsIgnoreCase(isim)) {
                    System.out.println();
                    System.out.printf(BOLD+c_BLUE+"%20s%20s%20s%20s","Kitap No","Kitap Adı","Yazar","Fiyat\n"+c_RESET);
                    System.out.printf("%20s%20s%20s%16s",val.getKey(),val.getValue().getName(),
                            val.getValue().getYazar(),val.getValue().getFiyat());
                    System.out.println("\n");
                    break;
                }
                else {
                    count++;
                }


            }
            if (count == Kitap.kitaplarMap.size())System.out.println(BOLD+c_RED+"\nBöyle bir kitap kaydı bulunmamaktadır. "+c_RESET);

            Menuler.anaMenu();

        }
        else {
            System.out.println("\nHatalı giriş yaptınız. Tekrar Deneyin. ");
            bookSearching();
        }

    }
    public static void bookDeleting () throws InterruptedException {
        System.out.print("\nSilmek istediğiniz kitap numasarını giriniz : ");
        int no = TryCatch.intGirisi();
        if (Kitap.kitaplarMap.containsKey(no)) {

            System.out.println(BOLD+c_CYAN+"\n"+Kitap.kitaplarMap.get(no).getName()+" kitabı silindi."+c_RESET);
            Kitap.kitaplarMap.remove(no);
            Menuler.anaMenu();
        }
        else {
            System.out.println(BOLD+c_RED+"\nBöyle bir kitap kaydı bulunmamaktadır. "+c_RESET);
            Menuler.anaMenu();
        }
    }
    public static void allBookListing () throws InterruptedException {
        System.out.println();
        if (Kitap.kitaplarMap.size() != 0) {
            System.out.printf(BOLD+c_BLUE+"%20s%20s%20s%20s","Kitap No","Kitap Adı","Yazar","Fiyat"+c_RESET);
            System.out.println();

            for(Map.Entry<Integer,Kitap> val : Kitap.kitaplarMap.entrySet()) {
                int key = val.getKey();
                String name = val.getValue().getName();
                String yazar = val.getValue().getYazar();
                String fiyat = val.getValue().getFiyat();
                System.out.printf(c_PURPLE+"%20d%20s%20s%20s",key,name,yazar,fiyat+c_RESET);
                System.out.println();
            }
        }
        else System.out.println(BOLD+c_RED+"\nGörüntülenecek kayıt bulunmamaktadır. "+c_RESET);


        Menuler.anaMenu();




    }


    public static void cikis() {
        System.out.println(BOLD+c_GREEN+"\nÇıkış Yapıyorsunuz. Iyi günler dileriz.."+c_RESET);
    }
}
