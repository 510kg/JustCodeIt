//task is class or 2d arry
//start < end? or start == end?


import java.util.*;
//time:nlogn  space:n
class Task {
	int start, end;
	Task(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class Time {
	int val, flag;
	Time(int val, int flag) {
		this.val = val;
		this.flag = flag;
	}
}

public class Solution {
	Solution() {}

	public int minMeetingRooms(Task[] tasks) {
		if (tasks == null || tasks.length == 0) {
			return 0;
		}

		List<Time> timeList = new ArrayList<Time>(tasks.length*2);
		for (Task task : tasks) {
			if (task.start >= task.end) continue;
			timeList.add(new Time(task.start, 1));
			timeList.add(new Time(task.end, 0));
		}

		Collections.sort(timeList, new Comparator<Time>() {
			@Override
			public int compare(Time t1, Time t2) {
				if (t1.val == t2.val) {
					return t1.flag - t2.flag;//hope to release the machine first
				}
				return t1.val - t2.val;
			}
		});

		int max = 0;
		int count = 0;
		for (Time time : timeList) {
			if (time.flag == 1) {
				count++;
			} else {
				count--;
			}
			max = Math.max(max, count);
		}

		return max;
	}


/*
	When input is an array

	class Time {
		int x;
		int flag;
		Time(int x, int flag) {
			this.x = x;
			this.flag = flag;
		}
	}

	public int scheduler(int[][] times) {
		if (times == null || times.length == 0 || times[0] == null || times[0].length == 0) {
			return 0;
		}

		List<Time> timeList = new ArrayList<Time>();
		for (int i = 0; i < times.length; i++) {
			for (int j = 0; j < times[0].length; j++) {
				int flag = (j == 0 ? 1 : 0);
				timeList.add(new Time(times[i][j], flag));
			}
		}
		Collections.sort(timeList, new Comparator<Time>() {
			@Override
			public int compare(Time t1, Time t2) {
				if (t1.x == t2.x) {
					return t1.flag - t2.flag;
				}
				return t1.x - t2.x;
			}
		});

		int max = 0, count = 0;
		for (Time time : timeList) {
			if (time.flag == 1) {
				count++;
			} else {
				count--;
			}
			max = Math.max(max, count);
		}

		return max;
	}
*/


	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] times = new int[][] {{2, 5}, {3, 6}, {5, 7}};
		int result = solution.scheduler(times);
		System.out.println(result);
	}
}