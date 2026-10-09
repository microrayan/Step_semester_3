package day1_live_coding.class_problems;

import java.util.Random;

public class RockPaperScissors {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    public static String getRandomComputerMove() {
        Random random = new Random();
        return MOVES[random.nextInt(MOVES.length)];
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            return "Invalid";
        }

        String p = playerMove.trim();
        String c = computerMove.trim();

        if (p.equalsIgnoreCase(c)) {
            return "Draw";
        }

        if ((p.equalsIgnoreCase("Rock") && c.equalsIgnoreCase("Scissors")) ||
            (p.equalsIgnoreCase("Paper") && c.equalsIgnoreCase("Rock")) ||
            (p.equalsIgnoreCase("Scissors") && c.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void runDemoGame(int rounds) {
        String[] demoPlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] demoComputerMoves = {"Scissors", "Paper", "Rock", "Paper", "Scissors"};

        int wins = 0, losses = 0, draws = 0;

        System.out.println("=== Rock-Paper-Scissors Arcade Game (Demo Run) ===");
        System.out.printf("%-8s | %-12s | %-13s | %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < rounds; i++) {
            String playerMove = (i < demoPlayerMoves.length) ? demoPlayerMoves[i] : getRandomComputerMove();
            String computerMove = (i < demoComputerMoves.length) ? demoComputerMoves[i] : getRandomComputerMove();

            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else if (result.equals("Draw")) {
                draws++;
            }

            System.out.printf("Round %-3d | %-12s | %-13s | %-15s%n", (i + 1), playerMove, computerMove, result);
        }

        double winPercentage = (rounds > 0) ? ((double) wins / rounds) * 100 : 0.0;
        System.out.println("---------------------------------------------------------------");
        System.out.printf("Final Summary (after %d rounds)%n", rounds);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
    }

    public static void main(String[] args) {
        runDemoGame(5);
    }
}
