package org.factoriaf5.bftp2project4grupo1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class SampleDataLoader {

    private GameRepository gameRepository;

    @Autowired
    public SampleDataLoader(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @PostConstruct
    public void loadSampleData() {
        gameRepository.saveAll(List.of(
                new Game("Wii Sports","Wii",2006,"https://www.gamulator.com/img/roms/wii-sports-nintendo-wii-cover-340x483.jpg", "Fantasy", 19.99, 0, 19.99, "7", "suitable for all ages"),
                new Game("Super Mario Bros", "NES", 1985, "https://i.blogs.es/638318/super_mario_bros_logo/450_1000.jpeg", "Sports", 14.99,0, 14.99, "7", "suitable for all ages"),
                new Game("Mario Kart Wii", "Wii", 2008, "https://cdn.atomix.vg/wp-content/uploads/2014/02/PalMK8Box.jpg", "Sci-fi", 9.99, 0, 9.99,  "7", "suitable for all ages"),
                new Game("Wii Sports Resort", "Wii", 2009, "https://m.media-amazon.com/images/I/51o5CRXYcXL._AC_.jpg", "Fantasy", 9.99, 0, 9.99, "7","suitable for all ages"),
                new Game("Pokemon Red/Pokemon Blue", "GB", 1996, "https://www.gamulator.com/img/roms/pokemon-red-blue-2-in-1-gb-cover-340x483.jpg", "Fantasy", 29.99, 0, 29.99, "12", "non realistic violence"),
                new Game("Nintendogs", "DS", 2005, "https://www.gamulator.com/img/roms/nintendogs-dalmatian-friends-cover-nds-eu-340x483.jpg", "Sports", 29.99, 0, 29.99, "3", "suitable for kids"),
                new Game("Grand Theft Auto:San Andreas ", "PS2", 2004, "https://i.3djuegos.com/juegos/1012/grand_theft_auto_san_andreas/fotos/ficha/grand_theft_auto_san_andreas-3785649.jpg", "Sci-fi", 24.99, 10, 22.49, "18", "extreme violence")

        ));
    }
}
