
import java.util.Scanner;
import java.util.ArrayList;

public class Pengembalian extends Peminjaman {

    private ArrayList<Integer> idBuku = new ArrayList<Integer>();
    private ArrayList<Integer> idSiswa = new ArrayList<Integer>();
    private ArrayList<Integer> banyak = new ArrayList<Integer>();
    private ArrayList<Integer> pinjamanBuku = new ArrayList<Integer>();

    ArrayList<Integer> idBukuBalik = new ArrayList<Integer>();
    ArrayList<Integer> banyakBalik = new ArrayList<Integer>();

    public Pengembalian() {
        this.idSiswa.add(0);
        this.idBuku.add(0);
        this.banyak.add(2);
        this.pinjamanBuku.add(1);

        this.idSiswa.add(0);
        this.idBuku.add(1);
        this.banyak.add(3);
        this.pinjamanBuku.add(2);

        this.idSiswa.add(1);
        this.idBuku.add(0);
        this.banyak.add(1);
        this.pinjamanBuku.add(0);

        this.idSiswa.add(1);
        this.idBuku.add(2);
        this.banyak.add(2);
        this.pinjamanBuku.add(3);

    }

    public void prosesPengembalian(Menu menu, Siswa siswa, Pengembalian pengembalian, Buku buku, Peminjaman pinjam) {
        Scanner myOBJ = new Scanner(System.in);

        System.out.println("~~~~~~ Pengembalian Buku ~~~~~~");
        System.out.println("Silakan Mengembalikan Buku");
        
        if (siswa.isStatus(running.idSiswa) == true) {
            System.out.println("Status anda belum meminjam buku, silakan untuk meminjam terlebih dahulu");
        } else if (running.idSiswa >= siswa.getJumlahSiswa() && running.idSiswa >= 0) {
            System.out.println("ID tidak ditemukan");
        } else {
            int limit;
            int i = 0;
            int temp = 0;
            String cek;

            System.out.print("Ingin mengembalikan buku? (Y/N)\n>");
            cek = myOBJ.next();

            if (cek.equalsIgnoreCase("y")) {
                System.out.print("\nAnda telah meminjam buku dengan ID ");
                menu.showIdBuku();
                System.out.print("\nApakah ingin dikembalikan? (Y/N) > ");
                String balik = myOBJ.next();

                if (balik.equalsIgnoreCase("Y")) {
                    siswa.editStatus(running.idSiswa, false);
                    buku.editStok(siswa.getPinjamanBuku(running.idSiswa), (buku.getStok(siswa.getPinjamanBuku(running.idSiswa)) + 1));
                    idBuku.add(temp);
                    banyak.add(1);
                    siswa.setStatus(true);
                    pinjamanBuku.add(null);
                    System.out.println("Detail Pengembalian " + siswa.getNama(running.idSiswa) + " sebagai berikut");
                    System.out.println("Nama Buku \tQty \tHarga \tJumlah \t");
                    int total = 0;
                    int x = menu.getJmlBuku();
                    for (int j = 0; j < x; j++) {
                        int jumlah = menu.getbanyak(j) * buku.getHarga(menu.getIdBuku(j));
                        total += jumlah;
                        System.out.println(buku.getNamaBuku(menu.getIdBuku(j)) + "\t" + menu.getbanyak(j) + "\t" + buku.getHarga(menu.getIdBuku(j)) + "\t" + jumlah);
                        pengembalian.setPengembalian(buku, running.idSiswa, menu.getIdBuku(j), menu.getbanyak(j));
                    }
                    System.out.println("Total Harga Pengembalian : " + total);

                    siswa.editStatus(running.idSiswa, !siswa.isStatus(running.idSiswa));
                } else {
                    System.out.println("KALO MISAL BELUM SELESAI PINJAM, NGAPAIN MASUK MENU PENGEMBALIAN!!!!!!");
                }
            } else if (cek.equalsIgnoreCase("N")) {
                System.out.println("KALO MISAL BELUM SELESAI PINJAM, NGAPAIN MASUK MENU PENGEMBALIAN!!!!!!");

            }
        }
    }

    public void setPengembalian(Buku buku, int idSiswa, int idBuku, int banyaknya) {
        this.idSiswa.add(idSiswa);
        this.idBuku.add(idBuku);
        this.banyak.add(banyaknya);
        buku.editStok(idBuku, buku.getStok(idBuku) + banyaknya);
    }

    @Override
    public int getIdBuku(int id) {
        return this.idBuku.get(id);
    }

    @Override
    public int getBanyaknya(int id) {
        return this.banyak.get(id);
    }

    @Override
    public int getIdSiswa(int id) {
        return this.idSiswa.get(id);
    }

    @Override
    public int getJumlahPeminjaman() {
        return this.idSiswa.size();
    }
}
