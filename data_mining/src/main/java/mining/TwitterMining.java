package mining;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TwitterMining {
	
	private Twitter twitterInstance;

	public Twitter getTwitterInstance() {
		return twitterInstance;
	}

	public void setTwitterInstance(Twitter twitterInstance) {
		this.twitterInstance = twitterInstance;
	}

	
	public TwitterMining(Twitter twitterInstance) {
		super();
		this.twitterInstance = twitterInstance;
	}

	public List<Status> searchFor(String word) throws TwitterException {
      Query query = new Query(word);
      QueryResult result;
      List<Status> tweets = new ArrayList<>();
      do {
         result = twitterInstance.search(query);
         tweets = result.getTweets();
      } while ((query = result.nextQuery()) != null);
   
      return tweets;
	
	}
	
	@Override
	public String toString() {
		return "TwitterMining [twitterInstance=" + twitterInstance + "]";
	}
	
}
