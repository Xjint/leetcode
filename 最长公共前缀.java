import java.util.stream.Stream;

public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        return Stream.of(strs).reduce(this::go).orElse("");
    }

    //找到两个string的最长公共前缀
    public String go(String s1, String s2) {
        if (s1.equals("") || s2.equals("")) {
            return "";
        }
        int start = 0;
        int index = 0;
        while (index < Math.min(s1.length(), s2.length())) {
            if (s1.charAt(index) != s2.charAt(index)) {
                break;
            }
            ++index;
        }
        return s1.substring(start, index);
    }

    public String longestCommonPrefixV2(String[] strs) {
        //采用分治的思想，求左半边的ans，再求又半边的ans，然后两个ans再求公共部分
        return fenzhi(strs, 0, strs.length - 1);
    }

    private String fenzhi(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        } else {
            int mid = (right - left) / 2 + left;
            String a1 = fenzhi(strs, left, mid);
            String a2 = fenzhi(strs, mid + 1, right);
            return go(a1, a2);
        }
    }

}