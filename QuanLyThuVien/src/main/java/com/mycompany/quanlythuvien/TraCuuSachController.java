/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlythuvien;

import com.mycompany.Pojo.DocGia;
import com.mycompany.Pojo.Sach;
import com.mycompany.Services.SachServices;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author My
 */
public class TraCuuSachController implements Initializable {
    @FXML private TableView<Sach> tbSach;
    @FXML private Button btnHome;
    @FXML private Button btnSearch;
    @FXML private TextField txtTen;
    @FXML private TextField txtTacGia;
    @FXML private TextField txtNam;
    @FXML private TextField txtDanhMuc;
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
    private void switchToDocGiaGUI(ActionEvent event) throws IOException {
         root=FXMLLoader.load(getClass().getResource("DocGiaGUI.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root,535,313);
                stage.setScene(scene);
                 stage.setResizable(false);
                stage.show();
    }
    private void LoadTable()
    {
        TableColumn colMa= new TableColumn("M?? s??ch");
        colMa.setCellValueFactory(new PropertyValueFactory("MaSach"));
        
        TableColumn colTen= new TableColumn("T??n s??ch");
        colTen.setCellValueFactory(new PropertyValueFactory("TenSach"));
        
         TableColumn colTacGia= new TableColumn("T??c gi???");
        colTacGia.setCellValueFactory(new PropertyValueFactory("TacGia"));
        
                TableColumn colMoTa= new TableColumn("M?? t???");
        colMoTa.setCellValueFactory(new PropertyValueFactory("MoTa"));
        
                TableColumn colNoiXB= new TableColumn("N??i xu???t b???n");
        colNoiXB.setCellValueFactory(new PropertyValueFactory("NoiXB"));
        
                TableColumn colNamXB= new TableColumn("N??m xu???t b???n");
        colNamXB.setCellValueFactory(new PropertyValueFactory("NamXB"));
        
                  TableColumn colMaDM= new TableColumn("M?? danh m???c");
        colMaDM.setCellValueFactory(new PropertyValueFactory("MaDanhMuc"));
        
                TableColumn colNgayNhap= new TableColumn("Ng??y nh???p");
        colNgayNhap.setCellValueFactory(new PropertyValueFactory("NgayNhap"));
        
                TableColumn colViTri= new TableColumn("V??? tr??");
        colViTri.setCellValueFactory(new PropertyValueFactory("ViTri"));
                
           this.tbSach.getColumns().addAll(colMa,colTen,colTacGia,colMoTa,colNoiXB,colNamXB,colMaDM,colNgayNhap,colViTri);
                
    }
}
