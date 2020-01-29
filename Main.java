import com.twitter.hasgtag.HashTagExtractor;
import com.twitter.maxtweets.TwitterUserMaxTweets;


public class Main {

    public static void main(String[] args) {

        HashTagExtractor hashTagExtractor = new HashTagExtractor();
        hashTagExtractor.extract();

        TwitterUserMaxTweets twitterUserMaxTweets = new TwitterUserMaxTweets();
        twitterUserMaxTweets.extract();


    }
}
