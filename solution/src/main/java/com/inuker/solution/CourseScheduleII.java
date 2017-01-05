package com.inuker.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by dingjikerbo on 2016/12/17.
 */

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] f : prerequisites) {
            int from = f[1], to = f[0];
            Set<Integer> set = map.get(from);
            if (set == null) {
                set = new HashSet<>();
                map.put(from, set);
            }
            /**
             * 这里要防止同一条边计了多次
             */
            if (set.add(to)) {
                indegree[to]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer n = queue.poll();
            list.add(n);
            Set<Integer> set = map.get(n);
            if (set != null) {
                for (Integer k : set) {
                    if (--indegree[k] == 0) {
                        queue.add(k);
                    }
                }
            }
        }
        if (list.size() != numCourses) {
            return new int[0];
        }
        int[] f = new int[numCourses];
        for (int i = 0; i < f.length; i++) {
            f[i] = list.get(i);
        }
        return f;
    }
}
