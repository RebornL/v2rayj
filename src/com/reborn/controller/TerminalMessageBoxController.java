package com.reborn.controller;

import com.reborn.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class TerminalMessageBoxController {

    @FXML
    private TextArea textArea;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }
}
