/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kipasangin2;

/**
 *
 * @author YENI
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import kipasangin2.db.DBHandler;
import kipasangin2.model.kipas;

public class FXMLEditFormController implements Initializable {

    @FXML
    private RadioButton rdPanasonic;

    @FXML
    private RadioButton rdLG;

    @FXML
    private RadioButton rdSony;

    @FXML
    private TextField kd_kipas;

    @FXML
    private TextField tfNama;

    @FXML
    private TextField tfHarga;

    @FXML
    private ComboBox<?> cbUkuran;

    @FXML
    private DatePicker dpTanggalProduksi;

    @FXML
    private Button btnSave;

      @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println(kd_kipas.getText());
        System.out.println(tfNama.getText());
        System.out.println(dpTanggalProduksi.getValue().toString());
        String merk ="";
        if(rdLG.isSelected())
            merk = rdLG.getText();
        if(rdSony.isSelected())
            merk = rdSony.getText();
        if(rdPanasonic.isSelected())
            merk = rdPanasonic.getText();
        System.out.println(merk);
        System.out.println(cbUkuran.getValue().toString());
        System.out.println(tfHarga.getText());
        
        kipas k = new kipas(kd_kipas.getText(),tfNama.getText(),dpTanggalProduksi.getValue().toString(),
        merk,cbUkuran.getValue().toString(), tfHarga.getText());
        
        DBHandler dh = new DBHandler("MYSQL");
        dh.addKipas(k);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList <String> list = new ArrayList<String>();
        list.add("75 Inch");
        list.add("43 Inch");
        list.add("65 Inch");
        
        ObservableList items = FXCollections.observableArrayList(list);
        
        cbUkuran.setItems(items);
    }    
    
}
