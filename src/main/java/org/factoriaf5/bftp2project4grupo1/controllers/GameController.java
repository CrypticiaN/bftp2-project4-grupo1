package org.factoriaf5.bftp2project4grupo1.controllers;

import org.factoriaf5.bftp2project4grupo1.repository.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.factoriaf5.bftp2project4grupo1.repository.GameRepository;


import java.util.List;

@Controller
public class GameController {

    private GameRepository gameRepository;

    @Autowired
    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/")
    String listGames(Model model) {
        List<Game> games = (List<Game>) gameRepository.findAll();
        model.addAttribute("title", "Game list");
        model.addAttribute("games", games);
        return "home";
    }
}
