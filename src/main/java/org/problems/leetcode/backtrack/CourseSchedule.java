package org.problems.leetcode.backtrack;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        return true;
    }
    public static void main(String[] args) {
        int[][] prereq = {{0,1},{1,0}};
        System.out.println("Is possible to finish all courses " + canFinish(2, prereq));
    }
}
