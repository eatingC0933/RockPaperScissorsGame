package se.yitingchang.rockpaperscissorsgame;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Random;

@Service
@SessionScope
public class GameService {
    private String playerChoice;
    private String computerChoice;
    private String result;

    public void play(String playerChoice) {
        this.playerChoice = playerChoice;
        this.computerChoice = generateComputerChoice();
        this.result = determineWinner();

    }

    private String generateComputerChoice() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        int index = (int) (Math.random() * 3);
        return choices[index];
    }


    private String determineWinner() {
        if (playerChoice.equals(computerChoice)) {
            return "It's a tie!";
        }
        switch (playerChoice) {
            case "Rock":
                return (computerChoice.equals("Scissors")) ? "You win!" : "You lose!";
            case "Paper":
                return (computerChoice.equals("Rock")) ? "You win!" : "You lose!";
            case "Scissors":
                return (computerChoice.equals("Paper")) ? "You win!" : "You lose!";
            default:
                return "Invalid choice!";
        }

    }

    public String getPlayerChoice() {
        return playerChoice;
    }

    public String getComputerChoice() {
        return computerChoice;
    }

    public String getResult() {
        return result;
    }

}
