
import java.util.Scanner;

public class running {

    public static int idSiswa;
    public static String cek;

    public static void main(String[] args) {
        Scanner i = new Scanner(System.in);
        Buku book = new Buku();
        Siswa student = new Siswa();
        Peminjaman rent = new Peminjaman();
        Laporan report = new Laporan();
        Menu menu = new Menu();
        Petugas salary = new Petugas();
        Pengembalian repay = new Pengembalian();
        running run = new running();

        book.Buku();
        student.Siswa();
        salary.Petugas();

        System.out.println("");
        report.Laporan(student);
        System.out.println("");
        report.Laporan(book);
        System.out.println("");
        report.Laporan(salary);

        do {
            cek = "";
            do {
                System.out.println("");
                System.out.print("Masukkan ID Siswa: ");
                idSiswa = i.nextInt();

                if (idSiswa >= student.getJumlahSiswa() && idSiswa >= 0) {
                    System.out.println("ID tidak ditemukan\nSilahkan coba lagi...");
                }
            } while (idSiswa >= student.getJumlahSiswa());

            menu.Operator(menu, student, book, rent, repay, run);
            
            System.out.print("Mau masuk dengan ID Siswa yang lain? (Y/N) > ");
            cek = i.next();
            
            if (cek.equalsIgnoreCase("y")) {
                menu.setTrue();
            }
            
        } while (cek.equalsIgnoreCase("y"));
        
        System.out.println("See You Next Time!!!");
    }

    public int getidSiswa() {
        return this.idSiswa;
    }
}
