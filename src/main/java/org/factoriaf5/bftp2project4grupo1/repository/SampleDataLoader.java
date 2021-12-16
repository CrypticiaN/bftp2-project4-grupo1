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
                new Game("Wii Sports","Wii",2006),
                new Game("Super Mario Bros", "NES", 1985),
                new Game("Mario Kart Wii", "Wii", 2008),
                new Game("Wii Sports Resort", "Wii", 2009),
                new Game("Pokemon Red/Pokemon Blue", "GB", 1996),
                new Game("Nintendogs", "DS", 2005)
        ));
    }
}
