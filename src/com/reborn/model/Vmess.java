package com.reborn.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Vmess extends Server{
    //Vmess特有的
    private StringProperty uuid;
    private StringProperty alterid;
    private StringProperty network;


    public Vmess() {
        super();
        uuid = new SimpleStringProperty(" ");
        alterid = new SimpleStringProperty(" ");
        network = new SimpleStringProperty(" ");
    }

    public Vmess(String flag, String name, String remark, String address,
                 String security,String port, String delay, String uuid,
                 String alterid,
                 String network) {
        super(flag, name, remark, address, security,port, delay);
        this.uuid = new SimpleStringProperty(uuid);
        this.alterid = new SimpleStringProperty(alterid);
        this.network = new SimpleStringProperty(network);
    }

    public String getUuid() {
        return uuid.get();
    }

    public StringProperty uuidProperty() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid.set(uuid);
    }

    public String getAlterid() {
        return alterid.get();
    }

    public StringProperty alteridProperty() {
        return alterid;
    }

    public void setAlterid(String alterid) {
        this.alterid.set(alterid);
    }

    public String getNetwork() {
        return network.get();
    }

    public StringProperty networkProperty() {
        return network;
    }

    public void setNetwork(String network) {
        this.network.set(network);
    }
}
