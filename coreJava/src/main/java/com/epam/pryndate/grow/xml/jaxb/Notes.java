package com.epam.pryndate.grow.xml.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * @author Tetiana_Prynda
 *         Created on 2/15/2017.
 */
@XmlRootElement(name = "notes")
public class Notes {
    private Collection<Note> notes;

    public Notes() {
    }

    public Notes(Collection<Note> notes) {
        this.notes = notes;
    }

    public Collection<Note> getNotes() {
        return notes;
    }

    @XmlElement(name = "note")
    public void setNotes(Collection<Note> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "notes=" + notes +
                '}';
    }
}
