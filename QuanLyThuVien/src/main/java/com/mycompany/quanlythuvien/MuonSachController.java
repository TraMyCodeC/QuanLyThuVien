/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlythuvien;

import com.mycompany.Services.MuonSachServices;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    @FXML private Button btnThemSach;
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
   @FXML
   private void themSach() throws SQLException
   {
       int id=Integer.parseInt(txtId.getText());
       if(MuonSachServices.kiemTraHanThe(id)==0)
       {
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText("Thẻ hết hạn");
                alert.showAndWait();
       }
       else
       {
       if(MuonSachServices.ktSoSachNguoiMuon(id)!=MuonSachServices.ktSoSachDaTra(id))
       {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText("Vui lòng trả hết sách đã mượn");
                alert.showAndWait();
       }
       else
       {
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText("Sách đã trả hết");
                alert.showAndWait(); 
       }
       }
    }
}
