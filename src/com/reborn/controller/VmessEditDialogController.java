package com.reborn.controller;

import com.reborn.model.Vmess;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

public class VmessEditDialogController {
    @FXML
    private TextField addressField;
    @FXML
    private TextField portField;
    @FXML
    private TextField uuidField;
    @FXML
    private TextField alterIdField;
    @FXML
    private ComboBox securityBox;
    @FXML
    private TextField networkField;
    @FXML
    private TextField remarkField;

    private Stage dialogStage;
    private Vmess vmess;
    private boolean okClicked = false;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setVmess(Vmess vmess) {
        this.vmess = vmess;

    }

    @FXML
    private void initialize() {
        securityBox.getItems().addAll(
                "aes-128-cfb",
                "aes-128-cfb"
//                "ethan.williams@example.com",
//                "emma.jones@example.com",
//                "michael.brown@example.com"
        );
    }

    @FXML
    private void handleFileOpen() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "JSON files (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter);

        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(this.dialogStage);
//        System.out.println(file.getAbsoluteFile());
        try {
            JSONObject json = getJson(file);
            //填充vmess
            /*
            * 填充的内容有address, port, UUID, alterID,security, network(传输协议), remark
            * */
            vmess.setName("vmess");
            System.out.println(json.getJSONObject("settings").getJSONArray
                    ("vnext").getJSONObject(0).getString("address"));
            vmess.setAddress(json.getJSONObject("settings").getJSONArray
                    ("vnext").getJSONObject(0).getString("address"));
            vmess.setPort(Integer.toString(json.getJSONObject("settings")
                    .getJSONArray("vnext").getJSONObject(0).getInt("port")));
            vmess.setUuid(json.getJSONObject("settings").getJSONArray
                    ("vnext").getJSONObject(0).getJSONArray("users")
                    .getJSONObject(0).getString("id"));
            vmess.setAlterid(Integer.toString(json.getJSONObject("settings").getJSONArray
                    ("vnext").getJSONObject(0).getJSONArray("users")
                    .getJSONObject(0).getInt("alterId")));
            vmess.setSecurity(json.getJSONObject("settings").getJSONArray
                    ("vnext").getJSONObject(0).getJSONArray("users")
                    .getJSONObject(0).getString("security"));
            vmess.setNetwork("tcp");
            vmess.setRemark("vpn");

            fileBlank(vmess);

        } catch (IOException e) {
            System.out.println("can not get json file");
            e.printStackTrace();
        }
    }

    private JSONObject getJson(File file) throws IOException {
        String content= FileUtils.readFileToString(file,"UTF-8");
        JSONObject jsonObject=new JSONObject(content);
//        return jsonObject;
        return jsonObject.getJSONObject("outbound");
    }

    private void fileBlank(Vmess vmess) {
        addressField.setText(vmess.getAddress());
        portField.setText(vmess.getPort());
        uuidField.setText(vmess.getUuid());
        alterIdField.setText(vmess.getAlterid());
        networkField.setText(vmess.getNetwork());
        securityBox.setValue(vmess.getSecurity());
    }

    @FXML
    private void handleOk() {
//        if (inputValid()) {
//            person.setFirstName(firstNameField.getText());
//            person.setLastName(lastNameField.getText());
//            person.setStreet(streetField.getText());
//            person.setPostalCode(Integer.parseInt(postalCodeField.getText()));
//            person.setCity(cityField.getText());
//            person.setBirthday(DateUtil.parse(birthdayField.getText()));

//            okClicked = true;
//            dialogStage.close();
//        }
        // 暂无验证功能
        //ToDO: 后续需要增加验证输入内容是否合法
        if (vmess != null) {
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    public boolean isOkClicked() {return okClicked;}
}
