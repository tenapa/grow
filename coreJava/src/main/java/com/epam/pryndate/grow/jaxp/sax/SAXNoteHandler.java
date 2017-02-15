package com.epam.pryndate.grow.jaxp.sax;

import com.epam.pryndate.grow.jaxp.Note;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @author Tetiana_Prynda
 *         Created on 2/14/2017.
 */
public class SAXNoteHandler extends DefaultHandler {


    private Note currentNote;
    private Note.Item currentItem;
    private String currentStringValue;
    private Collection<Note> notes;
    private Collection<Note.Item> currentItems;

    public Collection<Note> getNotes() {
        return notes;
    }

    @Override
    public void startDocument() throws SAXException {
        notes = new LinkedList<>();
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (Note.NOTE_ELEM.equalsIgnoreCase(qName)) {
            currentNote = new Note();
            currentNote.setAuthor(attributes.getValue(Note.AUTHOR_ATTR));
            currentNote.setPriority(attributes.getValue(Note.PRIORITY_ATTR));
            currentNote.setExpire(Integer.valueOf(attributes.getValue(Note.EXPIRE_ATTR)));
        } else if (Note.CONTENTS_ELEM.equalsIgnoreCase(qName)) {
            currentItems = new LinkedList<>();
        } else if (Note.Item.ITEM_ELEM.equalsIgnoreCase(qName)) {
            currentItem = new Note.Item();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (Note.TITLE_ELEM.equalsIgnoreCase(qName)) {
            currentNote.setTitle(currentStringValue);
        } else if (Note.NOTE_ELEM.equalsIgnoreCase(qName)) {
            notes.add(currentNote);
        } else if (Note.CONTENTS_ELEM.equalsIgnoreCase(qName)) {
            currentNote.setContents(currentItems);
        } else if (Note.Item.ITEM_ELEM.equalsIgnoreCase(qName)) {
            currentItems.add(currentItem);
        } else if (Note.Item.NAME_ELEM.equalsIgnoreCase(qName)) {
            currentItem.setName(currentStringValue);
        } else if (Note.Item.QTY_ELEM.equalsIgnoreCase(qName)) {
            currentItem.setQuantity(Integer.parseInt(currentStringValue));
        } else if (Note.Item.MEASURE_ELEM.equalsIgnoreCase(qName)) {
            currentItem.setMeasure(currentStringValue);
        } else if (Note.Item.DESCRIPTION_ELEM.equalsIgnoreCase(qName)) {
            currentItem.setDescription(currentStringValue);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        final String stringValue = String.valueOf(ch, start, length);
        if (!stringValue.isEmpty()) {
            currentStringValue = stringValue;
        }
    }
}
