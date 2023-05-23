
import java.util.Scanner;
import java.util.ArrayList;

public class Peminjaman {

    private ArrayList<Integer> idBuku = new ArrayList<Integer>();
    private ArrayList<Integer> idSiswa = new ArrayList<Integer>();
    private ArrayList<Integer> banyak = new ArrayList<Integer>();

    ArrayList<Integer> idBukuTemp = new ArrayList<Integer>();
    ArrayList<Integer> banyakTemp = new ArrayList<Integer>();

    public Peminjaman() {
        this.idSiswa.add(0);
        this.idBuku.add(2);
        this.banyak.add(2);

        this.idSiswa.add(0);
        this.idBuku.add(1);
        this.banyak.add(3);

        this.idSiswa.add(1);
        this.idBuku.add(2);
        this.banyak.add(1);

        this.idSiswa.add(1);
        this.idBuku.add(2);
        this.banyak.add(2);
        
        this.idSiswa.add(1);
        this.idBuku.add(3);
        this.banyak.add(2);
    }

    public void prosesPeminjaman(Siswa siswa, Peminjaman peminjaman, Buku buku, Pengembalian balek, Menu menu, running run) {
        Scanner myOBJ = new Scanner(System.in);
        String cek = "";

        System.out.println("Silahkan Meminjam Buku");

        if (siswa.isStatus(running.idSiswa) == false) {
            System.out.println("Halo " + siswa.getNama(running.idSiswa) + "!");
            System.out.println("Status anda tidak diizinkan untuk meminjam, silakan hubungi pusat");
        } else {
            int banyaka = 0;
            int i = 0;
            int temp = 0;
            do {
                cek = "";

                do {
                    do {
                        System.out.print("Masukkan ID buku : ");
                        temp = myOBJ.nextInt();

                        if (temp > 4 || temp < 0) {
                            System.out.println("Mohon masukkan ID Buku dengan benar!!!!\n");
                        }
                    } while (temp > 4 || temp < 0);


                    System.out.print(buku.getNamaBuku(temp) + " sebanyak : ");
                    banyaka = myOBJ.nextInt();

                    if (banyaka > buku.getStok(temp)) {
                        System.out.println("Mohon maaf stok buku tidak menyapai " + banyaka);
                    } else {
                        buku.editStok(temp, (buku.getStok(temp) - banyaka));
                        idBukuTemp.add(temp);
                        menu.setIdBuku(temp);
                        banyakTemp.add(banyaka);
                        menu.setBanyak(banyaka);
                        
                        System.out.print("\nApakah ingin meminjam lagi? (Y/N) ");
                        cek = myOBJ.next();
                        i++;
                    }
                } while (banyaka >= buku.getStok(temp));
            } while (cek.equalsIgnoreCase("Y"));

            if (temp > 4 || banyaka > buku.getStok(i)) {
                System.out.println("Lakukan kembali dengan baik");
            } else if (!siswa.isStatus(running.idSiswa)) {
                System.out.println("Tidak bisa meminjam");
                
            
            } else{
                    System.out.println("Transaksi belanja " + siswa.getNama(running.idSiswa) + " sebagai berikut");
                System.out.println("Nama Buku \tQty \tHarga \tJumlah \t");
                int total = 0;
                int x = idBukuTemp.size();
                for (int j = 0; j < x; j++) {
                    int jumlah = banyakTemp.get(j) * buku.getHarga(j);
                    total += jumlah;
                    System.out.println(buku.getNamaBuku(idBukuTemp.get(j)) + "\t\t" + banyakTemp.get(j) + "\t" + buku.getHarga(j) + "\t" + jumlah);

                    peminjaman.setPeminjaman(buku, running.idSiswa, idBukuTemp.get(j), banyakTemp.get(j));
                }
                System.out.println("Total Harga Peminjaman : " + total);

                siswa.editStatus(running.idSiswa, !siswa.isStatus(running.idSiswa));
            
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

    public int getIdBukuTemp(int a) {
        return this.idBukuTemp.get(a);
    }
}