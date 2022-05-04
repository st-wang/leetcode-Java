import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HashMap {

    private String keys;
    private String values;

    public HashMap() {
        this.values = "";
        this.keys = "";
    }

    public void put(int key, int value) {
        String sKey = String.valueOf(key);
        String sValue = String.valueOf(value);

        if (keys.contains(sKey)) {
            values.replace(sKey, sValue);
        } else {
            keys += sKey;
            values += sValue;
        }
    }

    public int get(int key) {
        String sKey = String.valueOf(key);

        if (keys.contains(sKey)) {
            int index = keys.indexOf(sKey);
            return Integer.parseInt(String.valueOf(values.charAt(index)));
        } else {
            return -1;
        }
    }

    public void remove(int key) {
        String sKey = String.valueOf(key);

        int index = keys.indexOf(sKey);

        if (keys.contains(sKey)) {
            keys = keys.replace(sKey, "");
            values = values.replace(String.valueOf(values.charAt(index)), "");
        }
    }
}