//input is array or list
//is k much smaller than n
//answer needs to be sorted?


import java.util.*;
//time:nlogn   space:k
class Point {
    int x, y;
    Point() {
        this.x = 0;
        this.y = 0;
    }
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
	Solution() {}

    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        if (points == null || points.length == 0) {
            return points;
        }

        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                int diff = getDistance(b, origin) - getDistance(a, origin);
                if (diff == 0) {
                    diff = b.x - a.x;
                }
                if (diff == 0) {
                    diff = b.y - a.y;
                }
                return diff;
            }
        });

        for (Point point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        /* if it doesn't need to be sorted
        Point[] array = new Point[0];
        Point[] results = pq.toArray(array);
        */
        
        k = pq.size();
        Point[] results = new Point[k];
        while (!pq.isEmpty()) {
            results[--k] = pq.poll();
        }

        return results;
    }

    private int getDistance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

	public static void main(String[] args) {
		Solution solution = new Solution();

		Point point1 = new Point(4, 6);
		Point point2 = new Point(4, 7);
		Point point3 = new Point(4, 4);
		Point point4 = new Point(2, 5);
		Point point5 = new Point(1, 1);
		Point[] points = new Point[] {point1, point2, point3, point4, point5};
		Point origin = new Point(0, 0);
		int k = 3;

		Point[] results = solution.kClosest(points, origin, k);

		for (Point point : points) {
			System.out.print(point.x);
			System.out.print(",");
			System.out.println(point.y);
		}
	}
}
