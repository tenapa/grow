package com.epam.pryndate.grow.jaxp.sax;

import com.epam.pryndate.grow.jaxp.dom.DOMParseRunner;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Tetiana_Prynda
 *         Created on 2/14/2017.
 */
public class SAXParseRunner {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        final SAXParser parser = factory.newSAXParser();
        InputStream resourceAsStream = DOMParseRunner.class.getResourceAsStream("/xml/notes.xml");
        final SAXNoteHandler noteHandler = new SAXNoteHandler();
        parser.parse(resourceAsStream, noteHandler);

        System.out.println(noteHandler.getNotes());

    }
}
