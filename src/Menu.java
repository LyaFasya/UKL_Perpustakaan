
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private ArrayList<Integer> idSiswa = new ArrayList<Integer>();
    private ArrayList<Integer> idBuku = new ArrayList<Integer>();
    private ArrayList<Integer> banyak = new ArrayList<Integer>();
    
    boolean stay = true;
    Scanner set = new Scanner(System.in);

    public void Peminjaman(Menu Menu, Siswa Siswa, Buku Buku, Peminjaman Peminjaman, Pengembalian Pengembalian, running run) {

        Siswa student = new Siswa();
        Buku book = new Buku();
        Laporan report = new Laporan();
        Petugas salary = new Petugas();
        Peminjaman rent = new Peminjaman();
        Pengembalian repay = new Pengembalian();

        while (stay) {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Halo " + Siswa.getNama(running.idSiswa) + "!");
            System.out.println("Selamat datang di Perpustakaan!");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
            
            System.out.println("<<<<<===== ASYAAA'S LIBRARY =====>>>>>");
            System.out.println("Silakan Pilih Menu\n1. Status Siswa");
            System.out.println("2. Stok Buku");
            System.out.println("3. Peminjaman");
            System.out.println("4. Pengembalian");
            System.out.println("5. Exit");
            System.out.print("> ");
            int menu = set.nextInt();

            if (menu == 1) {
                System.out.println("Status Siswa");
                System.out.println("ID \t Nama \t Status");
                for (int i = 0; i < Siswa.getJumlahSiswa(); i++) {
                    System.out.println(Siswa.getId(i) + "\t" + Siswa.getNama(i) + "\t" + Siswa.getStatus(i));
                }

            } else if (menu == 2) {
                System.out.println("Stok Buku");
                System.out.println("ID \t Judul \t\t Stok");
                for (int i = 0; i < Buku.getJumlahBuku(); i++) {
                    System.out.println(Buku.getIdBuku(i) + "\t" + Buku.getNamaBuku(i) + "\t\t" + Buku.getStok(i));
                }

            } else if (menu == 3) {

                rent.prosesPeminjaman(Siswa, Peminjaman, Buku, Pengembalian, Menu, run);

            } else if (menu == 4) {

                repay.prosesPengembalian(Menu, Siswa, Pengembalian, Buku, Peminjaman);

            } else if (menu == 5) {
                stay = false;
                System.out.println("Terima Kasih " + Siswa.getNama(running.idSiswa) + " Sudah Datang di Perpustakaan :D\nSee You Next Time!!!");
            } else {
                System.out.println("Pilih menu dengan benar");
            }
        }

    }

    public void setBanyak(int a) {
        banyak.add(a);
    }

    public int getbanyak(int a) {
        return banyak.get(a);
    }

    public void setIdBuku(int a) {
        idBuku.add(a);
    }

    public int getIdBuku(int a) {
        return idBuku.get(a);
    }

    public void showIdBuku() {
        System.out.println(idBuku);
    }

    public int getJmlBuku() {
        return idBuku.size();
    }
}
