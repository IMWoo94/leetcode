class Solution {
    static class Point {
		double distance;
		int[] point;

		public Point(double distance, int[] point) {
			this.distance = distance;
			this.point = point;
		}
	}
    
    public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.distance));

		// 좌표 목록으로 거리와 좌표 정보를 Point 객체로 생성하고 우선순위 큐에 넣기
		for (int[] point : points) {
			double dis = Math.sqrt(Math.pow((0 - point[0]), 2) + Math.pow((0 - point[1]), 2));
			pq.add(new Point(dis, point));
		}

		int[][] answer = new int[k][];

        for(int i = 0; i< k; i++){
            answer[i] = pq.poll().point;
        }
        
		return answer;
    }
}