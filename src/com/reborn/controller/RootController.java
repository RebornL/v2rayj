package com.reborn.controller;

import com.reborn.Main;
import com.reborn.model.Vmess;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import java.io.File;

public class RootController {
    private Main main;

    /*@FXML
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
    }*/

    @FXML
    private void handleOpenVmessEditDialog() {
        Vmess tempVmess = new Vmess();
        boolean okClicked = main.showVmessEditDialog(tempVmess);
        if (okClicked) {
            //add the new person into table
            main.getServersData().add(tempVmess);
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
