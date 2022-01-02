package com.mycompany.quanlythuvien;

import com.mycompany.Pojo.DocGia;
import com.mycompany.Services.DocGiaSerVices;
import com.mycompany.config.Ultils;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController{
      @FXML private TextField txtName;
      @FXML private TextField txtPass;
      @FXML private Button btnDocGia;
      @FXML private Button btnNhanVien;
//      static int m=0;
      static int result;
      static DocGia doc;
      private Stage stage;
      private Scene scene;
      private Parent root;
      DocGiaSerVices dg=new DocGiaSerVices();
    @FXML
    public void LoginNhanVien(ActionEvent event) throws IOException, SQLException
    {
        ktra();
        if(result==1)
        {
            doc=dg.kTraNhanVienAccount(txtName.getText(),txtPass.getText());
            if(doc!=null)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText("Login sucess");
                alert.showAndWait();
                 root=FXMLLoader.load(getClass().getResource("NhanVienGui.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root,529,374);
                stage.setScene(scene);
                stage.setTitle("NhanVienGUI");
                stage.show();
                
                //App.setRoot("NhanVienGUI");   
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText("Login failed.Login failed.Wrong username or password");
                alert.showAndWait();
            }
       } 
          result=0;
    }
    @FXML
    public void DocGiaLogin(ActionEvent event) throws IOException, SQLException {
        ktra();
        if(result==1)
            {   
              doc=dg.kTraDocGiaAccount(txtName.getText(),txtPass.getText());
            if(doc!=null)
            {
                DocGiaGUI.inIt(doc);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Message");
                alert.setHeaderText("Login sucess");
                alert.showAndWait();
                  root=FXMLLoader.load(getClass().getResource("DocGiaGUI.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root,600,400);
                stage.setScene(scene);
                stage.setTitle("DocGiaGUI");
                stage.show();
             //App.setRoot("secondary");
            }
            else
            {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Message");
          alert.setHeaderText("Login failed.Wrong username or password");
          alert.showAndWait();
            }
            
        }
         result=0;
        
    }
    public void ktra()
    {
       
         result=Ultils.ktraUserPass(txtName.getText(),txtPass.getText());
        if (result==0)
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Message");
          alert.setHeaderText("Please enter your name and password");
          alert.showAndWait();
        }
    }
   
}
    
