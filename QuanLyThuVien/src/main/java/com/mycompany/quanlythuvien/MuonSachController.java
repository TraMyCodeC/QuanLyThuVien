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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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
public class MuonSachController implements Initializable {
    @FXML private TableView<Sach> tbSach;
    @FXML private Label lbTime;
    @FXML private Button btnHome;
    @FXML private Button btnSave;
    @FXML private TextField txtId;
    @FXML private TextField txtTen;
    @FXML private TextField txtTacGia;
    @FXML private TextField txtNam;
    @FXML private TextField txtDanhMuc;
    @FXML private Button btnThemSach;
    @FXML private DateTimePicker txtNgayMuon;
    private static List<Integer>dsTra=new ArrayList<>();
      private Stage stage;
      private Scene scene;
      private Parent root;
        @Override
      public void initialize(URL url, ResourceBundle rb)
      {
          currentTime();
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
       dsTra.clear();
       root=FXMLLoader.load(getClass().getResource("NhanVienGui.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root,529,374);
                stage.setScene(scene);
                stage.show();
   }
   @FXML
   private void themSach() throws SQLException
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
                   if(MuonSachServices.ktSoSachNguoiMuon(id)==MuonSachServices.ktSoSachDaTra(id))
                   {
                       if(dsTra.size()>0)
                       {
                         if(ktTraTT(id)==0)
                             dsTra.add(id);
                       }
                       else
                           dsTra.add(id);
                   }
                   if(dsTra.contains(id))
                   {
                       if(MuonSachServices.ktSoSachNguoiMuon(id)==5)
                       {
                           Alert alert = new Alert(Alert.AlertType.INFORMATION);
                             alert.setTitle("Message");
                             alert.setHeaderText("Chỉ được mượn 5 quyển");
                             alert.showAndWait();
                       }
                       else
                       {
                            ObservableList<Sach> items;
                           items = tbSach.getSelectionModel().getSelectedItems();
                           Sach book=tbSach.getSelectionModel().getSelectedItem();
                           if(items.isEmpty())
                           {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                 alert.setTitle("Message");
                                 alert.setHeaderText("Vui lòng chọn sách mượn");
                                 alert.showAndWait(); 
                           }
                           else
                           {
                               try
                               {
                             Connection conn=JDBC.getConn();
                             String sql="Insert into muonsach(MaDG,MaSach,NgayMuon) Values(?,?,?)";
                             PreparedStatement pr=conn.prepareStatement(sql);
                             pr.setInt(1,id);
                             pr.setInt(2,book.getMaSach());
                             pr.setObject(3,txtNgayMuon.getDateTimeValue());
                             int dem=pr.executeUpdate();
                             if(dem>0)
                             {
                                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                 alert.setTitle("Message");
                                 alert.setHeaderText("Mượn thành công");
                                 alert.showAndWait();
                             }
                             else
                             {
                                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                 alert.setTitle("Message");
                                 alert.setHeaderText("Mượn không thành công");
                                 alert.showAndWait(); 
                             }}
                               catch(SQLIntegrityConstraintViolationException ex)
                               {
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                 alert.setTitle("Message");
                                 alert.setHeaderText("Sách đã mượn rồi");
                                 alert.showAndWait(); 
                               }
                           }
                       }
                   }
                   else
                   {
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
                             alert.setTitle("Message");
                             alert.setHeaderText("Vui lòng trả hết sách đã mượn");
                             alert.showAndWait();
                   }
                }
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
        ///
     }
     public void currentTime()
     {
         Thread clock= new Thread(){
              @Override
              public void run(){
              for (;;) {
                  try{
                     
                      Calendar cal = Calendar.getInstance();
                      int month=cal.get(Calendar.MONTH)+1;
                      int year=cal.get(Calendar.YEAR);
                      int day=cal.get(Calendar.DATE);
                      
                      int second = cal.get(Calendar.SECOND);
                      int minute = cal.get(Calendar.MINUTE);
                      int hour= cal.get(Calendar.HOUR_OF_DAY);
                       Platform.runLater(() -> {
                            lbTime.setText(day + "/"+month+"/"+year+ " "+hour + ":" + minute + ":" + second);
                       });     
                      Thread.sleep(1000);
//                      throw new UnsupportedOperationException("Not supported yet.");
                      //To change body of generated methods, choose Tools | Templates.
                  } catch (InterruptedException ex) {
                      Logger.getLogger(MuonSachController.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
              }};
         clock.start();
     }
     public int ktTraTT(int id)
     {
         int kt=0;
         for(int m:dsTra)
         {
             if(m==id)
                 kt=1;
         }
         return kt;
     }
  }
   

