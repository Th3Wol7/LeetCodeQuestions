package ZigZagConversion;

public class ZigZag {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuilder();
        }

        int index = 0;
        int step = 1;

        for (char c : s.toCharArray()) {
            res[index].append(c);
            if (index == 0) {
                step = 1;
            } else if (index == numRows - 1) {
                step = -1;
            }
            index += step;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : res) {
            result.append(sb);
        }
        return result.toString();
    }
}
