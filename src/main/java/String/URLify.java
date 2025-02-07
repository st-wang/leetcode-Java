package String;

public class URLify {

    String urlifyAString(String string) {
        String[] splitStrings = string.split(" ");

        int originLength = splitStrings.length - 1;
        StringBuilder urlifiedStringBuilder = new StringBuilder();

        for (String s: splitStrings) {
            originLength += s.length();
            if (!s.equals("")) {
                urlifiedStringBuilder.append(s).append("%20");
            }
        }

        urlifiedStringBuilder.delete(urlifiedStringBuilder.length() - 3,
                urlifiedStringBuilder.length());

        return urlifiedStringBuilder.toString();
    }
}
