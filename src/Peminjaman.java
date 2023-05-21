import java.util.Scanner;
import java.util.ArrayList;

public class Peminjaman {

    private ArrayList<Integer> idBuku = new ArrayList<Integer>();
    private ArrayList<Integer> idSiswa = new ArrayList<Integer>();
    private ArrayList<Integer> banyak = new ArrayList<Integer>();

    public Peminjaman() {
        this.idSiswa.add(0);
        this.idBuku.add(0);
        this.banyak.add(2);

        this.idSiswa.add(0);
        this.idBuku.add(1);
        this.banyak.add(3);

        this.idSiswa.add(1);
        this.idBuku.add(0);
        this.banyak.add(1);

        this.idSiswa.add(1);
        this.idBuku.add(2);
        this.banyak.add(2);
    }

    public void prosesPeminjaman(Siswa siswa, Peminjaman peminjaman, Buku buku) {
        Scanner myOBJ = new Scanner(System.in);
        String cek = "";
        
        System.out.println("Silahkan Meminjam Buku");
        System.out.print("Masukkan ID Member : ");
        int idSiswa = myOBJ.nextInt();
        if (idSiswa >= siswa.getJumlahSiswa() && idSiswa >= 0) {
            System.out.println("ID tidak ditemukan");
        }
        else if (siswa.isStatus(idSiswa) == false) {
            System.out.println("Halo " + siswa.getNama(idSiswa) + "!");
            System.out.println("Status anda sudah meminjam buku, silakan untuk mengembalikan terlebih dahulu");
        
        } else {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Halo " + siswa.getNama(idSiswa) + "!");
            System.out.println("Selamat datang di Perpustakaan!");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

            ArrayList<Integer> idBuku = new ArrayList<Integer>();
            ArrayList<Integer> banyak = new ArrayList<Integer>();
            int banyaka = 0;
            int i = 0;
            int temp = 0;

            do {
                cek = "";
                System.out.print("Masukkan ID buku : ");
                temp = myOBJ.nextInt();
                if(temp > 4){
                    System.out.println("Mohon masukkan ID Buku dengan benar!!!!");
                }else{
                    idBuku.add(temp);
                    
                    System.out.print(buku.getNamaBuku(temp) + " sebanyak : ");
                    banyaka = myOBJ.nextInt();
                    banyak.add(banyaka);
                    if (banyaka > buku.getStok(i)) {
                        System.out.println("Mohon maaf stok buku tidak menyapai "+ banyaka);
                    }
                    else {
                        System.out.print("\nApakah ingin meminjam lagi? (Y/N) ");
                    cek = myOBJ.next();
                    }
                    i++;
                }

            } while (cek.equalsIgnoreCase("Y"));

            if (temp > 4 || banyaka > buku.getStok(i)) {
                System.out.println("Lakukan kembali dengan baik");
            }
            else if (!siswa.isStatus(idSiswa)) {
                System.out.println("Tidak bisa meminjam");
            } else {
                System.out.println("Transaksi belanja " + siswa.getNama(idSiswa) + " sebagai berikut");
                System.out.println("Nama Buku \tQty \tHarga \tJumlah \t");
                int total = 0;
                int x = idBuku.size();
                for (int j = 0; j < x; j++) {
                    int jumlah = banyak.get(j) * buku.getHarga(j);
                    total += jumlah;
                    System.out.println(buku.getNamaBuku(temp) + "\t\t" + banyak.get(j) + "\t" + buku.getHarga(j) + "\t" + jumlah);
                    
                    peminjaman.setPeminjaman(buku, idSiswa, idBuku.get(j), banyak.get(j));
                }
                System.out.println("Total Harga Peminjaman : " + total);

                siswa.editStatus(idSiswa, !siswa.isStatus(idSiswa));
            }
        }
    }

    public void setPeminjaman(Buku buku, int idSiswa, int idBuku, int banyaknya) {
        this.idSiswa.add(idSiswa);
        this.idBuku.add(idBuku);
        this.banyak.add(banyaknya);
        buku.editStok(idBuku, buku.getStok(idBuku) - banyaknya);
    }

    public int getIdBuku(int id) {
        return this.idBuku.get(id);
    }

    public int getBanyaknya(int id) {
        return this.banyak.get(id);
    }

    public int getIdSiswa(int id) {
        return this.idSiswa.get(id);
    }

    public int getJumlahPeminjaman() {
        return this.idSiswa.size();
    }

}