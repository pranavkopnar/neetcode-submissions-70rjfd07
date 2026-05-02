class Solution {
    Map<String, Boolean> map = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict);
    }

    private boolean dfs(String s, List<String> wordDict) {

        if (s == "")
            return true;

        if (map.containsKey(s))
            return map.get(s);

        boolean isValid = false;

        for (String word : wordDict) {
            int i = s.indexOf(word);
            if (i != -1) {
                int l = word.length();
                String str1 = s.substring(0 , i);
                String str2 = "";
                if ((i+l) < s.length())
                    str2 = s.substring(i+l);
            
                isValid = dfs(str1, wordDict) && dfs(str2, wordDict);
                if (isValid)
                    break;
            }
        }

        map.put(s, isValid); 
        return isValid;
    }
}