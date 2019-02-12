import java.math.BigDecimal;
import java.math.BigInteger;

public class MultiplyTwoStrings {

    public String multiply(String num1, String num2) {
        String smallerString = findSmallerString(num1, num2);
        int length = smallerString.length();
        BigInteger biggerNumber = smallerString.equals(num1) ? new BigInteger(num2) : new BigInteger(num1);
        BigInteger result = new BigInteger("0");
        int i;

        for (i = length - 1; i >= 0; i--) {
            String currentNumberCharString = String.valueOf((smallerString.charAt(i) - '0'));
            BigInteger currentNumberCharBigInteger = new BigInteger(currentNumberCharString);
            BigInteger currentMultiplyBigInteger =
                    BigDecimal.valueOf(Math.pow(10, length - i - 1)).toBigInteger().multiply(currentNumberCharBigInteger);
            BigInteger stepResult = biggerNumber.multiply(currentMultiplyBigInteger);
            result = result.add(stepResult);
        }

        return result.toString();
    }

    public String multiply2(String num1, String num2) {
        String smallerString = findSmallerString(num1, num2);
        int length = smallerString.length();
        BigInteger biggerNumber = smallerString.equals(num1) ? new BigInteger(num2) : new BigInteger(num1);
        BigInteger result = new BigInteger("0");
        int i;

        for (i = length - 1; i >= 0; i--) {
            String currentNumberCharString = String.valueOf((smallerString.charAt(i) - '0'));
            BigInteger currentNumberCharBigInteger = new BigInteger(currentNumberCharString);
            BigInteger currentMultiplyBigInteger =
                    BigDecimal.valueOf(Math.pow(10, length - i - 1)).toBigInteger().multiply(currentNumberCharBigInteger);
            BigInteger stepResult = biggerNumber.multiply(currentMultiplyBigInteger);
            result = result.add(stepResult);
        }

        return result.toString();
    }

    private static String findSmallerString(String s1, String s2) {
        return s1.length() < s2.length() ? s1 : s2;
    }

}
