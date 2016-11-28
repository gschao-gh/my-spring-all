package com.dtl.threadtest;

import com.dtl.util.MatchCounter;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author gschao
 * @date 2016/11/28 9:46.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入基础路径：");
        String directory = in.nextLine();
        System.out.println("输入关键字：");
        String keyword = in.nextLine();
        ExecutorService pool = Executors.newCachedThreadPool();

        MatchCounter counter = new MatchCounter(new File(directory),keyword,pool);
        Future<Integer> result = pool.submit(counter);
        try {
            System.out.println(result.get()+"matching files");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        pool.shutdown();
        int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
        System.out.println("largest pool size="+largestPoolSize);

    }
}
