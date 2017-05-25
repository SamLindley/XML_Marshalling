package com.psandchill.services;

import com.psandchill.model.ShiporderList;
import com.psandchill.model.Shiporder;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ShiporderService {

    private ObjectFactory orderFactory = new ObjectFactory();

    public ShiporderList generateSomeOrders(){
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

        ShiporderList orderList = new ShiporderList();
        orderList.addShiporders(shiporder1, shiporder2);
        return orderList;
    }

    public void printItemsToConsole(Shiporder shiporder){
        int i = 1;
        for (Shiporder.Item item :
                shiporder.getItem()) {
            System.out.printf("Item %s: %s\n", i++, item.getTitle());
        }
    }

}
