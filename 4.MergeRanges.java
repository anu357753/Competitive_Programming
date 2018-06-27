import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static class Meeting implements Comparable<Meeting> {

        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Meeting)) {
                return false;
            }
            final Meeting meeting = (Meeting) o;
            return startTime == meeting.startTime && endTime == meeting.endTime;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + startTime;
            result = result * 31 + endTime;
            return result;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", startTime, endTime);
        }
        
        public int compareTo(Meeting obj)
        {
            if (this.startTime < obj.startTime) {
                return -1;
            }

            if (this.startTime == obj.startTime) {
                return 0;
            }
            return 1;
        }
    }

    public static List<Meeting> mergeRanges(List<Meeting> meetings) {

       ArrayList<Meeting> res = new ArrayList<Meeting>();

        if (meetings.size() <= 1)
        {
            return meetings;
        }

        Collections.sort(meetings);

        for (int i = 0; i < meetings.size()-1; i++) 
        {
            int startTime1 = meetings.get(i).getStartTime();
            int endTime1 = meetings.get(i).getEndTime();
            int startTime2 = meetings.get(i+1).getStartTime();
            int endTime2 = meetings.get(i+1).getEndTime();

            if (endTime1 >= startTime2) 
            {
                meetings.get(i+1).setStartTime(Math.min(startTime1,startTime2));
                meetings.get(i+1).setEndTime(Math.max(endTime1,endTime2));

                meetings.get(i).setStartTime(Integer.MIN_VALUE);
                meetings.get(i).setEndTime(Integer.MIN_VALUE);
            }
        }

        Meeting test = new Meeting(Integer.MIN_VALUE,Integer.MIN_VALUE);

        for (int i = 0; i < meetings.size() ; i++ ) {
            if (!meetings.get(i).equals(test)) {
                res.add(meetings.get(i));
            }
        }
        
 
        return res;
    }

















    // tests

    @Test
    public void meetingsOverlapTest() {
        final List<Meeting> meetings = Arrays.asList(new Meeting(1, 3), new Meeting(2, 4));
        final List<Meeting> actual = mergeRanges(meetings);
        final List<Meeting> expected = Arrays.asList(new Meeting(1, 4));
        assertEquals(expected, actual);
    }

    @Test
    public void  meetingsTouchTest() {
        final List<Meeting> meetings = Arrays.asList(new Meeting(5, 6), new Meeting(6, 8));
        final List<Meeting> actual = mergeRanges(meetings);
        final List<Meeting> expected = Arrays.asList(new Meeting(5, 8));
        assertEquals(expected, actual);
    }

    @Test
    public void meetingContainsOtherMeetingTest() {
        final List<Meeting> meetings = Arrays.asList(new Meeting(1, 8), new Meeting(2, 5));
        final List<Meeting> actual = mergeRanges(meetings);
        final List<Meeting> expected = Arrays.asList(new Meeting(1, 8));
        assertEquals(expected, actual);
    }

    @Test
    public void meetingsStaySeparateTest() {
        final List<Meeting> meetings = Arrays.asList(new Meeting(1, 3), new Meeting(4, 8));
        final List<Meeting> actual = mergeRanges(meetings);
        final List<Meeting> expected = Arrays.asList(
            new Meeting(1, 3), new Meeting(4, 8)
        );
        assertEquals(expected, actual);
    }

    @Test
    public void multipleMergedMeetingsTest() {
        final List<Meeting> meetings = Arrays.asList(
            new Meeting(1, 4), new Meeting(2, 5), new Meeting (5, 8));
        final List<Meeting> actual = mergeRanges(meetings);
        final List<Meeting> expected = Arrays.asList(new Meeting(1, 8));
        assertEquals(expected, actual);
    }

    @Test
    public void meetingsNotSortedTest() {
        final List<Meeting> meetings = Arrays.asList(
            new Meeting(5, 8), new Meeting(1, 4), new Meeting(6, 8));
        final List<Meeting> actual = mergeRanges(meetings);
        final List<Meeting> expected = Arrays.asList( 
            new Meeting(1, 4), new Meeting(5, 8)
        );
        assertEquals(expected, actual);
    }

    @Test
    public void sampleInputTest() {
        final List<Meeting> meetings = Arrays.asList(
            new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8),
            new Meeting(10, 12), new Meeting(9, 10) 
        );
        final List<Meeting> actual = mergeRanges(meetings);
        final List<Meeting> expected = Arrays.asList( 
            new Meeting(0, 1), new Meeting(3, 8), new Meeting(9, 12)
        );
        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}