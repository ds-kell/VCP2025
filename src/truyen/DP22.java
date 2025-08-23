package truyen;

import java.util.ArrayList;
import java.util.List;

// Generate Parentheses
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, 0, 0, "", res);
        return res;
    }

    private void backtrack(int n, int open, int close, String s, List<String> res) {
        // n cặp thì chiều dài chuỗi là n*2
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        // cứ một mở thì cần một đóng
        if (open < n) {
            backtrack(n, open + 1, close, s + "(", res);
        }
        //
        if (close < open) {
            backtrack(n, open, close + 1, s + ")", res);
        }
    }
}