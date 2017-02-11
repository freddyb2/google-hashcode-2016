package com.fredericboisguerin.google.hashcode.algo;

import com.fredericboisguerin.google.hashcode.algo.checker.SolutionChecker;
import com.fredericboisguerin.google.hashcode.algo.checker.SolutionValidationException;
import com.fredericboisguerin.google.hashcode.model.input.Game;
import com.fredericboisguerin.google.hashcode.model.input.TestGameInstances;
import com.fredericboisguerin.google.hashcode.model.solution.Solution;
import com.fredericboisguerin.google.hashcode.parser.FileGameParser;
import com.fredericboisguerin.google.hashcode.utils.FileUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public abstract class AlgoTest {

    private SolutionChecker solutionChecker;

    @Before
    public void setUp() throws Exception {
        solutionChecker = new SolutionChecker();
    }

    @Test
    public void should_solution_pass_in_checker_for_game_busy_day() {
        Game game = getGame(TestGameInstances.BUSY_DAY);

        Solution solution = getSolution(game);

        assertThatCheckPass(game, solution);
    }

    @Test
    public void should_solution_pass_in_checker_for_mother_of_all_warehouses() {
        Game game = getGame(TestGameInstances.MOTHER_OF_ALL_WAREHOUSES);

        Solution solution = getSolution(game);

        assertThatCheckPass(game, solution);
    }

    @Test
    public void should_solution_pass_in_checker_for_redundancy() {
        Game game = getGame(TestGameInstances.REDUNDANCY);

        Solution solution = getSolution(game);

        assertThatCheckPass(game, solution);
    }

    private Solution getSolution(Game game) {
        Algo algo = getAlgo();
        return algo.getSolution(game);
    }

    protected abstract Algo getAlgo();

    private void assertThatCheckPass(Game game, Solution solution) {
        try {
            solutionChecker.checkSolution(game, solution);
        } catch (SolutionValidationException e) {
            fail();
        }
    }

    private Game getGame(String filename) {
        FileGameParser fileGameParser = new FileGameParser();
        return fileGameParser.parseFile(FileUtils.getFile(getClass(), filename));
    }
}