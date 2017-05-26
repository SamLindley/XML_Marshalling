package com.psandchill.services;

import com.psandchill.model.Shiporder;
import com.psandchill.model.ShiporderList;

public interface ShiporderService {
    Shiporder getOrder(String file);

    void persistOrder(ShiporderList orders);

    ShiporderList generateTestOrders();

    void printItemsToConsole(Shiporder shiporder);
}
