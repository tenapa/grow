package com.epam.pryndate.grow.xml.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author Tetiana_Prynda
 *         Created on 2/15/2017.
 */
public class JAXBMarshallRunner {
    public static void main(String[] args) throws JAXBException {

        Collection<Note> notes = createNotes();

        File file = new File("jaxb.xml");
        System.out.println(file.getAbsolutePath());
        JAXBContext jaxbContext = JAXBContext.newInstance(Notes.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(new Notes(notes), file);
        jaxbMarshaller.marshal(new Notes(notes), System.out);
    }

    private static Collection<Note> createNotes() {
        Note note = new Note();
        note.setTitle("First note");
        note.setExpire(10);
        note.setAuthor("Tyapa");
        note.setPriority("MEDIUM");

        Note.Item item1 = new Note.Item();
        item1.setName("Study jaxp");

        Note.Item item2 = new Note.Item();
        item2.setName("Eggs");
        item2.setQuantity(10);
        item2.setMeasure("items");
        note.setContents(new Note.Contents(Arrays.asList(item1, item2)));

        Note note2 = new Note();
        note2.setTitle("ToDo");
        note2.setExpire(10);
        note2.setAuthor("Tetiana");
        note2.setPriority("TOP");

        Note.Item item21 = new Note.Item();
        item21.setName("Iron dress");

        note2.setContents(new Note.Contents(Collections.singletonList(item21)));

        return Arrays.asList(note, note2);
    }
}
