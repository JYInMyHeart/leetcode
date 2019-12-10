package graph;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: xck
 * @File: CourseScheduleIII
 * @Time: 11:46 2019/12/10
 */
public class CourseScheduleIII {
    public static int scheduleCourse(int[][] courses) {
        if (courses.length == 0) return 0;
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));


        int time = 0;
        int count = 0;
        for (int i = 0; i < courses.length; i++) {
            if(time + courses[i][0] <= courses[i][1]){
                time += courses[i][0];
                courses[count++] = courses[i];
            }else{
                int max_i = i;
                for (int j = 0; j < count; j++) {
                    if(courses[j][0] > courses[max_i][0]){
                        max_i = j;
                    }
                }
                time += courses[i][0] - courses[max_i][0];
                courses[max_i] = courses[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[][] a = {
//                {100, 200},
//                {200, 1300},
//                {1000, 1250},
//                {2000, 3200}
//        };
        int[][] a = {
                {5,5},
                {4,6},
                {2,6}
        };
        System.out.println(scheduleCourse(a));
    }

}
