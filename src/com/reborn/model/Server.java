package com.reborn.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Server {
    private final StringProperty flag;
    private final StringProperty name;
    private final StringProperty remark;
    private final StringProperty address;
    private final StringProperty security;
    private final StringProperty port;
    private final StringProperty delay;

    public Server() {
        this.flag = new SimpleStringProperty(" ");
        this.name = new SimpleStringProperty(" ");
        this.remark = new SimpleStringProperty(" ");
        this.address = new SimpleStringProperty(" ");
        this.security = new SimpleStringProperty(" ");
        this.port = new SimpleStringProperty(" ");
        this.delay = new SimpleStringProperty(" ");
    }

    public Server(String flag, String name, String remark, String address,
                 String security,String port, String delay) {
        this.flag = new SimpleStringProperty(flag);
        this.name = new SimpleStringProperty(name);
        this.remark = new SimpleStringProperty(remark);
        this.address = new SimpleStringProperty(address);
        this.security = new SimpleStringProperty(security);
        this.port = new SimpleStringProperty(port);
        this.delay = new SimpleStringProperty(delay);
    }

    public String getPort() {
        return port.get();
    }

    public StringProperty portProperty() {
        return port;
    }

    public void setPort(String port) {
        this.port.set(port);
    }

    public String getFlag() {
        return flag.get();
    }

    public StringProperty flagProperty() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag.set(flag);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getRemark() {
        return remark.get();
    }

    public StringProperty remarkProperty() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark.set(remark);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getSecurity() {
        return security.get();
    }

    public StringProperty securityProperty() {
        return security;
    }

    public void setSecurity(String security) {
        this.security.set(security);
    }

    public String getDelay() {
        return delay.get();
    }

    public StringProperty delayProperty() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay.set(delay);
    }
}
