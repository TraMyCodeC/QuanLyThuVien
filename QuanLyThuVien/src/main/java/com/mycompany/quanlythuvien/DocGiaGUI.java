package com.mycompany.quanlythuvien;

import com.mycompany.Pojo.DocGia;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DocGiaGUI {
    @FXML private Button btnLogout;
    @FXML private Button btnTraCuu;
    @FXML private Button btnTheDG;
      private Stage stage;
      private Scene scene;
      private Parent root;
      private static DocGia docGia=null;
   @FXML
    private void switchToPrimary(ActionEvent event) throws IOException {
         root=FXMLLoader.load(getClass().getResource("primary.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
    }
    @FXML
    private void switchToSecondary(ActionEvent event) throws IOException {
         root=FXMLLoader.load(getClass().getResource("secondary.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root,721,403);
                stage.setScene(scene);
                stage.show(); 
    }
    @FXML
    private void switchToTraCuuSach(ActionEvent event) throws IOException {
         root=FXMLLoader.load(getClass().getResource("TraCuuSach.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root,942,633);
                stage.setScene(scene);
                stage.show(); 
    }
    public static void inIt(DocGia dg)
    {
        docGia=dg; 
        
    }
    public static DocGia getDocGia()
    {
        return docGia;
    }
}