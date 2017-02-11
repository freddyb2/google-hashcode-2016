package com.fredericboisguerin.google.hashcode.parser;

import com.fredericboisguerin.google.hashcode.model.Game;

import java.io.File;
import java.util.List;

public class FileGameParser {

    private final FileToStringsParser fileToStringsParser;
    private final StringsGameParser stringsGameParser;

    public FileGameParser(FileToStringsParser fileToStringsParser, StringsGameParser stringsGameParser) {
        this.fileToStringsParser = fileToStringsParser;
        this.stringsGameParser = stringsGameParser;
    }

    public Game parseFile(File file){
        List<String> lines = fileToStringsParser.getStrings(file);
        return stringsGameParser.parse(lines);
    }
}
