package org.factoriaf5.bftp2project4grupo1;

import org.factoriaf5.bftp2project4grupo1.repository.Game;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void elJuegoNosDiceSiTieneDescuentoONo() {
        Game game = new Game("Wii Sports","Wii",2006,"https://www.gamulator.com/img/roms/wii-sports-nintendo-wii-cover-340x483.jpg", "Fantasy", 19.99,19.99, "7", "suitable for all ages");
        assert(game.isDiscount()==false);
        Game game2 = new Game("Wii Sports","Wii",2006,"https://www.gamulator.com/img/roms/wii-sports-nintendo-wii-cover-340x483.jpg", "Fantasy", 19.99,17.99, "7", "suitable for all ages");
assert(game2.isDiscount()==true);

    }
}

