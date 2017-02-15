package com.epam.pryndate.grow.jaxp.dom;

import com.epam.pryndate.grow.jaxp.Note;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @author Tetiana_Prynda
 *         Created on 2/15/2017.
 */
public class DOMParseHelper {
    public Note parseNote(Element noteElement) {
        Note note = new Note();
        note.setAuthor(noteElement.getAttribute(Note.AUTHOR_ATTR));
        note.setPriority(noteElement.getAttribute(Note.PRIORITY_ATTR));
        note.setExpire(Integer.parseInt(noteElement.getAttribute(Note.EXPIRE_ATTR)));

        final NodeList title = noteElement.getElementsByTagName(Note.TITLE_ELEM);
        note.setTitle(title.item(0).getFirstChild().getNodeValue());

        final NodeList contents = noteElement.getElementsByTagName(Note.CONTENTS_ELEM);
        final Node contentNode = contents.item(0);
        Element content = (Element) contentNode;
        Collection<Note.Item> noteContents = new LinkedList<>();
        final NodeList items = content.getElementsByTagName(Note.Item.ITEM_ELEM);
        for (int j = 0; j < items.getLength(); j++) {
            final Node itemNode = items.item(j);
            Element itemElement = (Element) itemNode;
            Note.Item item = new Note.Item();
            final Node nameNode = itemElement.getElementsByTagName(Note.Item.NAME_ELEM).item(0);
            final Node qtyNode = itemElement.getElementsByTagName(Note.Item.QTY_ELEM).item(0);
            final Node measureNode = itemElement.getElementsByTagName(Note.Item.MEASURE_ELEM).item(0);
            final Node descriptionNode = itemElement.getElementsByTagName(Note.Item.DESCRIPTION_ELEM).item(0);
            item.setName(nameNode == null? null: nameNode.getFirstChild().getNodeValue());
            item.setQuantity(qtyNode == null || qtyNode.getFirstChild().getNodeValue() == null ? null : Integer.parseInt(qtyNode.getFirstChild().getNodeValue()));
            item.setMeasure(measureNode == null? null : measureNode.getFirstChild().getNodeValue());
            item.setDescription(descriptionNode == null? null : descriptionNode.getFirstChild().getNodeValue());
            noteContents.add(item);
        }
        note.setContents(noteContents);
        return note;
    }
}
