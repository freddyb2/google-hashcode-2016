package com.fredericboisguerin.google.hashcode.parser;

import com.fredericboisguerin.google.hashcode.model.input.Game;

import java.io.File;
import java.util.List;

public class FileGameParser {

    private final FileToStringsParser fileToStringsParser = new FileToStringsParser();
    private final StringsGameParser stringsGameParser = new StringsGameParser();

    public Game parseFile(File file) {
        List<String> lines = fileToStringsParser.getStrings(file);
        return stringsGameParser.parse(lines);
    }
}
