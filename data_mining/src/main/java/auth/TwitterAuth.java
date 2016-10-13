package auth;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAuth {

	String consumerKey;
	String consumerSecret;
	String accessToken;
	String tokenSecret;
	
	
	public TwitterAuth(String consumerKey, String consumerSecret, String accessToken, String tokenSecret) {
		super();
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
		this.accessToken = accessToken;
		this.tokenSecret = tokenSecret;
	}


	public String getConsumerKey() {
		return consumerKey;
	}


	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}


	public String getConsumerSecret() {
		return consumerSecret;
	}


	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public String getTokenSecret() {
		return tokenSecret;
	}


	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}
	
	public Twitter getAuthentication(){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		        .setOAuthConsumerKey(consumerKey)
		        .setOAuthConsumerSecret(consumerSecret)
		        .setOAuthAccessToken(accessToken)
		        .setOAuthAccessTokenSecret(tokenSecret);

		Twitter twitterInstance = new TwitterFactory(cb.build()).getInstance();
		return twitterInstance;
	}
	
}
