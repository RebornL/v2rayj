package com.reborn;

import com.reborn.controller.PersonEditDialogController;
import com.reborn.controller.ServerTableController;
import com.reborn.model.Person;
import com.reborn.controller.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootlayout;

    private ObservableList<Person> personData = FXCollections
            .observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception{
        //add some person data
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Muster"));
        personData.add(new Person("Heiz", "Muster"));
        personData.add(new Person("cornalie", "Muster"));
        personData.add(new Person("Werer", "Muster"));
        personData.add(new Person("Lydia", "Muster"));
        personData.add(new Person("Anna", "Muster"));
        personData.add(new Person("Stefan", "Muster"));
        personData.add(new Person("Martin", "Muster"));


        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("v2rayJ");
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream(
                "../../resources/V2.png")));

        initRootLayout();
        showServerTable();
//        showPersonOverview();


        /*
        Parent root = FXMLLoader.load(getClass().getResource("rootlayout" +
                ".fxml"));
        primaryStage.setTitle("v2rayJ");
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream(
                "../../resources/V2.png")));
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
        */
    }

    private void initRootLayout() {

        try {
            //load root layout form fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootlayout = (BorderPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //show the scene containing the root layout
        primaryStage.setScene(new Scene(rootlayout));
        primaryStage.show();

        // Open the file
    }

    private void showServerTable() {
        try {
            //load person overview
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/ServerTable" +
                    ".fxml"));
            AnchorPane ServerTable = (AnchorPane)loader.load();

            //set person overview into the center of root layout
            rootlayout.setCenter(ServerTable);

//            ServerTableController controller = loader.getController();
//            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showPersonOverview() {
        try {
            //load person overview
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/PersonOverview" +
                    ".fxml"));
            AnchorPane personOverview = (AnchorPane)loader.load();

            //set person overview into the center of root layout
            rootlayout.setCenter(personOverview);

            PersonOverviewController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showPersonEditDialog(Person person) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
