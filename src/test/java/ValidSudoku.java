import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    //You are given a a 9 x 9 Sudoku board board.
    //A Sudoku board is valid if the following rules are followed:
    //
    //Each row must contain the digits 1-9 without duplicates.
    //Each column must contain the digits 1-9 without duplicates.
    //Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
    //
    // Return true if the Sudoku board is valid, otherwise return false
    //
    //Note: A board does not need to be full or be solvable to be valid.

    //Example:
    //Input: board =
    //[["1","2",".",".","3",".",".",".","."],
    // ["4",".",".","5",".",".",".",".","."],
    // [".","9","8",".",".",".",".",".","3"],
    // ["5",".",".",".","6",".",".",".","4"],
    // [".",".",".","8",".","3",".",".","5"],
    // ["7",".",".",".","2",".",".",".","6"],
    // [".",".",".",".",".",".","2",".","."],
    // [".",".",".","4","1","9",".",".","8"],
    // [".",".",".",".","8",".",".","7","9"]]
    //
    //Output: true

    //Constraints:
    //
    //board.length == 9
    //board[i].length == 9
    //board[i][j] is a digit 1-9 or '.'.

    public boolean isValidSudoku_naive(char[][] board) {
        int line = 0, column = 0;

        // Check each line
        while (line < 9) {
            Set<Character> set = new HashSet<>();
            column = 0;
            while (column < 9) {
                if (board[line][column] == '.') {
                    continue;
                }
                if (set.contains(board[line][column])) {
                    return false;
                }
                set.add(board[line][column]);
                column++;
            }
            line++;
        }

        column = 0;
        // Check each column
        while (column < 9) {
            Set<Character> set = new HashSet<>();
            line = 0;
            while (line < 9) {
                if (board[column][line] == '.') {
                    line++;
                } else if (set.contains(board[column][line])) {
                    return false;
                } else {
                    set.add(board[column][line]);
                    line++;
                }
            }
            column++;
        }

        // Check each 3x3
        column = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 2; i < 9; i = i + 3) {
            set.clear();
            while (column <= i) {
                line = 0;
                while (line <= i) {
                    if (board[column][line] == '.') {
                        line++;
                    } else if (set.contains(board[column][line])) {
                        return false;
                    } else {
                        set.add(board[column][line]);
                        line++;
                    }
                }
                column++;
            }

            while (line <= i) {
                column = 0;
                while (column <= i) {
                    if (board[line][column] == '.') {
                        column++;
                    } else if (set.contains(board[line][column])) {
                        return false;
                    } else {
                        set.add(board[line][column]);
                        column++;
                    }
                }
                line++;
            }
        }
        return true;
    }


    public boolean isValidSudoku_smart(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                String square_key = (r / 3) + "_" + (c / 3);

                /*
                if (rows.get(r).contains(board[r][c])  // --> will have NPE when first loop: the Set<Character> is not initialised yet
                        || columns.get(c).contains(board[r][c])
                        || squares.get(square_key).contains(board[r][c])) {
                    return false;
                }
                */

                if (rows.computeIfAbsent(r, set -> new HashSet<>()).contains(board[r][c])
                        // --> during first loop, the key r is absent, computeIfAbsent() will put r into the map
                        // and call the function to create a new Set. Then the empty Set is returned and contains() gets called (and it returns false)
                        // --> for other loops, the key r exists already, computeIfAbsent() will just return the value of the existing Set.
                        // Then Set.contains() is called, and we check the value.
                        || columns.computeIfAbsent(c, set -> new HashSet<>()).contains(board[r][c])
                        || squares.computeIfAbsent(square_key, set -> new HashSet<>()).contains(board[r][c])) {
                    return false;
                }

                rows.get(r).add(board[r][c]);
                columns.get(c).add(board[r][c]);
                squares.get(square_key).add(board[r][c]);
            }
        }

        return true;
    }
}
