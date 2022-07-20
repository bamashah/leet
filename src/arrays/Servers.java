package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Servers {
    static int[][] solution(int[] jobs, int servers) {
        List<Job> jobsList = new ArrayList<>();
        List<Server> serversList = new ArrayList<>();

        for (int i = 0; i < jobs.length; i++) {
            jobsList.add(new Job(i, jobs[i]));
        }

        for (int i = 0; i < servers; i++) {
            serversList.add(new Server(i));
        }

        Collections.sort(jobsList, (a, b) -> b.weight-a.weight);

        for (Job job : jobsList) {
            System.out.println (job);

            serversList.get(0).assign(job.weight, job.originalIndex);
            Collections.sort(serversList);
            System.out.println (serversList);
        }

        int count = 0;
        int[][] result = new int[servers][];

        for (Server s : serversList) {
            List<Integer> joblist = s.jobs;
            int[] xxx = new int[joblist.size()];

            for (int i = 0; i < joblist.size(); i++) {
                xxx[i] = joblist.get(i);
            }

            result[count++] = xxx;
        }

        return result;
    }


    public static void main(String[] args) {
        int[] arr = {15, 30, 15, 5, 10};

        System.out.println (solution(arr, 3));
    }
}


class Job {
    int originalIndex;
    int weight;

    Job (int index, int weight) {
        originalIndex = index;
        this.weight = weight;
    }
}

class Server implements Comparable<Server>{
    int id;
    List<Integer> jobs;
    int total;

    Server (int id) {
        this.id = id;
        total = 0;
        jobs = new ArrayList<>();
    }

    void assign (int job, int index) {
        total = total + job;
        jobs.add(index);
        System.out.println (id + " " + jobs);
    }

    public String toString() {
        return (id + " " + total);
    }


    public int compareTo(Server s) {
        if (this.total > s.total) {
            return 1;
        } else if (this.total < s.total) {
            return -1;
        }

        if (id > s.id)
            return 1;
        else if (id < s.id)
            return -1;

        return 0;
    }
}