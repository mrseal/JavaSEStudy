package com.cf.study.io.standardIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StandardInputOutput {

    public static void main(final String[] args) {

        try (final BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String s = "";
            while (!"bye".equals(s = in.readLine())) {
                System.out.println(s);
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }

    }
}
