package com.fredericboisguerin.google.hashcode.parser;

import com.fredericboisguerin.google.hashcode.model.Game;
import com.fredericboisguerin.google.hashcode.utils.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;

public class FileGameParserTest {

    private static final String BUSY_DAY = "busy_day.in";
    private static final String MOTHER_OF_ALL_WAREHOUSES = "mother_of_all_warehouses.in";
    private static final String REDUNDANCY = "redundancy.in";

    private FileGameParser fileGameParser;

    @Before
    public void setUp() throws Exception {
        FileToStringsParser fileToStringsParser = new FileToStringsParser();
        StringsGameParser stringsGameParser = new StringsGameParser();

        fileGameParser = new FileGameParser(fileToStringsParser, stringsGameParser);
    }

    @Test
    public void should_parse_busy_day() throws Exception {
        File file = FileUtils.getFile(getClass(), BUSY_DAY);

        Game game = fileGameParser.parseFile(file);

        assertSetsSize(game, 30, 10, 1250);
    }

    @Test
    public void should_parse_mother_of_all_warehouses() throws Exception {
        File file = FileUtils.getFile(getClass(), MOTHER_OF_ALL_WAREHOUSES);

        Game game = fileGameParser.parseFile(file);

        assertSetsSize(game, 20, 1, 800);
    }

    @Test
    public void should_parse_redundancy() throws Exception {
        File file = FileUtils.getFile(getClass(), REDUNDANCY);

        Game game = fileGameParser.parseFile(file);

        assertSetsSize(game, 30, 16, 1000);
    }

    private void assertSetsSize(Game game, int nbDrones, int nbWarehouses, int nbOrders) {
        Assert.assertThat(game.getDrones().size(), is(nbDrones));
        Assert.assertThat(game.getWarehouses().size(), is(nbWarehouses));
        Assert.assertThat(game.getOrders().size(), is(nbOrders));
    }
}