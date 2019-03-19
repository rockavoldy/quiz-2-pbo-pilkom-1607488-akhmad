/*
    Adegan di koridor, untuk bisa ditambah dengan adegan pilihan lain
 */

public class AdeganKoridor extends  Adegan {
    boolean isTerkunci = false;
    String narasiTerbuka  = "Rudi melihat cahaya di ujung koridor.";

    //constructor
    public AdeganKoridor () {
        narasi = narasiTerbuka;
        new AdeganKeluarKoridor(); // panggil adegan keluar koridor langsung setelah adegankoridor dipanggil
    }

}
