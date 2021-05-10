package stockanalyzer.downloader;

import java.util.List;

public class SequentialDownloader extends Downloader {

    @Override
    public int process(List<String> tickers) {
        long startTime = System.nanoTime();

        int count = 0;
        for (String ticker : tickers) {
            String fileName = saveJson2File(ticker);
            if(fileName != null)
                count++;
        }
        long seqTime = System.nanoTime() - startTime;
        System.out.println("Sequential time:  " + seqTime/1000 + " microseconds.");

        return count;
    }
}
