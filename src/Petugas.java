
import java.util.ArrayList;
public class Petugas implements User{
    
    private ArrayList<Integer> idPetugas = new ArrayList<Integer>();
    private ArrayList<String> namaPetugas = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();
    
    public void Petugas (){
        this.idPetugas.add(0);
        this.namaPetugas.add("Aulya");
        this.alamat.add("Tuban");
        this.telepon.add("081252812720");
        
        this.idPetugas.add(1);
        this.namaPetugas.add("Kya");
        this.alamat.add("Tuban");
        this.telepon.add("08887183242");
    }
    
    @Override
    public String getNama (int idPetugas){
        return this.namaPetugas.get(idPetugas);
    }
    
    @Override
    public String getAlamat (int idPetugas){
        return this.alamat.get(idPetugas);
    }
    
    @Override
    public String getTelepon(int idPetugas) {
        return this.telepon.get(idPetugas);
    }
    
    public int getId(int idPetugas){
        return this.idPetugas.get(idPetugas);
    }
    
    @Override
    public void setNama(String nama) {
        this.namaPetugas.add(nama);
    }
    
    @Override
    public void setAlamat(String alamat) {
        this.alamat.add(alamat);
    }
    
    @Override
    public void setTelepon(String telepon) {
        this.telepon.add(telepon);
    }
    
    public int getJumlahPetugas(){
        return this.idPetugas.size();
    }
}
