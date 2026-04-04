class Solution {

    static String getStringKey(String s) {
        StringBuilder str = new StringBuilder("");
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i=0; i<26; i++) {
            str.append(freq[i]).append("#");
        }

        return str.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();

        for (int i=0; i<strs.length; i++) {
            String key = getStringKey(strs[i]);
            
            if (!map.containsKey(key)) {
                map.put(key, list.size());
                list.add(new ArrayList<>());
            }

            list.get(map.get(key)).add(strs[i]);
        }

        return list;
    }
}
