/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlythuvien;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author My
 */
public class MuonSachController {
    @FXML private Button btnHome;
    @FXML private TextField txtId;
    @FXML private TextField txtTen;
    @FXML private TextField txtTacGia;
    @FXML private TextField txtNam;
    @FXML private TextField txtDanhMuc;
    @FXML private TableView tbSach;
      private Stage stage;
      private Scene scene;
      private Parent root;
   @FXML
   private void switchToNhanVienGUI(ActionEvent event) throws IOException
   {
       root=FXMLLoader.load(getClass().getResource("NhanVienGui.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root,529,374);
                stage.setScene(scene);
                stage.show();
   }
}
