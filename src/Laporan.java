
public class Laporan {
    public void Laporan(Siswa Siswa){
        System.out.println("--- List Siswa ---");
        System.out.println("ID \t Nama \tAlamat \tTelepon \t\tStatus");
        for (int i = 0; i < Siswa.getJumlahSiswa(); i++) {
            System.out.println(Siswa.getId(i) + " \t " +
                    Siswa.getNama(i) + " \t" +
                    Siswa.getAlamat(i) + " \t" + 
                    Siswa.getTelepon(i)+ "\t"+ 
                    Siswa.getStatus(i));
        }
    }
    
    public void Laporan(Buku Buku){
        System.out.println("--- List Buku ---");
        System.out.println("ID \t Judul \t\t Stok");
        for (int i = 0; i < Buku.getJumlahBuku(); i++) {
            System.out.println(Buku.getIdBuku(i) + " \t " + Buku.getNamaBuku(i) + " \t\t " + Buku.getStok(i));
        }
        
    }

    public void Laporan (Petugas Petugas){
        System.out.println("---Petugas Hari ini---");
        System.out.println("ID \t Nama ");
        for(int i = 0; i < Petugas.getJumlahPetugas(); i++){
            System.out.println(Petugas.getId(i) + "\t" 
                    + Petugas.getNama(i));
        }
    }
}
