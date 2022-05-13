package com.newton.code.arrays;

public class TicTacToe {
  public static void main(String[] args) {
    /**
     * 1
     *      1
     * 2    2    1
     */
    int[][] moves = {{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
    System.out.printf(playGame(moves));

  }

  private static String playGame(int[][] moves) {
    int[][] game = new int[3][3];

    for (int i = 0; i < moves.length; i++) {
      if (i % 2 == 0) {
        game[moves[i][0]][moves[i][1]] = 1;
      } else {
        game[moves[i][0]][moves[i][1]] = 2;
      }
    }

    int res = checkIfDiag(game);
    if (res == 1) {
      return "A";
    } else if (res == 2) {
      return "B";
    } else if (res == 0 && moves.length < 9) {
      return "Pending";
    } else if (res == 0) {
      return "Draw";
    }
    return null;
  }

  public static int checkIfDiag(int[][] game) {

    for (int i = 0; i < game.length; i++) {

      if ((game[i][0] == 1 && game[i][1] == 1 && game[i][2] == 1) ||
          (game[0][i] == 1 && game[1][i] == 1 && game[2][i] == 1)) {
        return 1;
      } else if ((game[i][0] == 2 && game[i][1] == 2 && game[i][2] == 2) ||
          (game[0][i] == 2 && game[1][i] == 2 && game[2][i] == 2)) {
        return 2;
      }

    }

    if ((game[0][0] == 1 && game[1][1] == 1 && game[2][2] == 1) ||
        (game[0][2] == 1 && game[1][1] == 1 && game[2][0] == 1)) {
      return 1;
    } else if ((game[0][0] == 2 && game[1][1] == 2 && game[2][2] == 2) ||
        (game[0][2] == 2 && game[1][1] == 2 && game[2][0] == 2)) {
      return 2;
    }

    return 0;
  }

}
