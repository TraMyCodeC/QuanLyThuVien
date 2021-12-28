/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlythuvien;

import com.mycompany.Pojo.Sach;
import com.mycompany.Services.MuonSachServices;
import com.mycompany.Services.SachServices;
import com.mycompany.config.JDBC;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author My
 */
public class MuonSachController implements Initializable {
    @FXML private TableView<Sach> tbSach;
    @FXML private Button btnHome;
    @FXML private Button btnSave;
    @FXML private TextField txtId;
    @FXML private TextField txtTen;
    @FXML private TextField txtTacGia;
    @FXML private TextField txtNam;
    @FXML private TextField txtDanhMuc;
    @FXML private Button btnThemSach;
    @FXML private TextField txtNgayMuon;
    private static int count=0;
      private Stage stage;
      private Scene scene;
      private Parent root;
        @Override
      public void initialize(URL url, ResourceBundle rb)
      {
          SachServices svc= new SachServices();
          this.LoadTable();
           ObservableList<Sach> list = null;
        try {
            list = FXCollections.observableArrayList(svc.getDSSach());
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuSachController.class.getName()).log(Level.SEVERE, null, ex);
        }
          FilteredList<Sach> filterList= new FilteredList<>(list);
      
          this.tbSach.setItems(filterList);
          filterList.predicateProperty().bind(Bindings.createObjectBinding(()->
          Sach->Sach.getTenSach().toLowerCase().contains(txtTen.getText().toLowerCase())&&
                  Sach.getTacGia().toLowerCase().contains(txtTacGia.getText().toLowerCase())&&
                  Sach.getMaDM().contains(txtDanhMuc.getText())&&
                  Sach.getNamXuat().contains(txtNam.getText()),
                  txtTen.textProperty(),txtTacGia.textProperty(),
                  txtDanhMuc.textProperty(),txtNam.textProperty()
          ));
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
   @FXML
   private void themSach() throws SQLException
   {
       if(count!=5)
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
                           //
                        }
               }
             }
       }
       else
       {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                 alert.setTitle("Message");
                                 alert.setHeaderText("Chỉ được mượn 5 quyển");
                                 alert.showAndWait(); 
       }
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
     private void saveFile()
     {
          if(count!=0)
       {
          Alert alert = new Alert(AlertType.CONFIRMATION, "Bạn có muốn lưu thông tin này không??", ButtonType.YES, ButtonType.NO);
           alert.showAndWait();

    if (alert.getResult() == ButtonType.YES)
                              count=0;                   
       }
     }
}
