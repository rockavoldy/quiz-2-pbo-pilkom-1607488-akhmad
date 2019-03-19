/*
    Adegan Keluar Koridor, pergi bebas, lepas, hilangkan saja beban dihatiku, melayang ku melayang jauh
 */

public class AdeganKeluarKoridor extends  Adegan {
    String narasi;
    public AdeganKeluarKoridor(){ // constructor
        System.out.println("Rudi mengikuti cahaya di ujung koridor, Rudi bebas!");
        oPlayer.isSelesai = true; // game over!
    }
}