package com.twitter.maxtweets;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TwitterUserMaxTweets {

    public void extract() {
        String fileName = "D:\\Programming\\Java\\3JavaInteractiveCourses\\twitterDataAnalyzer\\src\\com\\twitter\\maxtweets\\data.json";

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(fileName))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray tweeterList = (JSONArray) obj;

            Map<String, Integer> userToTweetCount = new HashMap<>();

            //Iterate over tweets array
            tweeterList.forEach( tweet -> {
                JSONObject tweetObject = (JSONObject) tweet;
                String user = (String) tweetObject.get("user");

                if(!userToTweetCount.containsKey(user)) {
                    userToTweetCount.put(user, 1);
                }
                else {
                    int count = userToTweetCount.get(user);
                    userToTweetCount.replace(user, count, ++count);
                }
            } );

            Integer maxTweet = 0;
            String maxTweetUser;

            maxTweetUser = userToTweetCount.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
            maxTweet = userToTweetCount.get(maxTweetUser);

            System.out.println("User with maximum " + maxTweet + " tweets is: " + maxTweetUser);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseTweeterObject(JSONObject tweetObject)
    {
        //Get employee first name
        String firstName = (String) tweetObject.get("user");
        System.out.println(firstName);

        //Get employee last name
        String lastName = (String) tweetObject.get("tweet");
        System.out.println(lastName);
    }
}
