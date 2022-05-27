/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kipasangin2.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kipasangin2.model.kipas;
import kipasangin2.model.kipasproperty;

/**
 *
 * @author YENI
 */
public class DBHandler {

  public final Connection conn;

    public DBHandler(String driver) {
        this.conn = DBHelper.getConnection(driver);
    }
    public void addkipas(kipas k){
        String insertTv = "INSERT INTO `produk`(`kd_kipas`, `nama_produk`, `tgl_produksi`, `harga`)"
                + "VALUES (?,?,?,?)";
        try {
            PreparedStatement stmtInsert = conn.prepareStatement(insertTv);
            stmtInsert.setString(1, k.getKd_kipas());
            stmtInsert.setString(2, k.getNama());
            stmtInsert.setString(3, k.getTglProduksi());
            stmtInsert.setString(4, k.getHarga());
            stmtInsert.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ObservableList<kipasproperty> getkipas(){
        ObservableList<kipasproperty> data = FXCollections.observableArrayList();
        
        String sql = "SELECT `kd_kipas`, `nama_produk`, `tgl_produksi`, `merk`, `ukuran`, `harga` FROM `produk` ORDER BY `kd_kipas`";
        
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                kipasproperty t = new kipasproperty(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                data.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    public void deletekipas(kipasproperty k){
        String deletekipas = "DELETE FROM produk WHERE `produk`.`kd_kipas` = ?";
        try {
            PreparedStatement stmtDelete = conn.prepareStatement(deletekipas);
            stmtDelete.setString(1, k.getKd_kipas());
            stmtDelete.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updatekipas(kipasproperty k){
        String updateTv = "UPDATE `produk` SET `produk`.`kd_kipas` = ?, `produk`.`nama_produk` = ?,`produk`.`tgl_produksi` = ?,`produk`.`merk` = ?,`produk`.`ukuran` = ?,`produk`.`harga` = ? WHERE `produk`.`kd_kipas` = ?";
        try {
            PreparedStatement stmtUpdate = conn.prepareStatement(updateTv);
            stmtUpdate.setString(1, k.getKd_kipas());
            stmtUpdate.setString(2, k.getNama_produk());
            stmtUpdate.setString(3, k.getTgl_produksi());
            stmtUpdate.setString(4, k.getMerk());
            stmtUpdate.setString(5, k.getUkuran());
            stmtUpdate.setString(6, k.getHarga());
            stmtUpdate.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addKipas(kipas k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

    

