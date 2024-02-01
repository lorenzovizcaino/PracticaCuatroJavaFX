package com.example.practicacuatrojavafx;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerSecundarioMostrar implements Initializable {

    @FXML
    public AnchorPane raiz;

    @FXML
    private Button btRecuperarDatos;

    @FXML
    private TableColumn<?, ?> colHoras;

    @FXML
    private TableColumn<?, ?> colModulo;

    @FXML
    private TableView<Modulo> tblModulos;

    @FXML
    private TextField tfNombreApellidos;
    Alumno alumno=new Alumno();
    private ObservableList<Modulo> modulosOb;
    private ArrayList<Modulo> modulos;



    @FXML
    void RecuperarDatos(ActionEvent event) {
        modulosOb.clear();
        Stage stage=(Stage)raiz.getScene().getWindow();
        alumno=(Alumno) stage.getUserData();
        tfNombreApellidos.setText(alumno.getNombre()+" "+alumno.getApellidos());
        modulos=alumno.getModulos();
        for (Modulo m:modulos) {
            modulosOb.add(m);
            tblModulos.setItems(modulosOb);
        }




    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modulosOb= FXCollections.observableArrayList();
        colModulo.setCellValueFactory(new PropertyValueFactory("nombre"));
        colHoras.setCellValueFactory(new PropertyValueFactory("horas"));




    }
}

