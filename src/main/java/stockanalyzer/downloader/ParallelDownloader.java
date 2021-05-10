package stockanalyzer.downloader;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelDownloader extends Downloader {

    @Override
    public int process(List<String> ticker) {
        long startTime = System.nanoTime();

        ExecutorService executor = Executors.newFixedThreadPool(4);
        int count = 0;
        for (String tic : ticker) {
            try{
                Future<?> tasks = executor.submit(()->{saveJson2File(tic);});
                count++;
            }catch(Exception e){
            }
        }

        long parallelTime = System.nanoTime() - startTime;

        System.out.println("Parallel time: " + parallelTime/1000 + " microseconds.");

        return count;
    }
}