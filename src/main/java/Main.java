import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {

        String s = "cc";
        System.out.println(firstUniqChar(s));

        int[] nums = new int[]{1, 1, 0, 1};
        System.out.println(nums[0]);
        //System.out.println(findMaxConsecutiveOnes(nums));


        //System.out.println(addStrings(testString, testString2));

        //Parent p = new Parent();
        Child c = new Child();
        Parent pc = new Child();

        /*p.print(p);
        p.print(c);
        p.print(pc);
        c.print(p);
        c.print(c);
        c.print(pc);
        System.out.println("///");
        pc.print(p);
        pc.print(c);
        pc.print(pc);*/

        Set<String> stringSet = new HashSet<>();
        List<String> stringList = new ArrayList<>();
        //Map<String, String> stringStringMap = new HashMap<>();

        stringSet.add("1");
        Iterator iterable = stringSet.iterator();
    }

    //*******************************************************************************************

    public static int firstUniqChar(String s) {
        //int index = -1;
        //int length = s.length;
        String current = "";

        for(int i = 0; i < s.length(); i++) {
            current = s.charAt(i) + "";
            if (s.lastIndexOf(current) == s.indexOf(current)) {
                return i;
            }
        }
        return -1;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        List<Integer> zeros = new ArrayList<Integer>();
        int j = 0;
        int distance = 0;

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros.set(j, i);
                System.out.println("zeros.get(j)" + zeros.get(j));
                distance = Math.max(j == 0 ? zeros.get(j) : zeros.get(j) - zeros.get(j-1), distance);
                j++;
                System.out.println("distance:" + distance);
            }
        }

        return distance;
    }

    public static String addStrings(String num1, String num2) {
        int size1 = num1.length();
        int size2 = num2.length();
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        int i, j;

        for (i = size1 - 1, j = size2 - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int currentInNum1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int currentInNum2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int result = (currentInNum1 + currentInNum2 + carry) % 10;
            carry = (currentInNum1 + currentInNum2 + carry) / 10;

            stringBuilder.append(result);

        }

        return stringBuilder.reverse().toString();
    }


}
