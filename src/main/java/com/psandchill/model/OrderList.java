package com.psandchill.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "allOrders")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderList {

    @XmlElement(name = "shiporder")
    private List<Shiporder> shiporders = null;

    public List<Shiporder> getShiporders() {
        return shiporders;
    }

    public void setShiporders(List<Shiporder> shiporders) {
        this.shiporders = shiporders;
    }
}
