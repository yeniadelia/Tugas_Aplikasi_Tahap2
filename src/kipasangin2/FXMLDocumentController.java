/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kipasangin2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import kipasangin2.db.DBHandler;
import kipasangin2.model.kipasproperty;

/**
 *
 * @author YENI
 */
public class FXMLDocumentController implements Initializable {
    

    @FXML
    private TableView<?> tblkipas;

    @FXML
    private TableColumn<?, ?> colKd_kipas;

    @FXML
    private TableColumn<?, ?> colNama_produk;

    @FXML
    private TableColumn<?, ?> colTglProduksi;

    @FXML
    private TableColumn<?, ?> colMerk;

    @FXML
    private TableColumn<?, ?> colUkuran;

    @FXML
    private TableColumn<?, ?> colHarga;
    
    @FXML
    private MenuItem menuAddData;

    @FXML
    private MenuItem menuDeleteData;

   @FXML
    void viewAddDataForm(ActionEvent event) throws IOException {
        Stage modal = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("UserInterface.fxml"));
        Scene scene = new Scene(root);
        modal.setScene(scene);
//        modal.initOwner(((Node)event.getSource()).getScene().getWindow() );
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
    }
    
    @FXML
    void viewEditDataTv(ActionEvent event) throws IOException {
        Stage modal = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLEditForm.fxml"));
        Scene scene = new Scene(root);
        modal.setScene(scene);
//        modal.initOwner(((Node)event.getSource()).getScene().getWindow() );
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
    }

    @FXML
    void deleteDataTv(ActionEvent event) {
        kipasproperty t = (kipasproperty) tblkipas.getSelectionModel().getSelectedItem();
        int ans = JOptionPane.showConfirmDialog(null, "Yakin Akan Menghapus?");
        if (ans == JOptionPane.YES_OPTION) {
            DBHandler dh = new DBHandler("MYSQL");
            dh.deletekipas(t);
            showDataTv();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showDataTv();
        tblkipas.getSelectionModel().selectedIndexProperty().addListener(evt -> {
//            JOptionPane.showMessageDialog(null,"Test Klik");
            menuDeleteData.setDisable(false);
        });
    }

    public void showDataTv() {
        DBHandler dh = new DBHandler("MYSQL");
        ObservableList<kipasproperty> data = dh.getkipas();
        colMerk.setCellValueFactory(new PropertyValueFactory<>("merk"));
        colKd_kipas.setCellValueFactory(new PropertyValueFactory<>("kd_kipas"));
        colNama_produk.setCellValueFactory(new PropertyValueFactory<>("nama_produk"));
        colUkuran.setCellValueFactory(new PropertyValueFactory<>("ukuran"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colTglProduksi.setCellValueFactory(new PropertyValueFactory<>("tgl_produksi"));
        tblkipas.setItems(null);
       
    }   
    
}


