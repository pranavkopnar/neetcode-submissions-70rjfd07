class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new ArrayList<>();
        partition(s, res, new ArrayList<>(), 0);
        return res;
    }

    public void partition(String s, List<List<String>> res, List<String> partition, int j) {

        if (j == s.length()) {
            res.add(new ArrayList<>(partition));
            return;
        }

        for (int i = j; i < s.length(); i++) {

            if (!isPalindrome(s.substring(j, i+1)))
                continue;
            
            partition.add(s.substring(j, i+1));
            partition(s, res, partition, i+1);
            partition.remove(partition.size() - 1);
        }
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;
    }
}