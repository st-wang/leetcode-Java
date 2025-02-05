import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ProductOfArrayTest {
    private ProductOfArray test = new ProductOfArray();

    @Test
    public void productExceptSelf_division() {
        int[] nums = {-1, 0, 1, 2, 3};

        assertThat(test.productExceptSelf_division(nums)).containsExactly(0, -6, 0, 0, 0);
    }

    @Test
    public void productExceptSelf_division_2() {
        int[] nums = {1, 2, 4, 6};

        assertThat(test.productExceptSelf_division(nums)).containsExactly(48, 24, 12, 8);
    }

    @Test
    public void productExceptSelf_division_3() {
        int[] nums = {0, 0};

        assertThat(test.productExceptSelf_division(nums)).containsExactly(0, 0);
    }

    @Test
    public void productExceptSelf_division_4() {
        int[] nums = {0, 8, 0};

        assertThat(test.productExceptSelf_division(nums)).containsExactly(0, 0, 0);
    }
}