import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void whenPlayerOneWin() {
        Player kolya = new Player(1, "Alex", 150);
        Player petya = new Player(2, "Ron", 120);
        Game game = new Game();
        game.register(kolya);
        game.register(petya);
        int expected = 1;
        int actual = game.round("Alex","Ron");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenPlayerTwoWin() {
        Player kolya = new Player(1, "Alex", 150);
        Player petya = new Player(2, "Ron", 170);
        Game game = new Game();
        game.register(kolya);
        game.register(petya);
        int expected = 2;
        int actual = game.round("Alex","Ron");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenNobodyWin() {
        Player kolya = new Player(1, "Alex", 150);
        Player petya = new Player(2, "Ron", 150);
        Game game = new Game();
        game.register(kolya);
        game.register(petya);
        int expected = 0;
        int actual = game.round("Alex","Ron");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenPlayerOneNotExist() {
        Player kolya = new Player(1, "Alex", 150);
        Player petya = new Player(2, "Ron", 120);
        Game game = new Game();
        game.register(kolya);
        game.register(petya);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Max", "Ron"));
    }
    @Test
    public void whenPlayerTwoNotExist() {
        Player kolya = new Player(1, "Alex", 150);
        Player petya = new Player(2, "Ron", 120);
        Game game = new Game();
        game.register(kolya);
        game.register(petya);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Alex", "Max"));
    }
}
