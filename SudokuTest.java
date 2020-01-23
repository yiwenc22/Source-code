package edu.ics211.h09;

/**
 * Test a HexadecimalSudoku solver.
 *
 * @author Biagioni, Edoardo and Cam Moore
 *     date August 5, 2016
 *     bugs none
 *     Edited By Chak Hon Lam
 */
public class SudokuTest {

  /**
   * Checks the sudoku returning true if all cells are filled. Does not check
   * validity.
   *
   * @return true if all cells are filled, false otherwise.
   */
  private static boolean isFilled(int[][] sudoku) {
    for (int i = 0; i < 16; i++) {
      for (int j = 0; j < 16; j++) {
        if (sudoku[i][j] == -1) {
          return false;
        }
      }
    }
    return true;
  }


  /**
   * Test whether two sudoku are equal. If not, return a new sudoku that is
   * blank where the two sudoku differ.
   *
   * @param sudoku the sudoku to be checked.
   * @param solution the solution checked.
   * @return null if the two match, and otherwise a sudoku with 0 in every cell
   *         that differs.
   */
  private static int[][] sameSudoku(int[][] sudoku, int[][] solution) {
    int[][] result = new int[16][16];
    for (int i = 0; i < 16; i++) {
      for (int j = 0; j < 16; j++) {
        result[i][j] = sudoku[i][j];
      }
    }
    boolean same = true;
    for (int i = 0; i < 16; i++) {
      for (int j = 0; j < 16; j++) {
        if (result[i][j] != solution[i][j]) {
          same = false;
          result[i][j] = -1;
        }
      }
    }
    if (same) {
      return null;
    }
    return result;
  }


  /**
   * Try to solve a sudoku. If a solution is provided, also check against the
   * solution. Print the results.
   *
   * @param name the name of this sudoku.
   * @param sudoku the sudoku to be solved.
   * @param solution the given solution, or null.
   */
  private static void testSudoku(String name, int[][] sudoku, int[][] solution) {
    System.out.println("solving " + name + "\n" + HexadecimalSudoku.toString(sudoku, true));
    if (HexadecimalSudoku.solveSudoku(sudoku)) {
      if (isFilled(sudoku) && HexadecimalSudoku.checkSudoku(sudoku, true)) {
        System.out.println("success!\n" + HexadecimalSudoku.toString(sudoku, true));
        if (solution != null) {
          int[][] diff = sameSudoku(sudoku, solution);
          if (diff != null) {
            System.out.println("given solution:\n" + HexadecimalSudoku.toString(solution, true));
            System.out.println("difference between solutions:\n"
                + HexadecimalSudoku.toString(diff, true));
          }
        }
      } else { /* the supposed solution is not a complete or valid sudoku */
        if (!isFilled(sudoku)) {
          System.out.println("sudoku was not completely filled:\n"
              + HexadecimalSudoku.toString(sudoku, false));
        }
        if (!HexadecimalSudoku.checkSudoku(sudoku, false)) {
          System.out.println("sudoku is not a valid solution:\n"
              + HexadecimalSudoku.toString(sudoku, false));
        }
      }
    } else {
      System.out.println("unable to complete sudoku " + name
          + "\n" + HexadecimalSudoku.toString(sudoku, true));
    }
  }


  /**
   * Tests four Sudoku proglems.
   * @param arg command line arguments, ignored.
   */
  public static void main(String[] arg) {

    int[][] example1 = { { 0, 2, 5, -1, 4, -1, 9, -1, 6, 14, -1, 1, -1, 3, -1, -1 },
        { 0, -1, 0, 9, -1, -1, 2, 12, 13, -1, 3, -1, 15, -1, -1, -1 },
        { 1, -1, -1, -1, -1, -1, 7, -1, -1, 9, -1, 2, 11, 5, 14, 0 },
        { 13, 8, -1, -1, 5, -1, -1, 0, -1, -1, 15, -1, -1, 9, -1, 2 },
        { 0, 7, 14, 2, -1, -1, -1, 9, -1, -1, -1, 5, -1, -1, 3, 15 },
        { 3, -1, -1, -1, 10, -1, -1, -1, 2, 4, 13, 15, -1, -1, 6, 11 },
        { 12, -1, 10, 13, -1, -1, -1, -1, 8, -1, -1, -1, 7, -1, 5, 9 },
        { 6, 11, -1, -1, -1, 15, -1, -1, -1, 12, 9, 3, -1, -1, 10, -1 },
        { 2, -1, -1, -1, 3, 7, 11, 4, 5, -1, -1, -1, 0, 13, -1, 8 },
        { 7, 6, 12, 8, -1, -1, -1, -1, 0, 13, -1, 11, 4, -1, -1, -1 },
        { 4, 9, 3, -1, -1, -1, -1, -1, 15, -1, 12, 7, 6, -1, 1, -1 },
        { 10, -1, 11, -1, 15, -1, 12, 1, 3, -1, -1, 14, 9, 7, -1, -1 },
        { 9, -1, 2, -1, 7, 4, 0, -1, -1, -1, 5, -1, -1, 8, 13, -1 },
        { 8, 3, 7, -1, -1, 9, 6, -1, 12, -1, -1, -1, -1, -1, -1, 14 },
        { 15, -1, 4, -1, 12, -1, 8, 10, -1, -1, -1, -1, 1, 6, 9, 7 },
        { 5, 12, -1, 6, -1, 3, 15, -1, 9, 0, -1, -1, 2, -1, -1, -1 } };

    int[][] example2 = {{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}};

    testSudoku("example 1", example1, null);
    testSudoku("example 2", example2, null);
  }
}
