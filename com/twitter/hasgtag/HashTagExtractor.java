package com.twitter.hasgtag;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HashTagExtractor {
    public HashTagExtractor() {
    }

    public void extract() {
        String fileName = "D:\\Programming\\Java\\3JavaInteractiveCourses\\twitterDataAnalyzer\\src\\com\\twitter\\hasgtag\\data.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName)))
        {

            String currLine;
            List<String> hashtags = new ArrayList<>();

            while ((currLine = bufferedReader.readLine()) != null)
            {
                String[] words = currLine.split(" ");
                for(String word: words) {
                    if(word.contains("#") && word.indexOf("#") == 0 && !hashtags.contains(word)) {
                        hashtags.add(word);
                    }
                }
            }

            hashtags.sort(String::compareTo);

            for(String hashtag: hashtags) {
                // System.out.println(hashtag);
            }

            System.out.println(hashtags.size());

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
