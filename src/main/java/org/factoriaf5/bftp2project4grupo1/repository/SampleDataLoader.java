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
                new Game("Wii Sports","Wii",2006,"https://www.gamulator.com/img/roms/wii-sports-nintendo-wii-cover-340x483.jpg", "Fantasy", "7"),
                new Game("Super Mario Bros", "NES", 1985, "https://i.blogs.es/638318/super_mario_bros_logo/450_1000.jpeg", "Sports", "7"),
                new Game("Mario Kart Wii", "Wii", 2008, "https://cdn.atomix.vg/wp-content/uploads/2014/02/PalMK8Box.jpg", "Sci-fi", "7"),
                new Game("Wii Sports Resort", "Wii", 2009, "https://m.media-amazon.com/images/I/51o5CRXYcXL._AC_.jpg", "Fantasy", "7"),
                new Game("Pokemon Red/Pokemon Blue", "GB", 1996, "https://www.gamulator.com/img/roms/pokemon-red-blue-2-in-1-gb-cover-340x483.jpg", "Fantasy", "12"),
                new Game("Nintendogs", "DS", 2005, "https://www.gamulator.com/img/roms/nintendogs-dalmatian-friends-cover-nds-eu-340x483.jpg", "Sports", "3")
        ));
    }
}
