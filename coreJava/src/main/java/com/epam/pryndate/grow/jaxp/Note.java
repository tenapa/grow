package com.epam.pryndate.grow.jaxp;

import java.util.Collection;

/**
 * @author Tetiana_Prynda
 *         Created on 2/14/2017.
 */
public class Note {
    public static final String NOTE_ELEM = "note";
    public static final String EXPIRE_ATTR = "expire";
    public static final String PRIORITY_ATTR = "priority";
    public static final String AUTHOR_ATTR = "author";
    public static final String TITLE_ELEM = "title";
    public static final String CONTENTS_ELEM = "contents";

    private String title;
    private int expire;
    private String priority;
    private String author;

    private Collection<Item> contents;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Collection<Item> getContents() {
        return contents;
    }

    public void setContents(Collection<Item> contents) {
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

    public static class Item {
        public static final String ITEM_ELEM = "item";
        public static final String NAME_ELEM = "name";
        public static final String QTY_ELEM = "quantity";
        public static final String MEASURE_ELEM = "measure";
        public static final String DESCRIPTION_ELEM = "description";

        private String name;
        private Integer quantity;
        private String measure;
        private String description;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getMeasure() {
            return measure;
        }

        public void setMeasure(String measure) {
            this.measure = measure;
        }

        public String getDescription() {
            return description;
        }

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
