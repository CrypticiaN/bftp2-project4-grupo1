package org.factoriaf5.bftp2project4grupo1.controllers;

import org.factoriaf5.bftp2project4grupo1.repository.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.factoriaf5.bftp2project4grupo1.repository.GameRepository;


import java.util.List;

@Controller
public class GameController {

    private  GameRepository gameRepository;

    @Autowired
    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    @GetMapping("/")
    String listGames(Model model, @RequestParam(required = false) String category, String pegi, Double price, Double priceWithDiscount) {

        List<Game> games;

        if (category != null) {
            games = gameRepository.findGamesByCategoryEquals(category);
            model.addAttribute("title", "Games from category " + category);
        }

        else if (pegi != null) {
            games = gameRepository.findGamesByPegiEquals(pegi);
            model.addAttribute("title", "Games from pegi " + pegi);

            String pegi2 = "";
            String contentDescriptor;
            switch (pegi2)
            {
                case "3":  contentDescriptor = "suitable for kids";
                    break;
                case "7":  contentDescriptor = "suitable for all ages";
                    break;
                case "12":  contentDescriptor = "non-realistic violence";
                    break;
                case "15": contentDescriptor = "realistic violence";
                    break;
                case "18": contentDescriptor = "extreme violence";
                    break;
                default: contentDescriptor = "no tiene ninguna descripción";
                    break;
            }
            System.out.println(contentDescriptor);
        }



            else {
                games = gameRepository.findAll();
                model.addAttribute("title", "Game List");
            }


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
