class TimeMap {

    private String[][] map;

    public TimeMap() {
       this.map = new String[1002][2];
    }
    
    public void set(String key, String value, int timestamp) {
        map[timestamp][0] = key;
        map[timestamp][1] = value;
    }
    
    public String get(String key, int timestamp) {
        int r = timestamp;

        while (r >= 1) {
            if (map[r][0] != null && map[r][0].equals(key)) return map[r][1];
            r--;
        }

        return "";
    }
}
