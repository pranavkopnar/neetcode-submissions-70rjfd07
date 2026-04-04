class Solution {

    public String encode(List<String> strs) {

        StringBuilder str = new StringBuilder();

        for (int i=0; i<strs.size(); i++) {
            int l = strs.get(i).length();
            str.append(l).append("#").append(strs.get(i));
        }

        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        
        for (int i=0; i<str.length(); i++) {
            int k = i;
            while(str.charAt(k) != '#') {
                k++;
            }

            int l = Integer.parseInt(str,i,k,10);

            list.add(str.substring(k+1,k+1+l));
            i = k+l;
        }

        return list;
    }
}
