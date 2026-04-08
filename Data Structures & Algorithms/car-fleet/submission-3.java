class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));
        
        for (int i=0; i<position.length; i++) {
            pq.add(new int[]{position[i], speed[i]});
        }

        ArrayDeque<Float> stack = new ArrayDeque<>();

        while(!pq.isEmpty()) {
            int[] car = pq.poll();
            float time = (float) (target - car[0])/car[1];

            if (stack.isEmpty() || (time > stack.getLast())) {
                    stack.add(time);
            }
        }

        return stack.size();
    }
}
