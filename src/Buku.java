
import java.util.ArrayList;
public class Buku {
    
    private ArrayList<Integer> idBuku = new ArrayList<Integer>();
    private ArrayList<String> namaBuku = new ArrayList<String>();
    private ArrayList<Integer> stok = new ArrayList<Integer>();
    private ArrayList<Integer> harga = new ArrayList<Integer>();
    
    public void Buku(){
        this.idBuku.add(0);
        this.namaBuku.add("Bumi");
        this.stok.add(5);
        this.harga.add(10000);
        
        this.idBuku.add(1);
        this.namaBuku.add("Bulan");
        this.stok.add(6);
        this.harga.add(15000);
        
        this.idBuku.add(2);
        this.namaBuku.add("Matahari");
        this.stok.add(7);
        this.harga.add(20000);
        
        this.idBuku.add(3);
        this.namaBuku.add("Bintang");
        this.stok.add(8);
        this.harga.add(25000);
        
        this.idBuku.add(4);
        this.namaBuku.add("Ceros");
        this.stok.add(9);
        this.harga.add(30000);
    }
    
    public void setIdBuku(int idBuku) {
        this.idBuku.add(idBuku);
    }
    
    public void setNamaBuku (String namaBuku){
        this.namaBuku.add(namaBuku);
    }
    
    public void setStok (int stok){
        this.stok.add(stok);
    }
    
    public void setHarga (int harga){
        this.harga.add (harga);
    }
    
    public int getIdBuku (int idBuku){
        return this.idBuku.get(idBuku);
    }
    
    public String getNamaBuku (int idBuku){
        return this.namaBuku.get(idBuku);
    }
    
    public int getStok (int idBuku){
        return this.stok.get(idBuku);
    }
    
    public int getJumlahBuku(){
        return this.idBuku.size();
    }
    
    public int getHarga (int idBuku){
        return this.harga.get(idBuku);
    }
    
    public void editStok (int idBuku, int stok){
        this.stok.set(idBuku, stok);
    }
}
