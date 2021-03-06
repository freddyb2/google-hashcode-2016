package com.fredericboisguerin.google.hashcode.parser;

import java.io.File;

import org.junit.Test;

public class FileToStringsParserTest {

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_a_FileNotFoundException_if_file_does_not_exist() throws Exception {
        FileToStringsParser fileToStringsParser = new FileToStringsParser();
        fileToStringsParser.getStrings(new File("a_file_that_does_not_exist"));
    }
}