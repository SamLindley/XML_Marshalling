package com.psandchill.program;

import com.psandchill.model.ShiporderList;
import com.psandchill.model.Shiporder;
import com.psandchill.services.ShiporderService;
import com.psandchill.services.XMLService;

public class Program {

    private final XMLService xmlService = new XMLService();
    private final ShiporderService shiporderService = new ShiporderService();

    public void run() {

        //Create Shiporder Objects
        ShiporderList orders = shiporderService.generateSomeOrders();

        //Marshall them to XML
        xmlService.marshalOrdersToXML(orders, null);

        //Unmarshal Shiporder object from XML
        Shiporder newOrder = xmlService.unmarshalOrderFromXML("shiporder.xml");

        //Print confirmation
        shiporderService.printItemsToConsole(newOrder);
    }

}
