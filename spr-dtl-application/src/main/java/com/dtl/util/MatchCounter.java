package com.dtl.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author gschao
 * @date 2016/11/28 9:55.
 * 计算在路径子目录中包含一个关键字文件的数量
 */
public class MatchCounter implements Callable<Integer>{
    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;


    public MatchCounter(File directory, String keyword, ExecutorService pool){
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    public Integer call() throws Exception
    {
        count =0;
        try{
            File[] files = directory.listFiles();
            ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
            for (File file:files) {
                if(file.isDirectory()){
                    MatchCounter counter = new MatchCounter(file,keyword,pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);
                }else{
                    if(search(file)){
                        count ++;
                    }
                }

            }

            for (Future<Integer> result:results) {
                try{
                    count +=result.get();
                }catch (ExecutionException e){
                    e.printStackTrace();
                }

            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return count;
    }


    public boolean search(File file){

            try {
                Scanner in = new Scanner(new FileInputStream(file));
                boolean found = false;
                while(!found&&in.hasNext()){
                    String line = in.nextLine();
                    if(line.contains(keyword)){
                        found = true;
                    }
                }
                in.close();
                return found;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }

    }

}
