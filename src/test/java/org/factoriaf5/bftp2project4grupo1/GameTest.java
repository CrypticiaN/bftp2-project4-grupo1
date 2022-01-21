package org.factoriaf5.bftp2project4grupo1;

import org.factoriaf5.bftp2project4grupo1.repository.Game;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GameTest {
    @Test
    void elJuegoNosDiceSiTieneDescuentoONo() {
        Game game = new Game("Wii Sports","Wii",2006,"https://www.gamulator.com/img/roms/wii-sports-nintendo-wii-cover-340x483.jpg", "Fantasy", 19.99, 0, 19.99, "7");
        assertThat(game.isDiscounted(), equalTo(false));
        Game game2 = new Game("Wii Sports","Wii",2006,"https://www.gamulator.com/img/roms/wii-sports-nintendo-wii-cover-340x483.jpg", "Fantasy", 19.99, 10, 17.99, "7");
        assertThat(game2.isDiscounted(), equalTo(true));

    }

    @Test
    void name2() {

        Game game2 = new Game("Wii Sports","Wii",2006,"https://www.gamulator.com/img/roms/wii-sports-nintendo-wii-cover-340x483.jpg", "Fantasy", 19.99, 10, 17.99, "7");
        assertThat(game2.getPriceWithDiscount(), equalTo(17.99));
    }

    @Test
    void name3() {

        Game game2 = new Game("Wii Sports","Wii",2006,"https://www.gamulator.com/img/roms/wii-sports-nintendo-wii-cover-340x483.jpg", "Fantasy", 24.99, 10, 22.49, "7");
        assertThat(game2.getPriceWithDiscount(), equalTo(22.49));
    }
}

