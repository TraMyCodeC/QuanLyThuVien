/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlythuvien;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author My
 */
public class NHanVienGUIController implements Initializable {
       @FXML private Button btnLogout;
       @FXML private Button btnMuonSach;
       @FXML private Button btnTraSach;
       private Stage stage;
      private Scene scene;
      private Parent root;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
    }
    @FXML
    public void loggOut(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("primary.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                 stage.setResizable(false);
                stage.show();
    } 
    @FXML
    public void switchToMuonSach(ActionEvent event) throws IOException
    {
         root=FXMLLoader.load(getClass().getResource("MuonSachGUI.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                 stage.setResizable(false);
                stage.show();
    }
     @FXML
    public void switchToTraSach(ActionEvent event) throws IOException
    {
         root=FXMLLoader.load(getClass().getResource("TraSach.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                 stage.setResizable(false);
                stage.show();
    }
    
}
