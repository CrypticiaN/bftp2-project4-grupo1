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
                new Game("Wii Sports","Wii",2006,"https://static.wikia.nocookie.net/videojuego/images/9/98/WiiSport_BA-1-.jpg/revision/latest/top-crop/width/360/height/450?cb=20070629185312"),
                new Game("Super Mario Bros", "NES", 1985, "https://i.blogs.es/638318/super_mario_bros_logo/450_1000.jpeg"),
                new Game("Mario Kart Wii", "Wii", 2008, "https://cdn.atomix.vg/wp-content/uploads/2014/02/PalMK8Box.jpg"),
                new Game("Wii Sports Resort", "Wii", 2009, "https://m.media-amazon.com/images/I/51o5CRXYcXL._AC_.jpg"),
                new Game("Pokemon Red/Pokemon Blue", "GB", 1996, "https://as01.epimg.net/meristation/imagenes/2018/09/28/cover/171413381538159016.jpg"),
                new Game("Nintendogs", "DS", 2005, "https://media.vandal.net/m/3512/nintendogs-201423161257_1.jpg")
        ));
    }
}
