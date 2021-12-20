package org.factoriaf5.bftp2project4grupo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.factoriaf5.bftp2project4grupo1.repository.Game;
import org.factoriaf5.bftp2project4grupo1.repository.GameRepository;

import java.util.List;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void loadsTheHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

    @Autowired
    GameRepository gameRepository;

    @Test
    void returnsTheExistingGames() throws Exception {

        Game game = gameRepository.save(new Game("Wii Sports", "Wii", 2006, "https://static.wikia.nocookie.net/videojuego/images/9/98/WiiSport_BA-1-.jpg/revision/latest/top-crop/width/360/height/450?cb=20070629185312"));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attribute("games", hasItem(game)));
    }
    @BeforeEach
    void setUp() {
        gameRepository.deleteAll();
    }

    @Test
    void returnsAFormToAddNewBooks() throws Exception {
        mockMvc.perform(get("/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("add"))
                .andExpect(model().attributeExists("game"))
                .andExpect(model().attribute("title", "Add a new game"));
    }


    @Test
    void allowsToCreateAGame() throws Exception {
        mockMvc.perform(post("/games/add")
                        .param("title", "Harry Potter and the Philosopher's Stone")
                        .param("platform", "J.K. Rowling")
                        .param("year", "2006")
                        .param("imageUrl", "google.com")
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"))
        ;

        List<Game> existingGames = (List<Game>) gameRepository.findAll();
        assertThat(existingGames, contains(allOf(
                hasProperty("title", equalTo("Harry Potter and the Philosopher's Stone")),
                hasProperty("platform", equalTo("J.K. Rowling")),
                hasProperty("year", equalTo(2006)),
                hasProperty("imageUrl", equalTo("google.com"))
        )));
    }


}
