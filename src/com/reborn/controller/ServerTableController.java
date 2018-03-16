package com.reborn.controller;

import com.reborn.model.Server;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ServerTableController {
    @FXML
    private TableView<Server> serverTable;
    @FXML
    private TableColumn<Server, String> flagColumn;
    @FXML
    private TableColumn<Server, String> nameColumn;
    @FXML
    private TableColumn<Server, String> remarkColumn;
    @FXML
    private TableColumn<Server, String> addressColumn;
    @FXML
    private TableColumn<Server, String> portColumn;
    @FXML
    private TableColumn<Server, String> securityColumn;
    @FXML
    private TableColumn<Server, String> delayColumn;

    public ServerTableController() {
    }

    @FXML
    public void initialize() {
        flagColumn.setCellValueFactory(cellData -> cellData.getValue()
                .flagProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue()
                .nameProperty());
        remarkColumn.setCellValueFactory(cellData -> cellData.getValue()
                .remarkProperty());
        addressColumn.setCellValueFactory(cellData -> cellData.getValue()
                .addressProperty());
        portColumn.setCellValueFactory(cellData -> cellData.getValue()
                .portProperty());
        securityColumn.setCellValueFactory(cellData -> cellData.getValue()
                .securityProperty());
        delayColumn.setCellValueFactory(cellData -> cellData.getValue()
                .delayProperty());
    }
}
