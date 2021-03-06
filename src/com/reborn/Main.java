package com.reborn;

import com.reborn.controller.*;
import com.reborn.model.Person;
import com.reborn.model.Server;
import com.reborn.model.Vmess;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
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
    private ObservableList<Server> serversData = FXCollections
            .observableArrayList();

    private TextArea textArea;



    @Override
    public void start(Stage primaryStage) throws Exception{
        //add some person data
/*
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Muster"));
        personData.add(new Person("Heiz", "Muster"));
        personData.add(new Person("cornalie", "Muster"));
        personData.add(new Person("Werer", "Muster"));
        personData.add(new Person("Lydia", "Muster"));
        personData.add(new Person("Anna", "Muster"));
        personData.add(new Person("Stefan", "Muster"));
        personData.add(new Person("Martin", "Muster"));
*/
        serversData.add(new Vmess(" ","vmess", "vpn", "112.11.22.11",
                "aes-128-gcm", "9999", " ", "asdas123212adasdas", "64",
                "tcp"));
        serversData.add(new Vmess(" ","vmess", "vpn", "112.11.22.11",
                "aes-128-gcm", "9999", " ", "asdas123212adasdas", "64",
                "tcp"));
        serversData.add(new Vmess(" ","vmess", "vpn", "112.11.22.11",
                "aes-128-gcm", "9999", " ", "asdas123212adasdas", "64",
                "tcp"));
        serversData.add(new Vmess(" ","vmess", "vpn", "112.11.22.11",
                "aes-128-gcm", "9999", " ", "asdas123212adasdas", "64",
                "tcp"));


        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("v2rayJ");
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream(
                "../../resources/V2.png")));

        initRootLayout();
        showServerTable();
        showTerminalMessageBox();
//        showVmessEditDialog();
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
            RootController controller = loader.getController();
            controller.setMain(this);

            // textarea初始化
            this.textArea = new TextArea();
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

            //set server overview into the center of root layout
            rootlayout.setCenter(ServerTable);

            ServerTableController controller = loader.getController();
            controller.setMain(this);
            controller.setTextArea(this.getTextArea());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showTerminalMessageBox() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/TerminalMessageBox" +
                ".fxml"));
        try {
            AnchorPane messageBox = (AnchorPane)loader.load();
            rootlayout.setRight(messageBox);

//            ServerTableController controller = loader.getController();
            TerminalMessageBoxController controller = loader.getController();
            controller.setTextArea(this.getTextArea());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showVmessEditDialog() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/VmessEditDialog" +
                    ".fxml"));
            BorderPane page = (BorderPane) loader.load();

            rootlayout.setRight(page);


            VmessEditDialogController controller = loader.getController();

            // Create the dialog Stage.
            /*Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Vmess");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);*/

            // Set the person into the controller.
            /*VmessEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setVmess(vmess);*/

            // Show the dialog and wait until the user closes it
            // dialogStage.showAndWait();

//            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
//            return false;
        }
    }

    public boolean showVmessEditDialog(Vmess vmess) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/VmessEditDialog" +
                    ".fxml"));
            BorderPane page = (BorderPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Vmess");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            VmessEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setVmess(vmess);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ObservableList<Server> getServerData() {
        return serversData;
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

    public ObservableList<Server> getServersData() {
        return serversData;
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
