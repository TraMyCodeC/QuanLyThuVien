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
import com.mycompany.config.Ultils;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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
     int ngay=0,money=0;
    SachServices svc= new SachServices();
     private Stage stage;
      private Scene scene;
      private Parent root;
    @Override
       public void initialize(URL url, ResourceBundle rb)
       {   
           this.LoadTable();
           currentTime();
         lbTienPhat.setVisible(false);
          txtId.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                lbTienPhat.setVisible(false);
            }
        });
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
           this.tbSach.setPlaceholder(new Label("Không tìm thấy dữ liệu"));
                
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
         else
         {
               ObservableList<Sach> items;
                           items = tbSach.getSelectionModel().getSelectedItems();
                           Sach book=tbSach.getSelectionModel().getSelectedItem();
                           if(items.isEmpty())
                           {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                 alert.setTitle("Message");
                                 alert.setHeaderText("Vui lòng chọn sách cần trả");
                                 alert.showAndWait(); 
                           }
                           else
                           {
                              
                               LocalDateTime ngay=getDateTime(book.getMaSach());
                               tienPhat(ngay,txtNgayMuon.getDateTimeValue());
                                traSachMuon(book.getMaSach());
                               int tien=Integer.parseInt(lbTienPhat.getText());
                               if(tien>0)
                                   lbTienPhat.setVisible(true);
                               else
                                   lbTienPhat.setVisible(false);
                               refreshData();
                               
                           }
         }
    }
    @FXML
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
             refreshData();
         }
        
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
     private void traSachMuon(int maSach)
     {
         int id=Integer.parseInt(txtId.getText());
        try {
            Connection conn=JDBC.getConn();
            String sql="Update muonsach set NgayTra=? where MaDG=? and MaSach=? and NgayTra is null";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(1,txtNgayMuon.getDateTimeValue());
            stm.setInt(2,id);
            stm.setInt(3, maSach);
            int c=stm.executeUpdate();
            if(c==0)
            {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                         alert.setTitle("Message");
                         alert.setHeaderText("Trả không thành công");
                         alert.showAndWait();
            }
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                         alert.setTitle("Message");
                         alert.setHeaderText("Trả không thành công");
                         alert.showAndWait();
        }
             
     }
     private void tienPhat(LocalDateTime ngayMuon,LocalDateTime NgayTra)
     {
         
          
        try {
            Connection conn=JDBC.getConn();
            String sql="SELECT DATEDIFF(?,?)";
             PreparedStatement stm=conn.prepareStatement(sql);
             stm.setObject(1,NgayTra);
             stm.setObject(2,ngayMuon);
             ResultSet rs=stm.executeQuery();
              while(rs.next())
               ngay=rs.getInt(1);
              if(ngay-30>0)
              {
                  money=(ngay-30)*5000;
                  
              }
              else
                  money=0;
              
             
        } catch (SQLException ex) {
            Logger.getLogger(TraSachController.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbTienPhat.setText(Ultils.inToString(money));
            
     }
     private LocalDateTime getDateTime(int maSach)
     {
         int id=Integer.parseInt(txtId.getText());
           LocalDateTime dt=null;
          try {
            Connection conn=JDBC.getConn();
            String sql="SELECT NgayMuon from muonsach where MaDG=? and MaSach=? and NgayTra is null";
             PreparedStatement stm=conn.prepareStatement(sql);
             stm.setInt(1, id);
             stm.setInt(2, maSach);
               ResultSet rs=stm.executeQuery();
              while(rs.next())
                  dt=rs.getObject(1,LocalDateTime.class);
                  
     }  catch (SQLException ex) {
            Logger.getLogger(TraSachController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dt;
}
     private void refreshData()
     {
         try {
                  int id=Integer.parseInt(txtId.getText());
             ObservableList<Sach> list = FXCollections.observableArrayList(svc.getDSSachId(id));
              FilteredList<Sach> filterList= new FilteredList<>(list);
          this.tbSach.setItems(filterList);
           
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuSachController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
