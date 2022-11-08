package LC28.changhoi;

class Solution {
    public int strStr(String haystack, String needle) {
        int nlen = needle.length();
        int hlen = haystack.length();

        if (hlen < nlen) return -1;
        if (hlen == nlen) {
            if (haystack.equals(needle)) return 0;
            else return -1;
        }


        for (int i = 0; i < haystack.length(); i++) {
            if (i + nlen > hlen) return -1;
            if (haystack.substring(i, i + nlen).equals(needle)) return i;
        }

        return -1;
    }
}
