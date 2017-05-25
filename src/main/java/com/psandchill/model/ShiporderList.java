package com.psandchill.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 *
 *       WRAPPER CLASS
 *
 *       I made this so that it was possible to create a single XML
 *       file that contained all orders, rather than a separate one for each order
 *
 *       All orders are now enclosed by the tag <allOrders>
 *
 *       I thought it would be useful when marshalling multiple orders
 *
 */

@XmlRootElement(name = "allOrders")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShiporderList {

    @XmlElement(name = "shiporder")
    private List<Shiporder> shiporders = new ArrayList<>();

    public ShiporderList() {
    }

    public ShiporderList(List<Shiporder> shiporders) {
        this.shiporders = shiporders;
    }

    public List<Shiporder> getShiporders() {
        return shiporders;
    }

    public void setShiporders(List<Shiporder> shiporders) {
        this.shiporders = shiporders;
    }

    public void addShiporders(Shiporder... shiporders) {
        Collections.addAll(this.shiporders, shiporders);
    }
}
