/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlythuvien;

import com.mycompany.Pojo.Sach;
import com.mycompany.Services.MuonSachServices;
import com.mycompany.Services.SachServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tornadofx.control.DateTimePicker;

/**
 *
 * @author My
 */
public class TraSachController implements Initializable {
    @FXML private Button btnHome;
    @FXML private Label lbTime;
    @FXML private TextField txtId;
    @FXML private Label lbTienPhat;
    @FXML private Button btnTra;
    @FXML private Button btnFind;
    @FXML private TableView<Sach> tbSach;
    @FXML private DateTimePicker txtNgayMuon;
    SachServices svc= new SachServices();
     private Stage stage;
      private Scene scene;
      private Parent root;
    @Override
       public void initialize(URL url, ResourceBundle rb)
       {   
           this.LoadTable();
             ObservableList<Sach> list = null;
        try {
            list = FXCollections.observableArrayList(svc.getDSSachId(2));
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuSachController.class.getName()).log(Level.SEVERE, null, ex);
        }
          FilteredList<Sach> filterList= new FilteredList<>(list);
      
          this.tbSach.setItems(filterList);
           
           //lbTienPhat.setVisible(true);
          
       }
     @FXML
            private void switchToNhanVienGUI(ActionEvent event) throws IOException
            {
                root=FXMLLoader.load(getClass().getResource("NhanVienGui.fxml"));
                         stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                         scene= new Scene(root,529,374);
                         stage.setScene(scene);
                         stage.show();
            }
    private void LoadTable()
    {
        TableColumn colMa= new TableColumn("Mã sách");
        colMa.setCellValueFactory(new PropertyValueFactory("MaSach"));
        
        TableColumn colTen= new TableColumn("Tên sách");
        colTen.setCellValueFactory(new PropertyValueFactory("TenSach"));
        
         TableColumn colTacGia= new TableColumn("Tác giả");
        colTacGia.setCellValueFactory(new PropertyValueFactory("TacGia"));
        
                TableColumn colMoTa= new TableColumn("Mô tả");
        colMoTa.setCellValueFactory(new PropertyValueFactory("MoTa"));
        
                TableColumn colNoiXB= new TableColumn("Nơi xuất bản");
        colNoiXB.setCellValueFactory(new PropertyValueFactory("NoiXB"));
        
                TableColumn colNamXB= new TableColumn("Năm xuất bản");
        colNamXB.setCellValueFactory(new PropertyValueFactory("NamXB"));
        
                  TableColumn colMaDM= new TableColumn("Mã danh mục");
        colMaDM.setCellValueFactory(new PropertyValueFactory("MaDanhMuc"));
        
                TableColumn colNgayNhap= new TableColumn("Ngày nhập");
        colNgayNhap.setCellValueFactory(new PropertyValueFactory("NgayNhap"));
        
                TableColumn colViTri= new TableColumn("Vị trí");
        colViTri.setCellValueFactory(new PropertyValueFactory("ViTri"));
                
           this.tbSach.getColumns().addAll(colMa,colTen,colTacGia,colMoTa,colNoiXB,colNamXB,colMaDM,colNgayNhap,colViTri);
                
    }
    @FXML 
    private void traSach() throws SQLException
    {
         if(MuonSachServices.ktMaDG(txtId.getText())==0)
         {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                         alert.setTitle("Message");
                         alert.setHeaderText("Vui lòng nhập lại mã độc giả");
                         alert.showAndWait();
         }
    }
    private void loadDataTable() throws SQLException
    {
         if(MuonSachServices.ktMaDG(txtId.getText())==0)
         {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                         alert.setTitle("Message");
                         alert.setHeaderText("Vui lòng nhập lại mã độc giả");
                         alert.showAndWait();
         }
         else
         {
             
         }
        
    }
}
