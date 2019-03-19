/*
    pilihan untuk menampilkan barang yang dimiliki player (isi kantong) dan menggunakannya
 */

public class PilihanGunakanKantong extends Pilihan {

    //adegan tempat pilihan ini berada
    public Adegan oAdegan;


    public PilihanGunakanKantong(Adegan vAdegan, String narasi) {
        super(narasi);
        oAdegan = vAdegan;
    }

    @Override
    public void aksi() {
        //tampilkan dialog untuk memilih barang
        Barang barangPilih = oAdegan.oPlayer.pilihBarang();
        if (barangPilih!=null) {
            //ada barang dipilih, gunakan barang tersebut
            //cek apakah barang bisa digunakan
//            if (oAdegan.idBarangBisaDigunakan == barangPilih.id)   {
//                //bisa digunakan
//                oAdegan.gunakanBarang(barangPilih);
//                if(barangPilih.jenis == 2){
//                    oAdegan.oPlayer.kesehatan += barangPilih.kesehatan;
//                }
//            } else {
//                System.out.println(String.format("Barang  %s  tidak bisa digunakan!",barangPilih.deskripsi));
//            }

            for(int i = 0;i<oAdegan.idBarangBisaDigunakan.size();i++){ //perulangan untuk mengecek idBarang yang bisa digunakan
                if (oAdegan.idBarangBisaDigunakan.get(i).equals(barangPilih.id))   { // idBarang di cek dengan barang yang dipilih
                    //bisa digunakan
                    oAdegan.gunakanBarang(barangPilih);
                    if(barangPilih.jenis == 2){ // jika barang jenis 2(useable) maka barang menambah kesehatan
                        oAdegan.oPlayer.kesehatan += barangPilih.kesehatan; // tambah ksehatan ke barang
                        oAdegan.idBarangBisaDigunakan.remove(i); // hapus makanan karena telah dimakan
                    }
                    break; // agar tidak terus melakukan pengulangan karena kodnisi telah tepenuhi
                }
                else { // jika barang tidak sama dengan pilih barang
                    System.out.println(String.format("Barang  %s  tidak bisa digunakan!",barangPilih.deskripsi));
                }
            }
        }
    }
}
