import java.util.Scanner;
import java.util.ArrayList;

public class Pengembalian extends Peminjaman{
    private ArrayList<Integer> idBuku = new ArrayList<Integer>();
    private ArrayList<Integer> idSiswa = new ArrayList<Integer>();
    private ArrayList<Integer> banyak = new ArrayList<Integer>();
    private ArrayList<Integer> pinjamanBuku = new ArrayList<Integer>();
    
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

    public void prosesPengembalian(Siswa siswa, Pengembalian pengembalian, Buku buku) {
        Scanner myOBJ = new Scanner(System.in);

        System.out.println("~~~~~~ Pengembalian Buku ~~~~~~");
        System.out.println("Silakan Mengembalikan Buku");
        System.out.print("Masukkan ID Siswa : ");

        int idSiswa = myOBJ.nextInt();
        if (siswa.isStatus(idSiswa) == true) {
            System.out.println("Status anda belum meminjam buku, silakan untuk meminjam terlebih dahulu");
        }
        else if (idSiswa >= siswa.getJumlahSiswa() && idSiswa >= 0) {
            System.out.println("ID tidak ditemukan");
        } else {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Halo " + siswa.getNama(idSiswa) + "!");
            System.out.println("Selamat datang kembali di Perpustakaan!");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

            ArrayList<Integer> idBuku = new ArrayList<Integer>();
            ArrayList<Integer> banyak = new ArrayList<Integer>();
            int limit;
            int i = 0;
            int temp = 0;
            String cek;
            
            System.out.println("Ingin mengembalikan buku? (Y/N)\n>");
            cek = myOBJ.next();
            
            if (cek.equalsIgnoreCase("y")) {
                System.out.println("\nLIST BUKU\nID \t Nama Buku \t\t Stok ");
                    for (int j = 0; j < buku.getStok(i); j++) {
                        System.out.println(j + " \t " + buku.getNamaBuku(j) + " \t\t " + buku.getStok(j) );
                        }
                        System.out.print("\nAnda telah meminjam buku dengan ID " + siswa.getPinjamanBuku(idSiswa) + ".\nApakah ingin dikembalikan? (Y/N) > ");
                        String balik = myOBJ.next();
                        
                        if (balik.equalsIgnoreCase("Y")) {
                            siswa.editStatus(idSiswa, false);
                            buku.editStok(siswa.getPinjamanBuku(idSiswa), (buku.getStok(siswa.getPinjamanBuku(idSiswa)) + 1));
                            idBuku.add(temp);
                            banyak.add(1);
                            siswa.setStatus(true);
                            pinjamanBuku.add(null);
                            System.out.println("Transaksi Pengembalian " + siswa.getNama(idSiswa) + " sebagai berikut");
                            System.out.println("Nama Buku \tQty \tHarga \tJumlah \t");
                            int total = 0;
                            int x = idBuku.size();
                            for (int j = 0; j < x; j++) {
                                int jumlah = banyak.get(j) * buku.getHarga(idBuku.get(j));
                                total += jumlah;
                                System.out.println(buku.getNamaBuku(idBuku.get(j)) + "\t" + banyak.get(j) + "\t"
                                        + buku.getHarga(idBuku.get(j)) + "\t" + jumlah);
                                pengembalian.setPengembalian(buku, idSiswa, idBuku.get(j), banyak.get(j));
                            }
                            System.out.println("Total Harga Pengembalian : " + total);

                            siswa.editStatus(idSiswa, !siswa.isStatus(idSiswa));
                        }
                        else{
                            System.out.println("KALO MISAL BELUM SELESAI PINJAM, NGAPAIN MASUK MENU PENGEMBALIAN!!!!!!");
                        }
            }
            else if (cek.equalsIgnoreCase("N")) {
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