package LC6.changhoi;

class Solution {
    public static void main(String[] args) {
        new Solution().convert("A", 1);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int up = numRows - 2;
        int round = numRows + up;
        boolean done = false;
        for (int i = 0; i < s.length(); i += round) {
            int idx = i;
            for (int j = 0; j < numRows; j++) {
                if (idx >= s.length()) {
                    done = true;
                    break;
                }
                sbs[j].append(s.charAt(idx));
                idx++;
            }
            if (done || idx == s.length()) break;

            for (int j = 0; j < up; j++) {
                if (idx >= s.length()) {
                    done = true;
                    break;
                }
                sbs[numRows - j - 2].append(s.charAt(idx));
                idx++;
            }
            if (done || idx == s.length()) break;
        }


        for (int i = 1; i < numRows; i++) {
            sbs[0].append(sbs[i]);
        }

        return sbs[0].toString();
    }
}
