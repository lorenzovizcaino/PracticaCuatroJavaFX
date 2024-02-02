package com.example.practicacuatrojavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerSecundarioMostrarV2 implements Initializable {

    @FXML
    private TableColumn<?, ?> colHoras;

    @FXML
    private TableColumn<?, ?> colModulo;



    @FXML
    private AnchorPane raiz;

    @FXML
    private TableView<Modulo> tblModulos;

    @FXML
    private TextField tfNombreApellidos;
    private ObservableList<Modulo> modulosOb;
    private ArrayList<Modulo> modulos=new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //modulosOb= FXCollections.observableArrayList();

        colModulo.setCellValueFactory(new PropertyValueFactory("nombre"));
        colHoras.setCellValueFactory(new PropertyValueFactory("horas"));
    }

    public void RecibirDatos(Alumno alumno){

        try {






            FXMLLoader loader = new FXMLLoader(Application.class.getResource("VentanaMostrarv2.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Datos matricula alumnado");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            modulosOb= FXCollections.observableArrayList();
            tblModulos=new TableView<>(modulosOb);


            System.out.println(alumno);
            tfNombreApellidos=new TextField(alumno.getNombre()+" "+alumno.getApellidos());
            tfNombreApellidos.setText(alumno.getNombre()+" "+alumno.getApellidos());
            System.out.println("NOMBRE: "+tfNombreApellidos.getText());
            modulos=alumno.getModulos();
            for (Modulo m:modulos) {
                modulosOb.add(m);
                tblModulos.setItems(modulosOb);
            }
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}

