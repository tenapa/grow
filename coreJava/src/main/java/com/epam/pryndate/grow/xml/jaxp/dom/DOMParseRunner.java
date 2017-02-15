package com.epam.pryndate.grow.xml.jaxp.dom;

import com.epam.pryndate.grow.xml.jaxp.Note;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;

/**
 * @author Tetiana_Prynda
 *         Created on 2/14/2017.
 */
public class DOMParseRunner {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream resourceAsStream = DOMParseRunner.class.getResourceAsStream("/xml/notes.xml");
        Document document = builder.parse(resourceAsStream);
        document.normalize();

        final Element rootElem = document.getDocumentElement();
        final NamedNodeMap rootAttributes = rootElem.getAttributes();
        System.out.println("Working with root of " + rootElem.getTagName() + " with attributes " + rootAttributes.toString());

        DOMParseHelper parseHelper = new DOMParseHelper();
        Collection<Note> notes = new LinkedList<>();
        final NodeList noteNodes = rootElem.getElementsByTagName("note");
        for (int i = 0; i < noteNodes.getLength(); i++) {
            final Node noteItem = noteNodes.item(i);
            Element noteElement = (Element) noteItem;
            Note note = parseHelper.parseNote(noteElement);
            notes.add(note);
        }
        System.out.println(notes);
    }
}
