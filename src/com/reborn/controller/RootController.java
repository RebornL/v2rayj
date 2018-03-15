package com.reborn.controller;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import java.io.File;

public class RootController {

    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
//        File file = fileChooser.showOpenDialog(main.getPrimaryStage());

//        if (file != null) {
////            main.loadPersonDataFromFile(file);
//        }
    }
}
