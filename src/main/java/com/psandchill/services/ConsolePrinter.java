package com.psandchill.services;

import com.psandchill.model.OrderList;
import com.psandchill.model.Shiporder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

public class ConsolePrinter implements XMLPrinter {

    @Override
    public void printXMLFileAsString(String file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Shiporder.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Shiporder shiporder = (Shiporder) unmarshaller.unmarshal(new File(file));
            printOrderInfo(shiporder);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }



    @Override
    public void printOrdersAsXML(ArrayList<Shiporder> orders) {
        try {
            OrderList wrappedOrders = new OrderList();
            wrappedOrders.setShiporders(orders);
            JAXBContext jaxbContext = JAXBContext.newInstance(OrderList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(wrappedOrders, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void printSomeKindOfSpace() {
        System.out.println("\n--------------------------------------------------------------------------");
    }

    private void printOrderInfo(Shiporder shiporder) {
        System.out.printf("\nDetails of order: \nName: %s\nCity: %s\n",
                shiporder.getOrderperson(), shiporder.getShipto().getCity());
    }

}
