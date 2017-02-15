package com.epam.pryndate.grow.xml.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * @author Tetiana_Prynda
 *         Created on 2/15/2017.
 */
@XmlRootElement(name = "note")
public class Note {

    private String title;
    private int expire;
    private String priority;
    private String author;
    private Contents contents;

    public String getTitle() {
        return title;
    }

    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    public int getExpire() {
        return expire;
    }

    @XmlAttribute
    public void setExpire(int expire) {
        this.expire = expire;
    }

    public String getPriority() {
        return priority;
    }

    @XmlAttribute
    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAuthor() {
        return author;
    }

    @XmlAttribute
    public void setAuthor(String author) {
        this.author = author;
    }

    public Contents getContents() {
        return contents;
    }

    @XmlElement(name = "contents")
    public void setContents(Contents contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", expire=" + expire +
                ", priority='" + priority + '\'' +
                ", author='" + author + '\'' +
                ", contents=" + contents +
                '}';
    }

    @XmlRootElement(name = "contents")
    public static class Contents {
        Collection<Note.Item> items;

        public Contents() {
        }

        public Contents(Collection<Note.Item> items) {
            this.items = items;
        }

        public Collection<Note.Item> getItems() {
            return items;
        }

        @XmlElement(name = "item")
        public void setItems(Collection<Note.Item> items) {
            this.items = items;
        }

        @Override
        public String toString() {
            return "Contents{" +
                    "items=" + items +
                    '}';
        }
    }

    @XmlRootElement(name = "item")
    public static class Item {
        private String name;
        private Integer quantity;
        private String measure;
        private String description;

        public String getName() {
            return name;
        }

        @XmlElement
        public void setName(String name) {
            this.name = name;
        }

        public Integer getQuantity() {
            return quantity;
        }

        @XmlElement
        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getMeasure() {
            return measure;
        }

        @XmlElement
        public void setMeasure(String measure) {
            this.measure = measure;
        }

        public String getDescription() {
            return description;
        }

        @XmlElement
        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", quantity=" + quantity +
                    ", measure='" + measure + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}
