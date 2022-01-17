package org.factoriaf5.bftp2project4grupo1;

import org.factoriaf5.bftp2project4grupo1.repository.Game;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GameTest {
    @Test
    void elJuegoNosDiceSiTieneDescuentoONo() {
        Game game = new Game("Wii Sports","Wii",2006,"https://www.gamulator.com/img/roms/wii-sports-nintendo-wii-cover-340x483.jpg", "Fantasy", 19.99,19.99, "7", "suitable for all ages");
        assert(!game.isDiscount());
        Game game2 = new Game("Wii Sports","Wii",2006,"https://www.gamulator.com/img/roms/wii-sports-nintendo-wii-cover-340x483.jpg", "Fantasy", 19.99,17.99, "7", "suitable for all ages");
        assert(game2.isDiscount());

    }

    @Test
    void CalcularPorcentajeDeDescuento() {
        Game game = new Game("Wii Sports","Wii",2006,"https://www.gamulator.com/img/roms/wii-sports-nintendo-wii-cover-340x483.jpg", "Fantasy", 19.99,19.99, "7", "suitable for all ages");
        assert(game.Discount()==0);


    }

    @Test
    void name2() {

        Game game2 = new Game("Wii Sports","Wii",2006,"https://www.gamulator.com/img/roms/wii-sports-nintendo-wii-cover-340x483.jpg", "Fantasy", 19.99,17.99, "7", "suitable for all ages");
        assertThat(game2.getPriceWithDiscount(), equalTo(17.99));
    }

    @Test
    void name3() {

        Game game2 = new Game("Wii Sports","Wii",2006,"https://www.gamulator.com/img/roms/wii-sports-nintendo-wii-cover-340x483.jpg", "Fantasy", 24.99,22.49, "7", "suitable for all ages");
        assertThat(game2.getPriceWithDiscount(), equalTo(22.49));
    }
}

