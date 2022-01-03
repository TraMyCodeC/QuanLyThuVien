/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlythuvien;

import com.mycompany.Pojo.DocGia;
import com.mycompany.config.Ultils;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author My
 */
public class THeDocGiaController implements Initializable {
     @FXML private Button btnBack;
    @FXML private TextField txtMa;
    @FXML private TextField txtTen;
    @FXML private TextField txtGioiTinh;
    @FXML private TextField txtDoiTuong;
    @FXML private TextField txtNgaySinh;
    @FXML private TextField txtHanThe;
    //@FXML private TextField txtTen;
     private Stage stage;
      private Scene scene;
      private Parent root;
      private DocGia docGia;
    
    @FXML  
    private void switchToDocGiaGUI(ActionEvent event) throws IOException {
         root=FXMLLoader.load(getClass().getResource("DocGiaGUI.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                 stage.setResizable(false);
                stage.show();
    }
    @Override
public void initialize(URL url, ResourceBundle rb) {
    
    dataInit(DocGiaGUI.getDocGia());
}
    private void dataInit(DocGia dg)
    {   
        docGia=dg;
        txtMa.setText(Ultils.inToString(dg.getMaDG()));
        txtTen.setText(dg.getHoTen());
        txtGioiTinh.setText(dg.getGioiTinh());
        txtDoiTuong.setText(dg.getDoiTuong());
        txtNgaySinh.setText(Ultils.dateTimeFormatter(dg.getNgaySinh()));
        txtHanThe.setText(Ultils.dateTimeFormatter(dg.getHanThe()));
    }
}
