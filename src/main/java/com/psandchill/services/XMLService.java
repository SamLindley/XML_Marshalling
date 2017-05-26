package com.psandchill.services;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLService {

    private JAXBContext jaxbContext;

    public Marshaller getFormattedMarshaller(Class c){
        try {
            jaxbContext = JAXBContext.newInstance(c);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            return marshaller;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Unmarshaller getUnmarshaller(Class c){
        try {
            jaxbContext = JAXBContext.newInstance(c);
            return  jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
