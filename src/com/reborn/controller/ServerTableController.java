package com.reborn.controller;

import com.reborn.Main;
import com.reborn.model.Person;
import com.reborn.model.Server;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

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
    //连接主应用
    private Main main;
    private TextArea ta;

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

        // 给serverTable添加事件监听
        serverTable.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> connectVmess(newValue)));
    }

    private void connectVmess(Server newValue) {
        /*String cmd = System.getProperty("user.dir")+ File
                .separator+"Test"+File.separator+"v2ray.exe -config="+System
                .getProperty("user.dir")+ File
                .separator+"Test"+File.separator+"config.json";*/
        String cmd = System.getProperty("user.dir")+ File
                .separator+"Test"+File.separator+"v2ray.exe";
//        System.out.println(System.getProperty("user.dir"));
        System.out.println(cmd);
        Runtime run = Runtime.getRuntime();
        try {
            Process p = run.exec(cmd);// 启动另一个进程来执行命令
            BufferedInputStream in = new BufferedInputStream(p.getInputStream());
            BufferedReader inBr = new BufferedReader(new InputStreamReader
                    (in, "utf-8"));
            String lineStr;
            while (true) {
                lineStr = inBr.readLine();
                if (lineStr != null) {
                    System.out.println(lineStr);
                    ta.appendText(lineStr);
                }

                //检查命令是否执行失败。
                if (p.waitFor() != 0) {
                    if (p.exitValue() == 1){//p.exitValue()==0表示正常结束，1：非正常结束
                        System.err.println("命令执行失败!");
                    }
                } /*else {
                    inBr.close();
                    in.close();
                    p.destroy();
                }*/
            }
//            while ((lineStr = inBr.readLine()) != null)
//                //获得命令执行后在控制台的输出信息
//                System.out.println(lineStr);// 打印输出信息
//                ta.appendText(lineStr);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setMain(Main main) {
        this.main = main;
        serverTable.setItems(main.getServersData());
    }

    public void setTextArea(TextArea ta) {
        this.ta = ta;
    }
}
