package com.cf.study.io.serialization;

import java.io.*;

/**
 * 1. transient fields are not serialized
 *
 * 2. static fields are not serialized.
 *
 * When an object is deserialized, the value of static fields are set to the values declared in the class, the values of non-static transient fields
 * is set to the default value for the type.
 */
public abstract class Util {

    public final static String FILE_NAME = "PersistentObject.obj";

    public static void serialize(final PersistentObject obj, final String file) {
        try (FileOutputStream out = new FileOutputStream(file); ObjectOutputStream objOut = new ObjectOutputStream(out)) {
            objOut.writeObject(obj);
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static PersistentObject deserialize(final String serialized) {
        try (FileInputStream in = new FileInputStream(serialized); ObjectInputStream objIn = new ObjectInputStream(in)) {
            return (PersistentObject) objIn.readObject();
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
