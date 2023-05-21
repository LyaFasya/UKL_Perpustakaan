
public class running {
    public static void main(String[] args) {
    Buku book = new Buku();
        Siswa student = new Siswa();
        Peminjaman rent= new Peminjaman();
        Laporan report = new Laporan();
        Menu menu = new Menu();
        Petugas salary = new Petugas();
        Pengembalian repay = new Pengembalian();
 
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
        menu.Peminjaman(student, book, rent, repay);
    }
}
