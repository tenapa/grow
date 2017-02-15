package com.epam.pryndate.grow.xml.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

/**
 * @author Tetiana_Prynda
 *         Created on 2/15/2017.
 */
public class JAXBUnmarshallRunner {
    public static void main(String[] args) throws JAXBException {
        final InputStream stream = JAXBUnmarshallRunner.class.getResourceAsStream("/xml/notes.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Notes.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Object notes = jaxbUnmarshaller.unmarshal(stream);
        System.out.println(notes.getClass());
        System.out.println(notes);
    }
}
