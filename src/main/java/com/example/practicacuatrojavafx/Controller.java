package com.example.practicacuatrojavafx;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button btCancelar;

    @FXML
    private Button btGuardar;

    @FXML
    private Button btSalir;

    @FXML
    private CheckBox chAD;

    @FXML
    private CheckBox chBD;

    @FXML
    private CheckBox chDI;

    @FXML
    private CheckBox chPMDM;

    @FXML
    private CheckBox chPROG;

    @FXML
    private CheckBox chPSP;

    @FXML
    private TitledPane panelDesplegable;

    @FXML
    private TextField tfApellidos;

    @FXML
    private TextField tfCodigoPostal;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNif;

    @FXML
    private TextField tfNombre;

    private ObservableList<CheckBox> listaDeCheckBoxes;
    private final int LIMITE_HORAS = 600;
    private int horas = 0;
    private ControllerSecundarioMostrarV2 controler;



    @FXML
    void Cancelar(ActionEvent event) {

    }


//Este metodo es la primera parte del ejercicio
//    @FXML
//    void Guardar(ActionEvent event) {
//
//        String nombre;
//        String apellidos;
//        String nif;
//        String codigoPostal;
//        String email;
//        ArrayList<Modulo> modulos = new ArrayList<>();
//        Modulo modulo;
//        Alumno alumno;
//
//        nombre = tfNombre.getText();
//        apellidos = tfApellidos.getText();
//        nif = tfNif.getText();
//        codigoPostal = tfCodigoPostal.getText();
//        email = tfEmail.getText();
//
//
//        horas = 0;
//        modulos = checkBoxesSelecionados();
//        if (horas > LIMITE_HORAS) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Informacion");
//            alert.setHeaderText(null);
//            alert.setContentText("Horas Excedidas");
//            alert.showAndWait();
//
//        } else {
//            alumno = new Alumno(nombre, apellidos, nif, codigoPostal, email, modulos);
//
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Info del alumno Guardado");
//            alert.setHeaderText(null);
//            alert.setContentText(alumno.toString());
//            alert.showAndWait();
//        }
//
//
//    }


//METODO GUARDAR QUE LLAMA AL CONTROLER SECUNDARIO CON EL BOTON DE MOSTRAR DATOS

//    @FXML
//    void Guardar(ActionEvent event) {
//
//        String nombre;
//        String apellidos;
//        String nif;
//        String codigoPostal;
//        String email;
//        ArrayList<Modulo> modulos = new ArrayList<>();
//        Modulo modulo;
//        Alumno alumno;
//
//        nombre = tfNombre.getText();
//        apellidos = tfApellidos.getText();
//        nif = tfNif.getText();
//        codigoPostal = tfCodigoPostal.getText();
//        email = tfEmail.getText();
//
//
//        horas = 0;
//        modulos = checkBoxesSelecionados();
//        if (horas > LIMITE_HORAS) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Informacion");
//            alert.setHeaderText(null);
//            alert.setContentText("Horas Excedidas");
//            alert.showAndWait();
//
//        } else {
//            alumno = new Alumno(nombre, apellidos, nif, codigoPostal, email, modulos);
//            btCancelar.setDisable(true);
//            try {
//                // Cargo la vista
//                FXMLLoader loader = new FXMLLoader(Application.class.getResource("VentanaMostrar.fxml"));
//                // Cargo la ventana
//                Parent root = loader.load();
//                Stage stage = new Stage();
//                // Estamos pasando el alumno a la instancia del stage
//                stage.setUserData(alumno);
//                // Creo el Scene
//                Scene scene = new Scene(root);
//
//                stage.setTitle("Datos matricula alumnado");
//                stage.initModality(Modality.APPLICATION_MODAL);
//                stage.setScene(scene);
//                stage.showAndWait();
//            } catch (IOException e) {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setHeaderText(null);
//                alert.setTitle("Error");
//                alert.setContentText(e.getMessage());
//                System.out.println(e.getMessage().toString());
//                alert.showAndWait();
//            }
//
//
//        }
//
//
//
//
//    }




    //Metodo Guardar que intenta mostrar los datos directamente sin usar el boton de mostrar datos
    @FXML
    void Guardar(ActionEvent event) {
        String nombre;
        String apellidos;
        String nif;
        String codigoPostal;
        String email;
        ArrayList<Modulo> modulos = new ArrayList<>();
        Modulo modulo;
        Alumno alumno;

        nombre = tfNombre.getText();
        apellidos = tfApellidos.getText();
        nif = tfNif.getText();
        codigoPostal = tfCodigoPostal.getText();
        email = tfEmail.getText();


        horas = 0;
        modulos = checkBoxesSelecionados();
        if (horas > LIMITE_HORAS) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Informacion");
            alert.setHeaderText(null);
            alert.setContentText("Horas Excedidas");
            alert.showAndWait();

        } else {
            alumno = new Alumno(nombre, apellidos, nif, codigoPostal, email, modulos);
            controler=new ControllerSecundarioMostrarV2();
            controler.RecibirDatos(alumno);


        }

    }

    private ArrayList<Modulo> checkBoxesSelecionados() {
        ArrayList<Modulo> modulos = new ArrayList<>();
        Modulo modulo;
        horas = 0;

        for (CheckBox checkBox : listaDeCheckBoxes) {

            if (checkBox.isSelected()) {
                modulo = new Modulo(checkBox.getText(), (Integer) checkBox.getUserData());
                modulos.add(modulo);
                horas += (Integer) checkBox.getUserData();

            }
        }
        return modulos;
    }

    @FXML
    void PSPMarcado(ActionEvent event) {
        //chPSP.moni
    }

    @FXML
    void Salir(ActionEvent event) {
        System.exit(0);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        chAD=new CheckBox();
//        chPROG=new CheckBox();
//        chBD=new CheckBox();
//        chDI=new CheckBox();
//        chPMDM=new CheckBox();
//        chPSP=new CheckBox();

        chAD.setUserData(157);
        chPROG.setUserData(240);
        chBD.setUserData(187);
        chDI.setUserData(140);
        chPMDM.setUserData(123);
        chPSP.setUserData(70);

        listaDeCheckBoxes = FXCollections.observableArrayList();

        //esto preguntar
        listaDeCheckBoxes.addListener(new ListChangeListener<CheckBox>() {
            @Override
            public void onChanged(Change<? extends CheckBox> change) {
                System.out.println(listaDeCheckBoxes);
            }
        });

        //hasta aqui

        listaDeCheckBoxes.add(chAD);
        listaDeCheckBoxes.add(chPROG);
        listaDeCheckBoxes.add(chBD);
        listaDeCheckBoxes.add(chDI);
        listaDeCheckBoxes.add(chPMDM);
        listaDeCheckBoxes.add(chPSP);


        Tooltip tooltipAD = new Tooltip(chAD.getUserData().toString()+" horas");
        chAD.setTooltip(tooltipAD);
        Tooltip tooltipPROG = new Tooltip(chPROG.getUserData().toString()+" horas");
        chPROG.setTooltip(tooltipPROG);
        Tooltip tooltipBD = new Tooltip(chBD.getUserData().toString()+" horas");
        chBD.setTooltip(tooltipBD);
        Tooltip tooltipDI = new Tooltip(chDI.getUserData().toString()+" horas");
        chDI.setTooltip(tooltipDI);
        Tooltip tooltipPMDM = new Tooltip(chPMDM.getUserData().toString()+" horas");
        chPMDM.setTooltip(tooltipPMDM);
        Tooltip tooltipPSP = new Tooltip(chPSP.getUserData().toString()+" horas");
        chPSP.setTooltip(tooltipPSP);


    }
}
