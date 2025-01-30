import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ValidSudokuTest {

    char[][] sudoku = {
            {'1','2','.','.','3','.','.','.','.'},
            {'4','.','.','5','.','.','.','.','.'},
            {'.','9','1','.','.','.','.','.','3'},
            {'5','.','.','.','6','.','.','.','4'},
            {'.','.','.','8','.','3','.','.','5'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','.','.','.','.','.','2','.','.'},
            {'.','.','.','4','1','9','.','.','8'},
            {'.','.','.','.','8','.','.','7','9'}
    };

    @Test
    public void test_non_valid_sudoku() {
        ValidSudoku test = new ValidSudoku();

        assertThat(test.isValidSudoku_naive(sudoku)).isFalse();
        assertThat(test.isValidSudoku_smart(sudoku)).isFalse();
    }
}