package com.psandchill;

import com.psandchill.model.ShiporderList;
import com.psandchill.model.Shiporder;
import com.psandchill.services.ShiporderService;
import com.psandchill.services.ShiporderXMLService;

public class Program {

    private final ShiporderService shiporderXMLService = new ShiporderXMLService();

    public void run() {

        //Create Shiporder Objects
        ShiporderList orders = shiporderXMLService.generateTestOrders();

        //Marshal them to XML
        shiporderXMLService.persistOrders(orders);

        //Unmarshal Shiporder object from XML
        Shiporder newOrder = shiporderXMLService.getOrder("shiporder.xml");

        //Print confirmation
        printItemsToConsole(newOrder);
    }

    public void printItemsToConsole(Shiporder shiporder) {
        int i = 1;
        for (Shiporder.Item item :
                shiporder.getItem()) {
            System.out.printf("Item %s: %s\n", i++, item.getTitle());
        }
    }

}
