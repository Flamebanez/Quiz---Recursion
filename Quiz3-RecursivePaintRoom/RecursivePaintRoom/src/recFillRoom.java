import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RecFillRoom {

    public static void recFill(char room[][], int row, int col) {
        // Base case: if the current cell is out of bounds or not a '.', return
        if (row < 0 || row >= room.length || col < 0 || col >= room[0].length || room[row][col] != '.') {
            return;
        }

        // Replace the current cell with 'O'
        room[row][col] = 'O';

        // Recursive calls to fill in all four directions
        recFill(room, row - 1, col); // up
        recFill(room, row + 1, col); // down
        recFill(room, row, col - 1); // left
        recFill(room, row, col + 1); // right
    }

    public static void main(String[] args) {
        try {
            // Load the room from file
            char[][] room = loadRoomFromFile("room-Default01.txt");
            System.out.println("Original room:");
            printRoom(room);

            System.out.println("\nrecFill(room, 3, 4):");
            recFill(room, 3, 4);
            printRoom(room);

            // Load another room from file for the next test
            room = loadRoomFromFile("room-NewTests01.txt");
            System.out.println("\nrecFill(room, 3, 1):");
            recFill(room, 3, 1);
            printRoom(room);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static char[][] loadRoomFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String[] dimensions = reader.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        char[][] room = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = reader.readLine();
            room[i] = line.toCharArray();
        }

        reader.close();
        return room;
    }

    public static void printRoom(char[][] room) {
        for (char[] row : room) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}