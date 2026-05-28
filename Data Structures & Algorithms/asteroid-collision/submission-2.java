class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        int j = -1;

        for (int a : asteroids) {

            while (j >= 0 && asteroids[j] > 0 && a < 0) {
                int lasta = asteroids[j];
                if (lasta > Math.abs(a)) {
                    a = 0;
                    break;
                } else if (lasta < Math.abs(a)) {
                    j--;
                } else {
                    j--;
                    a = 0;
                    break;
                }
            }

            if (a != 0)
                asteroids[++j] = a;
        }

        return Arrays.copyOfRange(asteroids, 0 , j+1);
    }
}