/*
    inisialisasi adegan dsb, jalankan adegan sampai permainan selesai.

 */

public class GameEngine {
    Player oPlayer;

    public GameEngine() {
        Barang koin = new Barang("koin","uang koin", 1, 0); // tambah parameter jenis dan kesehatan
        oPlayer = new Player();
        oPlayer.tambahBarang(koin);  //dummy saja
        //perhatikan Adegan  disini adalah class, oPlayer adalah static atribut sehingga berlaku untuk semua objek
        //artinya semua objek adegan punya objek player yang sama
        Adegan.oPlayer = oPlayer;
    }

    public void mulai() {
        oPlayer.printIdentitas();
        do {
            System.out.println("Kesehatan: "+oPlayer.kesehatan); // untuk print kesehatan setiap kali adegan dipanggil
            oPlayer.adeganAktif.mainkan();
            oPlayer.kesehatan -= 5; // ketika adegan dipanggil, maka kesehatan berkurang 5
        } while (!oPlayer.isSelesai);
    }

    public static void main(String[] args) {

        Barang kunci = new Barang("kunci_besar","Kunci Besar", 1, 0); //tmbah parameter jenis dan kesehatan


        Adegan adeganPintu = new AdeganPintu();
        Adegan adeganMeja  = new Adegan();
        Adegan adeganJendela = new AdeganJendela(); //tambah adegan jendela

        Pilihan pilihanMenujuPintu = new PilihanGantiAdegan(adeganPintu,"Menuju pintu");
        Pilihan pilihanMenujuMeja  = new PilihanGantiAdegan(adeganMeja,"Menuju meja");
        Pilihan pilihanMenujuJendela  = new PilihanGantiAdegan(adeganJendela,"Menuju Jendela"); // pilihan adegan jendela

        //init data cerita
        // == adegan awal
        Adegan  adeganAwal = new Adegan();
        adeganAwal.narasi =
                "Rudi terbangun disebuah ruangan yang tidak dikenal. Dia melihat sekeliling, \n" +
                "terlihat jendela, pintu dan sebuah meja kecil";
        adeganAwal.tambahPilihan(pilihanMenujuPintu);
        adeganAwal.tambahPilihan(pilihanMenujuMeja);
        adeganAwal.tambahPilihan(pilihanMenujuJendela); // tambah adegan awal agar ada menuju jendela

        // == adegan di depan pintu
        adeganPintu.tambahPilihan(pilihanMenujuMeja); //pilihan ke meja direuse
        adeganPintu.tambahPilihan(pilihanMenujuJendela); //dari meja bisa ke jendela
//        adeganPintu.idBarangBisaDigunakan = "kunci_besar"; //kunci_besar bisa digunakan di adegan ini
//        adeganPintu.idBarangBisaDigunakan = "pisang";

        // ubah jadi arraylist
        adeganPintu.idBarangBisaDigunakan.add("kunci_besar"); //kunci_besar bisa digunakan di adegan ini
        adeganPintu.idBarangBisaDigunakan.add("pisang"); // pisang (item consumable) bisa digunakan di adegan ini

        // == adegan di depan meja
        adeganMeja.narasi = "Rudi mendekati meja. Ada beberapa barang di atas meja";
        adeganMeja.tambahBarang(new Barang("kunci_besar", "Kunci berukuran besar", 1, 0)); // tambah parameter jenis dan kesehatan
        adeganMeja.tambahBarang(new Barang("senter", "Senter kecil", 1, 0)); // tambah parameter jenis dan kesehatan
        adeganMeja.tambahBarang(new Barang("pisang", "Pisang", 2, 30)); // tambah parameter jenis kesehatan
        adeganMeja.tambahPilihan(pilihanMenujuPintu); //dari meja bisa ke pintu
        adeganMeja.tambahPilihan(pilihanMenujuJendela); //dari meja bisa ke jendela
        adeganMeja.idBarangBisaDigunakan.add("pisang"); // pisang (item consumable) bisa digunakan di adegan ini, menggunakan arraylist

        //adegan di depan jendela
        adeganJendela.narasi = "Rudi mendekati jendela. Ada beberapa barang di pinggir jendela";
        adeganJendela.tambahBarang(new Barang("obeng", "Obeng", 1, 0)); // tambah parameter jenis dan kesehatan
        adeganJendela.tambahPilihan(pilihanMenujuPintu); //dari jendela bisa ke pintu
        adeganJendela.tambahPilihan(pilihanMenujuMeja); //dari jendela bisa ke meja
        adeganJendela.idBarangBisaDigunakan.add("obeng"); // obeng bisa digunakan di adegan ini, menggunakan arraylist
        adeganJendela.idBarangBisaDigunakan.add("pisang"); // pisang (item consumable) bisa digunakan di adegan ini, menggunakan arraylist


        //== init game engine
        GameEngine ge = new GameEngine();
        //ge.tambahAdegan(adeganMeja);
        ge.oPlayer.adeganAktif = adeganAwal; //start dari adegan awal
        ge.mulai();
    }
}
