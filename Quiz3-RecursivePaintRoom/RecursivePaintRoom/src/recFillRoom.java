public class RecursiveRoomFill {
    public static void recFill(char[][] room, int row, int col) {
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

    public static void main(String[] args) {
        char[][] room1 = {
            "##########".toCharArray(),
            "#........#".toCharArray(),
            "####..####".toCharArray(),
            "#..#..#..#".toCharArray(),
            "####..#..#".toCharArray(),
            "#.....#..#".toCharArray(),
            "##########".toCharArray()
        };
        
        System.out.println("Test Case 1 - Before recFill(room, 3, 4):");
        printRoom(room1);
        
        recFill(room1, 3, 4);
        
        System.out.println("\nAfter recFill(room, 3, 4):");
        printRoom(room1);
    }
    
    private static void printRoom(char[][] room) {
        for (char[] row : room) {
            System.out.println(new String(row));
        }
    }
}
