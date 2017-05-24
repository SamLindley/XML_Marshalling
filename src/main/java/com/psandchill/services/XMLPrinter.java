package com.psandchill.services;

import com.psandchill.model.Shiporder;

import java.util.ArrayList;

public interface XMLPrinter {
    void printXMLFileAsString(String file);

    void printOrdersAsXML(ArrayList<Shiporder> orders);

    void printSomeKindOfSpace();
}
