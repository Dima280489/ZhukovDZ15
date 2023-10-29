package Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Assertions Assertion;

    @Test
    public void WhenFirstPlayerWin() {
        Player dima = new Player(1, "Дима", 20);
        Player lex = new Player(2, "Алексей", 10);
        Game game = new Game();
        
        game.register(dima);
        game.register(lex);
        
        int expected = 1;
        int actual = game.round("Дима", "Алексей");
        
        Assertion.assertEquals(expected, actual);
    }

    @Test
    public void WhenSecondPlayerWin() {
        Player dima = new Player(1, "Дима", 10);
        Player lex = new Player(2, "Алексей", 20);
        Game game = new Game();

        game.register(dima);
        game.register(lex);

        int expected = 2;
        int actual = game.round("Дима", "Алексей");

        Assertion.assertEquals(expected, actual);
    }

    @Test
    public void WhenStrengthEqual() {
        Player dima = new Player(1, "Дима", 10);
        Player lex = new Player(2, "Алексей", 10);
        Game game = new Game();

        game.register(dima);
        game.register(lex);

        int expected = 0;
        int actual = game.round("Дима", "Алексей");

        Assertion.assertEquals(expected, actual);
    }

    @Test
    public void WhenFirstPlayersNotRegisteredl() {
        Player dima = new Player(1, "Дима", 10);
        Player lex = new Player(2, "Алексей", 10);
        Game game = new Game();

        game.register(dima);
        game.register(lex);

        Assertion.assertThrows(NotRegisteredException.class,
                () -> game.round("Саша", "Дима"));
    }

    @Test
    public void WhenSecondPlayersNotRegisteredl() {
        Player dima = new Player(1, "Дима", 10);
        Player lex = new Player(2, "Алексей", 10);
        Game game = new Game();

        game.register(dima);
        game.register(lex);

        Assertion.assertThrows(NotRegisteredException.class,
                () -> game.round("Дима", "Саша"));
    }
}
