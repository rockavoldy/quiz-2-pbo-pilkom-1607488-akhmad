public class Barang {
    String id;           //untuk keperluan mencocokan, misal kunci cocok dengan pintu
    String deskripsi;
    int jenis;
    int kesehatan;

    // constructor
    public Barang(String id, String deskripsi, int jenis, int kesehatan) {
        //tambah jenis untuk membedakan barang yang bisa dipakai, atau consumable sekali pakai
        // jenis barang 1 = yang bisa dipakai berkali kali
        // jenis barang 2 = consumable yang hany bisa dipakai sekali
        this.id = id;
        this.deskripsi = deskripsi;
        this.jenis = jenis; // untuk menentukan jenis barang
        this.kesehatan = kesehatan; // jika barang makanan, maka kesehatan tergantung dari makanan itu sendiri, bisa bertambah atau berkurang jika itu racun
    }


}
