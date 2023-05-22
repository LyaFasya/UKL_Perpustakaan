import java.util.Scanner;

public class running {

    public static int idSiswa;
    
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

        System.out.println("");
        System.out.print("Masukkan ID Siswa: ");
        idSiswa = i.nextInt();
        
        menu.Peminjaman(menu, student, book, rent, repay, run);
    }
    
    public int getidSiswa() {
        return this.idSiswa;
    }
}
