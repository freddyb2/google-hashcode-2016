package com.fredericboisguerin.google.hashcode.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FileToStringsParser {

    public List<String> getStrings(File file) {
        try {
            Scanner s = new Scanner(file);
            return getStrings(s);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static List<String> getStrings(Scanner s) {
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNext()) {
            list.add(s.nextLine());
        }
        s.close();
        return list;
    }
}
