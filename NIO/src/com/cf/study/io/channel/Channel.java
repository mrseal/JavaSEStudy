package com.cf.study.io.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Channel {

    public static void main(final String[] args) {
        copy("/tmp/Hello.txt", "/tmp/New.txt");
    }

    public static void copy(final String source, final String target) {
        try (final FileInputStream in = new FileInputStream(source);
                final FileChannel from = in.getChannel();
                final FileOutputStream out = new FileOutputStream(target);
                final FileChannel to = out.getChannel()) {

            final ByteBuffer buffer = ByteBuffer.allocate((int) from.size());
            from.read(buffer);
            buffer.position(0);
            to.write(buffer);

        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
