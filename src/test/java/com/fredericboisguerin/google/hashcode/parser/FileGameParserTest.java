package com.fredericboisguerin.google.hashcode.parser;

import static com.fredericboisguerin.google.hashcode.model.input.TestGameInstances.BUSY_DAY;
import static com.fredericboisguerin.google.hashcode.model.input.TestGameInstances.MOTHER_OF_ALL_WAREHOUSES;
import static com.fredericboisguerin.google.hashcode.model.input.TestGameInstances.REDUNDANCY;
import static org.hamcrest.CoreMatchers.is;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fredericboisguerin.google.hashcode.model.input.Game;
import com.fredericboisguerin.google.hashcode.utils.FileUtils;

public class FileGameParserTest {

    private FileGameParser fileGameParser;

    @Before
    public void setUp() throws Exception {
        FileToStringsParser fileToStringsParser = new FileToStringsParser();
        StringsGameParser stringsGameParser = new StringsGameParser();

        fileGameParser = new FileGameParser();
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