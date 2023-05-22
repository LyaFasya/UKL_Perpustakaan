import java.util.ArrayList;

public class Siswa implements User{
    
    private ArrayList<Integer> idSiswa = new ArrayList<Integer>();
    private ArrayList<String> namaSiswa = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();
    private ArrayList<Boolean> status = new ArrayList<Boolean>(); // true = blom pinjam | false = udah pinjem
    private ArrayList<Integer> pinjamanBuku = new ArrayList<Integer>();
    
    public void Siswa (){
        this.idSiswa.add (0);
        this.namaSiswa.add ("Fasya");
        this.alamat.add ("Tuban");
        this.telepon.add ("081252812720");
        this.status.add (false);
        this.pinjamanBuku.add (1);
        
        this.idSiswa.add (1);
        this.namaSiswa.add ("Bella");
        this.alamat.add ("Malang");
        this.telepon.add ("081252183012");
        this.status.add (true);
        this.pinjamanBuku.add (0);
        
        this.idSiswa.add (2);
        this.namaSiswa.add ("Agus");
        this.alamat.add ("Tuban");
        this.telepon.add ("085161118789");
        this.status.add (true);
        this.pinjamanBuku.add (0);
        
        this.idSiswa.add (3);
        this.namaSiswa.add ("Jawad");
        this.alamat.add ("Bogor");
        this.telepon.add ("081383117808");
        this.status.add (true);
        this.pinjamanBuku.add (0);
        
        this.idSiswa.add (4);
        this.namaSiswa.add ("Daffa");
        this.alamat.add ("Tuban");
        this.telepon.add ("081230329149");
        this.status.add (true);
        this.pinjamanBuku.add (0);
    }
    
    public void setStatus(boolean status){
        this.status.add(status);
    }
    
    public String getStatus(int idSiswa){
        if(this.status.get(idSiswa)){
            return ("Anda Diizinkan Meminjam Buku");
        }else{
            return ("Anda Tidak Diizinkan Meminjam Buku");
        }
    }
    
    public boolean isStatus(int idSiswa){
        return status.get(idSiswa);
    }
    
    @Override
    public String getNama(int idSiswa) {
        return this.namaSiswa.get(idSiswa);
    }
    
    @Override
    public String getAlamat(int idSiswa) {
        return this.alamat.get(idSiswa);
    }
    
    @Override
    public String getTelepon(int idSiswa) {
        return this.telepon.get(idSiswa);
    }
    
    @Override
    public void setNama(String nama) {
        this.namaSiswa.add(nama);
    }
    
    @Override
    public void setAlamat(String alamat) {
        this.alamat.add(alamat);
    }
    
    @Override
    public void setTelepon(String telepon) {
        this.telepon.add(telepon);
    }
    
    public int getJumlahSiswa(){
        return this.namaSiswa.size();
    }
    
    public int getId(int idSiswa){
        return this.idSiswa.get(idSiswa);
    }
    
    public void editStatus(int idSiswa, boolean status){
        this.status.set(idSiswa, status);            
    }
    public int getPinjamanBuku(int idSiswa) {
        return this.pinjamanBuku.get(idSiswa);
    }
    
    public void editPinjamanBuku(int a, int b) {
        this.pinjamanBuku.set(a,b);
    }
}