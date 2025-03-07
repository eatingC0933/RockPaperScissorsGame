package se.yitingchang.rockpaperscissorsgame;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/")
        public String play(Model model) {
        return "play";
    }

    @PostMapping("/play")
    public String playGame(@RequestParam String choice, Model model) {
        gameService.play(choice);
        model.addAttribute("playerChoice", gameService.getPlayerChoice());
        model.addAttribute("computerChoice", gameService.getComputerChoice());
        model.addAttribute("result", gameService.getResult());
        return "play";
    }

}
