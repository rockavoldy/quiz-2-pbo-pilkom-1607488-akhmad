import java.util.ArrayList;
import java.util.Scanner;

public class Adegan {

    //static, satu objek player yang sama untuk semua objek adegan
    public static Player oPlayer;

    //pilihan yang ada di semua adegan
    PilihanGunakanKantong oPilihanGunakanKantong;  //lihat barang milik player dan gunakan
    PilihanLihatBarang oPilihanLihatBarang;        //lihat barang di dalam adegan dan pindahkan ke kantong player

    //barang yg valid digunakan dalam adegan ini (misal kunci dalam adegan pintu)
//    String idBarangBisaDigunakan;
    ArrayList<String> idBarangBisaDigunakan = new ArrayList<String>(); // diubah jadi array agar bisa menampung lebih banyak barang

    String narasi;
    //idealnya menggunakan ArrayList
    //pilihan yang bisa dipilih user untuk setiap adegan
    int jumPil = 0;
    ArrayList<Pilihan> arrPilihan = new ArrayList<>(); // diubah menjadi arraylist
//    Pilihan[] arrPilihan = new Pilihan[10];


    //constructor
    public Adegan() {
        //setiap adegan memiliki 2 pilihan yg sama yaitu untuk melihat barang milik player dan melihat barang dalam adegan tsb.
        oPilihanGunakanKantong = new PilihanGunakanKantong(this,"Lihat dan gunakan barang yang dimiliki player");
        tambahPilihan(oPilihanGunakanKantong);

        oPilihanLihatBarang = new PilihanLihatBarang(this,"Lihat barang di sekitar...");
        tambahPilihan(oPilihanLihatBarang);
    }

    //tambah barang yg berada di adegan
    public void tambahBarang(Barang vBarang) {
        oPilihanLihatBarang.tambahBarang(vBarang);
    }


    /*
       tambah pilihan
     */
    public void tambahPilihan(Pilihan oPilihan) {
        arrPilihan.add(oPilihan); // diubah menjadi menggunakan arraylist fungsi add untuk menambah Pilihan
        jumPil++;
    }


    public void mainkan() {
        //print narasi dan pilihan
        System.out.println(""); //spasi
        System.out.println(narasi);

        //print pilihan
        for (int i = 0; i < jumPil; i++) {
            System.out.print(String.format("%d. %s \n", i + 1,arrPilihan.get(i).deskripsi)); // diubah menjadi menggunakan fungsi get dari arraylist
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Pilihan anda:");
        int pilihan = sc.nextInt();
        System.out.println(""); //spasi

        //eksekusi pilihan yang dipilih user
        arrPilihan.get(pilihan-1).aksi(); // diubah menjadi menggunakan fungsi get dari arraylist
    }

    //User memilih barang yang dimiliki player. lihat class PilihanGunakanKantong
    public void gunakanBarang(Barang barangPilih) {
          System.out.println(String.format("Rudi mengambil %s dan menggunakannya...",barangPilih.deskripsi));
    }
}
