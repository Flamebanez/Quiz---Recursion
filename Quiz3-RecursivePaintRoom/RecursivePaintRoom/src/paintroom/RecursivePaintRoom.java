package paintroom;

import java.io.*;
import java.util.*;

/************************** DO NOT MODIFY THESE FUNCTIONS BELOW ***************************/

/* RecursivePaintRoom
 *
 */
public class RecursivePaintRoom {
  public static final String DEFAULT_FILENAMES[] = {"InputFiles/room-Default01.txt", "InputFiles/room-NewTests01.txt"};
  public static final int ROW_LOCATIONS[] = {3, 3, 0};
  public static final int COL_LOCATIONS[] = {4, 1, 0};

  public static void main(String[] args) throws IOException {
    int i, j;

    System.out.printf("Running default test files: \n\n");

    for (i = 0; i < DEFAULT_FILENAMES.length; i++) {
      for (j = 0; j < ROW_LOCATIONS.length; j++) {
        System.out.printf("\n--------------- START OF OUTPUT FOR %s, %d, %d -----------------\n\n",
            DEFAULT_FILENAMES[i], ROW_LOCATIONS[j], COL_LOCATIONS[j]);

        char room[][] = read2DArray(DEFAULT_FILENAMES[i]);
        System.out.printf("Base room: \n\n");
        print2DArray(room);

        recFill(room, ROW_LOCATIONS[j], COL_LOCATIONS[j]);

        System.out.printf("\nRoom after algorithm: \n\n");
        print2DArray(room);

        System.out.printf("\n--------------- END OF OUTPUT FOR %s, %d, %d -----------------\n\n",
            DEFAULT_FILENAMES[i], ROW_LOCATIONS[j], COL_LOCATIONS[j]);
      }
    }
  }

  // Read in and return room from given file
  public static char[][] read2DArray(String fileName) {
    File file = new File(fileName);
    Scanner input;

    try {
      input = new Scanner(file);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("The file " + fileName + " was not found.");
      return null;
    }

    int rows = input.nextInt();
    int cols = input.nextInt();
    char room[][] = new char[rows][cols];

    for (int i = 0; i < rows; i++) {
      String next = input.next();

      for (int j = 0; j < cols; j++) {
        room[i][j] = next.charAt(j);
      }
    }

    input.close();

    return room;
  }

  // Print given 2D array
  public static void print2DArray(char room[][]) {
    int i, j;

    for (i = 0; i < room.length; i++) {
      for (j = 0; j < room[i].length; j++) System.out.printf("%c", room[i][j]);
      System.out.printf("\n");
    }
  }

  /************************** DO NOT MODIFY ABOVE FUNCTIONS ***************************/

  public static void recFill(char room[][], int row, int col) {
    if (row < 0 || row >= room.length || col < 0 || col >= room[0].length) {
      return;
    }
    
    if (room[row][col] != '.') {
      return;
    }
    
    room[row][col] = 'O';
    
    recFill(room, row - 1, col);
    recFill(room, row + 1, col);
    recFill(room, row, col - 1);
    recFill(room, row, col + 1);
  }
}
