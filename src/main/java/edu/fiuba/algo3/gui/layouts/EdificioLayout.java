package edu.fiuba.algo3.gui.layouts;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.gui.scenes.CiudadScene;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

import static java.awt.Color.BLACK;


public class EdificioLayout extends VBox {
    public EdificioLayout(Stage window, App app, AlgoThief algoThief,String ubicacionArchivo, String pista) {
        ImageView foto = new ImageView();
        try {
            FileInputStream fileInputStream = new FileInputStream(ubicacionArchivo);
            Image image = new Image(fileInputStream);
            //Setting the image view
            foto = new ImageView(image);
            //Setting the position of the image
            foto.setX(200);
            foto.setY(100);
            //setting the fit height and width of the image view
            foto.setFitHeight(1100);
            foto.setFitWidth(720);
            //Setting the preserve ratio of the image view
            foto.setPreserveRatio(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Text pistaLabel = new Text(pista);


        Button botonSalir= new Button("Volver");
        botonSalir.setMinSize(40,40);
        botonSalir.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        botonSalir.setOnAction(e-> {
            CiudadLayout ciudadLayout = new CiudadLayout(window, app, algoThief);
            CiudadScene ciudadScene = new CiudadScene(window, ciudadLayout, algoThief);
            window.setScene(ciudadScene);
        });

        HBox cerrar = new HBox(botonSalir);
        //setBackground(new Background(new BackgroundImage()));
        cerrar.setLayoutX(200);
        getChildren().addAll(cerrar,pistaLabel,foto);
    }
}
