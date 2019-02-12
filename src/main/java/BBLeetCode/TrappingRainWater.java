package BBLeetCode;

import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater {

    //Given n non-negative integers representing an elevation map where the width of each bar is 1,
    //compute how much water it is able to trap after raining.
    //
    //For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
    //
    //https://gist.github.com/st-wang/44bf1b4e1908ee99683c949eeabfa888#42-trapping-rain-water

    int calculateTrappedWater(List<Integer> elevation) {
        List<Integer> bowlIndexes = new ArrayList<>();
        int quantity = 0;
        int left = -1, base = 25535, right = -1;

        for (int height: elevation) {
            if (height == 0) { //special for the case when first element = 0
                if (left != -1) { //when left board has been initialized
                    bowlIndexes.add(height);
                    base = Math.min(base, height);
                }
            }
            else {
                if (left == -1) { //put as left bord
                    left = height;
                    bowlIndexes.add(height);
                }
                else if(height < left) { //left bord exists, put as base
                    base = Math.min(base, height);
                    right = Math.max(right, height);
                    bowlIndexes.add(height);
                }
                else { //put as right bord
                    right = height;
                    bowlIndexes.add(height);

                    quantity += calculateTrappedQuantity(bowlIndexes, right);
                    bowlIndexes.clear();
                    left = right;
                    right = -1;
                    base = 65535;

                    bowlIndexes.add(left);
                }
            }
        }

        if (!bowlIndexes.isEmpty()) {
            quantity += calculateTrappedQuantity(bowlIndexes, right);
        }

        return quantity;
    }

    private int calculateTrappedQuantity(List<Integer> bowl, int right) {
        int left = bowl.get(0);
        //int lastHeight = bowl.get(bowl.size() - 1);
        int offset = bowl.size() - 1 - bowl.lastIndexOf(right); //if right is not the last element

        int effectiveMaxHeight = Math.min(left, right);
        int effectiveWidth = bowl.size() - 2 - offset;
        int quantityMax = effectiveMaxHeight * effectiveWidth;

        for (int i = 1; i < effectiveWidth + 1; i++) {
            quantityMax -= bowl.get(i);
        }

        return quantityMax;
    }
}
