/*
 * William Zwart
 * A program that will allow the user to play tic tac toe but on a bigger board.
 * 
 */

package tictactoebig;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author William Zwart
 */
public class TicTacToeBig {
    /**
     * 
     * @param args the command line arguments 
     */
    public static void main(String[] args) {
        //Variables
        Scanner userInput = new Scanner(System.in);
        String[] playingBoard = new String[25];
        String playerTurn = "X";
        String playerWhoWon = null;
        createPlayingBoard(playingBoard);
        System.out.println("Welcome to a bigger version of tic tac toe. In this game you will attempt to make 4 in a row. You will need 2 players.");
        System.out.println("--------------------------------");
        printPlayingBoard(playingBoard);
        System.out.println("X will play first. Enter a number to place X in:");
        //Creating tne game
        while (playerWhoWon == null) {
            int userNumberInput;
            try {
                userNumberInput = userInput.nextInt();
                if (!(userNumberInput > 0 && userNumberInput < 26)) {
                    System.out.println("Invalid input. Re-enter number.");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Re-enter number.");
                continue;
            }
            if (playingBoard[userNumberInput-1].equals(String.valueOf(userNumberInput))) {
                playingBoard[userNumberInput-1] = playerTurn;
                if (playerTurn.equals("X")) {
                    playerTurn = "O";
                } else {
                    playerTurn = "X";
                }
                printPlayingBoard(playingBoard);
                playerWhoWon = seeWhoWon(playingBoard,playerTurn);
            } else {
                System.out.println("Slot already taken. Re-enter number.");
                continue;
            }
        }
        //Writing who the winner is
        if (playerWhoWon.equalsIgnoreCase("draw")) {
            System.out.println("Neither X or O won... It's a draw.");
        } else {
            System.out.println("The winner is...: " + playerWhoWon + "!");
        }
    }
    //Check to see if anyone has 4 in a row
    static String seeWhoWon(String[] playingBoard,String playerTurn) {
        for (int i = 0; i < 27; i++) {
            String line = null;
            switch (i) {
                //Horizontal winning
                case 0:
                    line = playingBoard[0] + playingBoard[1] + playingBoard[2] + playingBoard[3];
                    break;
                case 1:
                    line = playingBoard[1] + playingBoard[2] + playingBoard[3] + playingBoard[4];
                    break;
                case 2:
                    line = playingBoard[5] + playingBoard[6] + playingBoard[7] + playingBoard[8];
                    break;
                case 3:
                    line = playingBoard[6] + playingBoard[7] + playingBoard[8] + playingBoard[9];
                    break;
                case 4:
                    line = playingBoard[10] + playingBoard[11] + playingBoard[12] + playingBoard[13];
                    break;
                case 5:
                    line = playingBoard[11] + playingBoard[12] + playingBoard[13] + playingBoard[14];
                    break;
                case 6:
                    line = playingBoard[15] + playingBoard[16] + playingBoard[17] + playingBoard[18];
                    break;
                case 7:
                    line = playingBoard[16] + playingBoard[17] + playingBoard[18] + playingBoard[19];
                    break;
                case 8:
                    line = playingBoard[20] + playingBoard[21] + playingBoard[22] + playingBoard[23];
                    break;
                case 9:
                    line = playingBoard[21] + playingBoard[22] + playingBoard[23] + playingBoard[24];
                    break;
                //Vertical winning
                case 10:
                    line = playingBoard[0] + playingBoard[5] + playingBoard[10] + playingBoard[15];
                    break;
                case 11:
                    line = playingBoard[5] + playingBoard[10] + playingBoard[15] + playingBoard[20];
                    break;
                case 12:
                    line = playingBoard[1] + playingBoard[6] + playingBoard[11] + playingBoard[16];
                    break;
                case 13:
                    line = playingBoard[6] + playingBoard[11] + playingBoard[16] + playingBoard[21];
                    break;
                case 14:
                    line = playingBoard[2] + playingBoard[7] + playingBoard[12] + playingBoard[17];
                    break;
                case 15:
                    line = playingBoard[7] + playingBoard[12] + playingBoard[17] + playingBoard[22];
                    break;
                case 16:
                    line = playingBoard[3] + playingBoard[8] + playingBoard[13] + playingBoard[18];
                    break;
                case 17:
                    line = playingBoard[8] + playingBoard[13] + playingBoard[18] + playingBoard[23];
                    break;
                case 18:
                    line = playingBoard[4] + playingBoard[9] + playingBoard[14] + playingBoard[19];
                    break;
                case 19:
                    line = playingBoard[9] + playingBoard[14] + playingBoard[19] + playingBoard[24];
                    break;
                //Diagonal winning
                case 20:
                    line = playingBoard[1] + playingBoard[7] + playingBoard[13] + playingBoard[19];
                    break;
                case 21:
                    line = playingBoard[0] + playingBoard[6] + playingBoard[12] + playingBoard[18];
                    break;
                case 22:
                    line = playingBoard[6] + playingBoard[12] + playingBoard[18] + playingBoard[24];
                    break;
                case 23:
                    line = playingBoard[5] + playingBoard[11] + playingBoard[17] + playingBoard[23];
                    break;
                case 24:
                    line = playingBoard[15] + playingBoard[11] + playingBoard[7] + playingBoard[3];
                    break;
                case 25:
                    line = playingBoard[20] + playingBoard[16] + playingBoard[12] + playingBoard[8];
                    break;
                case 26:
                    line = playingBoard[16] + playingBoard[12] + playingBoard[8] + playingBoard[4];
                    break;
                case 27:
                    line = playingBoard[21] + playingBoard[17] + playingBoard[13] + playingBoard[9];
                    break;
            }
            if (line.equals("XXXX")) {
                return "X";
            } else if (line.equals("OOOO")) {
                return "O";
            }
        }
        for (int i = 0; i < 25; i++) {
            if (Arrays.asList(playingBoard).contains(String.valueOf(i+1))) {
                break;
            }
            else if (i == 24) return "draw";
        }
        
        System.out.println(playerTurn + "'s turn. Enter a number to place a(n) " + playerTurn + " in:");
        return null;
    }
    //Put a playingBoard esque graphic in the console
    static void printPlayingBoard(String[] playingBoard) {
        System.out.println("--|--|--|--|--");
        System.out.println(playingBoard[0] + "|" + playingBoard[1] + "|" + playingBoard[2] + "|" + playingBoard[3] + "|" + playingBoard[4]);
        System.out.println("--------------");
        System.out.println(playingBoard[5] + "|" + playingBoard[6] + "|" + playingBoard[7] + "|" + playingBoard[8] + "|" + playingBoard[9]);
        System.out.println("--------------");
        System.out.println(playingBoard[10] + "|" + playingBoard[11] + "|" + playingBoard[12] + "|" + playingBoard[13] + "|" + playingBoard[14]);
        System.out.println("--------------");
        System.out.println(playingBoard[15] + "|" + playingBoard[16] + "|" + playingBoard[17] + "|" + playingBoard[18] + "|" + playingBoard[19]);
        System.out.println("--------------");
        System.out.println(playingBoard[20] + "|" + playingBoard[21] + "|" + playingBoard[22] + "|" + playingBoard[23] + "|" + playingBoard[24]);
        System.out.println("--|--|--|--|--");
    }
    //Assign the numbers in the array for the board
    static void createPlayingBoard(String[] playingBoard) {
        for (int i = 0; i < 25; i++) {
            playingBoard[i] = String.valueOf(i+1);
        }
    }
}