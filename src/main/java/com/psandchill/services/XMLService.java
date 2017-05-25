package com.psandchill.services;

import com.psandchill.model.ShiporderList;
import com.psandchill.model.Shiporder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLService {

    public Shiporder unmarshalOrderFromXML(String file){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Shiporder.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            System.out.println("Created object -");
            return  (Shiporder) unmarshaller.unmarshal(new File(file));

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void marshalOrdersToXML(ShiporderList orders, File location){

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ShiporderList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            if (location==null){
                System.out.println("No file specified as location to marshal to.\nPrinting XML output of - "
                        + orders.toString() + " - to console:\n");
                marshaller.marshal(orders, System.out);
            }else
                marshaller.marshal(orders, location);


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
