package com.cf.study.io.serialization;

/**
 * 1. transient fields are not serialized
 *
 * 2. static fields are not serialized.
 *
 * When an object is deserialized, the value of static fields are set to the values declared in the class, the values of non-static transient fields
 * is set to the default value for the type.
 */
public class Main2 {

    public static void main(final String[] args) {
        final PersistentObject deserialized = Util.deserialize(Util.FILE_NAME);
        System.out.println(deserialized);
    }

}