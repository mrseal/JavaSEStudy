package com.cf.study.io.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class PersistentObject implements Serializable {

    private static final long serialVersionUID = 8338737184086835475L;

    public static int CODE = 100;
    private final String name;
    private transient String description = "Hello";

    public PersistentObject(final int code, final String name, final String description) {
        CODE = code;
        this.name = name;
        this.description = description;
    }

    private void writeObject(final ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        final Date date = new Date();
        oos.writeObject(date);
        System.out.println(this + " serialized at " + date);
    }

    private void readObject(final ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        System.out.println(ois.readObject());
    }

    @Override
    public String toString() {
        return "PersistentObject [code=" + CODE + ", name=" + name + ", description=" + description + "]";
    }

}
