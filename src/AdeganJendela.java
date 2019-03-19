/*
    Adegan dipintu, ada state terkunci
 */

public class AdeganJendela extends  Adegan {
    boolean isTerkunci = true;
    String narasiTerkunci = "Rudi mendekati jendela. Rudi mencoba membuka Jendela. \"Ah terkunci tapi sepertinya bisa dicungkil.\"";
    String narasiTerbuka  = "Rudi mencoba membuka jendela dengan obeng dan terbuka!";

    //constructor
    public AdeganJendela () {
        narasi = narasiTerkunci;
    }

    /* user berhasil menggunakan kunci untuk membuka pintu */
    @Override
    public void gunakanBarang(Barang barangPilih) {
        super.gunakanBarang(barangPilih); //panggil parent
        if(barangPilih.id.equals("obeng")){ //cek barang yang dipilih adalah obeng
            isTerkunci = false;
            narasi = narasiTerbuka;
            //karena kunci sudah terbuka ada pilihan baru keluar dari kamar
            Adegan  adeganKoridor = new AdeganKoridor(); // tambah adegan koridor
            adeganKoridor.narasi = "Rudi pelan-pelan mencungkil jendela dan keluar dari kamar. Rudi sekarang berada di koridor " +
                    "yang sangat panjang";
            Pilihan pilihanMenujuKoridor = new PilihanGantiAdegan(adeganKoridor,"Keluar kamar, ke koridor"); //tambah adegan koridor
            tambahPilihan(pilihanMenujuKoridor);
        }
    }

}
