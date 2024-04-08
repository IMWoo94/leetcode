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
            // 거리를 계산하는 값에서 굳이 Math.sqrt 제곱근 처리를 하지 않아도 결과는 동일하다. 그러므로 불필요한 작업을 제외하면서 좀더 나은 성능을 기대해볼만한다.
			double dis = Math.pow((0 - point[0]), 2) + Math.pow((0 - point[1]), 2);
			pq.add(new Point(dis, point));
		}

		int[][] answer = new int[k][];

        for(int i = 0; i< k; i++){
            answer[i] = pq.poll().point;
        }
        
		return answer;
    }
}