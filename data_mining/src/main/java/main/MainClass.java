package main;

import mining.TwitterMining;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;

import auth.TwitterAuth;

public class MainClass {
	
	public static void main(String[] args){	
		String consumerKey = "0RiRn1pm65YRxIPoJdKYodtfZ";
		String consumerSecret = "VHDWLIWv6TtZnySrHfOldQzlxUV0sFDiGvitb4fcJJqtedOsrj";
		String accessToken = "269370297-yjJbxnHCIK1GY2BE5mgG74DWbxwd1l7PM1RH1YxB";
		String tokenSecret = "Sddy9nRrz04daa82rTnyNakMUkbLq6zVKuJ4QoqrWoJIu";
		
		TwitterAuth auth = new TwitterAuth(consumerKey,consumerSecret,accessToken,tokenSecret);
		TwitterMining mineria = new TwitterMining(auth.getAuthentication());
		String wordToSearch = "pollution";
		List<Status> tweets = new ArrayList<>();
		try {
			tweets = mineria.searchFor(wordToSearch);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		for (Status tweet : tweets) {
            System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
        }
	}
}
