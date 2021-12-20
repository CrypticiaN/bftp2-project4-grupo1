package org.factoriaf5.bftp2project4grupo1.controllers;

import org.factoriaf5.bftp2project4grupo1.repository.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.factoriaf5.bftp2project4grupo1.repository.GameRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


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
        model.addAttribute("title", "Game List");
        model.addAttribute("games", games);
        return "home";
    }

    @GetMapping("/add")
    String getForm(Model model){
        Game game = new Game();
        model.addAttribute("game", game);
        model.addAttribute("title", "Add a new game");
        return "add";
    }

    @PostMapping("/games/add")
    String addGame(@ModelAttribute Game game) {
        gameRepository.save(game);
        return "redirect:/";
    }

    @GetMapping("/games/add/{id}")
    String editBook(Model model, @PathVariable Long id){
        Game game = gameRepository.findById(id).get();
        model.addAttribute("game", game);
        model.addAttribute("title", "Edit game");
        return "/add";
    }

    @GetMapping("/games/delete/{id}")
    String deleteGame(@PathVariable Long id){
        gameRepository.deleteById(id);
        return "redirect:/";
    }
}
