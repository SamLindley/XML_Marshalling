package com.psandchill.program;

import com.psandchill.services.ConsolePrinter;
import com.psandchill.services.ObjectFactory;
import com.psandchill.model.OrderList;
import com.psandchill.model.Shiporder;
import com.psandchill.services.XMLPrinter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class Program {

    private ObjectFactory orderFactory = new ObjectFactory();
    private XMLPrinter printer = new ConsolePrinter();

    public void run() {
        ArrayList<Shiporder> orders = createSomeOrders();
        printer.printOrdersAsXML(orders);
        printer.printSomeKindOfSpace();
        printer.printXMLFileAsString("shiporder.xml");
    }

    private ArrayList<Shiporder> createSomeOrders() {
        Shiporder shiporder1 = orderFactory.createShiporder();
        Shiporder shiporder2 = orderFactory.createShiporder();



        shiporder1.setOrderid("1");
        shiporder1.setOrderperson("Sam");

        Shiporder.Shipto shipto1 = orderFactory.createShiporderShipto();
        shipto1.setAddress("$wagville");
        shipto1.setCity("City1");
        shipto1.setCountry("Happy Country");
        shipto1.setName("Sam");
        shiporder1.setShipto(shipto1);

        Shiporder.Item item1 = orderFactory.createShiporderItem();
        item1.setNote("Hello");
        item1.setPrice(new BigDecimal("100.50"));
        item1.setQuantity(new BigInteger("500"));
        item1.setTitle("Hello Again");
        shiporder1.getItem().add(item1);

        shiporder2.setOrderid("2");
        shiporder2.setOrderperson("Martina");

        Shiporder.Shipto shipto2 = orderFactory.createShiporderShipto();
        shipto2.setAddress("Happy Road");
        shipto2.setCity("Happy City");
        shipto2.setCountry("Happy Country");
        shipto2.setName("Martina");
        shiporder2.setShipto(shipto2);

        Shiporder.Item item2 = orderFactory.createShiporderItem();
        item2.setNote("Item 2");
        item2.setPrice(new BigDecimal("200.00"));
        item2.setQuantity(new BigInteger("500"));
        item2.setTitle("Hello Again");
        shiporder2.getItem().add(item2);

        Shiporder.Item item3 = orderFactory.createShiporderItem();
        item3.setNote("Item 3");
        item3.setPrice(new BigDecimal("300.50"));
        item3.setQuantity(new BigInteger("500"));
        item3.setTitle("Hello Again (Again)");
        shiporder2.getItem().add(item3);

        ArrayList<Shiporder> list = new ArrayList<>();
        list.add(shiporder1);
        list.add(shiporder2);
        return list;
    }


    private void createSomeOrdersV2(){
        Shiporder shiporder3 = orderFactory.createShiporder();

        shiporder3.setShipto(orderFactory.createShiporderShipto());
        shiporder3.getShipto().setCountry("Happy");
        shiporder3.getShipto().setAddress("Happy");
        shiporder3.getShipto().setCity("Happy");
        shiporder3.getShipto().setName("Happy");

        shiporder3.getItem().add(orderFactory.createShiporderItem());
        shiporder3.getItem().get(0).setTitle("Item 1");
        shiporder3.getItem().get(0).setQuantity(new BigInteger("10"));
        shiporder3.getItem().get(0).setPrice(new BigDecimal(99.99));

    }

}
