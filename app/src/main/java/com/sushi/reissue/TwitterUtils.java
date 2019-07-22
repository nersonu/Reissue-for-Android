package com.sushi.reissue;

import android.content.Context;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class TwitterUtils {
  private static final String TOKEN = "token";
  private static final String TOKEN_SECRET = "tokenSecret";
  private static final String PREF_NAME = "twitterAccessToken";

  /* Twitter インスタンスの取得 */
  public static Twitter getTwitterInstance(Context context) {
    String consumerKey = context.getString(R.string.twitterConsumerKey);
    String consumerSecret = context.getString(R.string.twitterConsumerSecret);

    TwitterFactory factory = new TwitterFactory();
    Twitter twitter = factory.getInstance();
    twitter.setOAuthConsumer(consumerKey, consumerSecret);

    if (hasAccessToken(context)) {
      twitter.setOAuthAccessToken(loadAccessToken(context));
    }

    return twitter;
  }

  /* AccessToken を prefarence に保存 */
  public static void sroreAccessToken(Context context, AccessToken accessToken) {
    SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    Editor editor = preferences.edit();
    editor.putString(TOKEN, accessToken.getToken());
    editor.putString(TOKEN_SECRET, accessToken.getTokenSecret());
    editor.commit();
  }

  /* AccessToken を prefarence から読込 */
  public static AccessToken loadAccessToken(Context context) {
    SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    String token = preferences.getString(TOKEN, null);
    String tokenSecret = preferences.getString(TOKEN_SECRET, null);
    if (token != null && tokenSecret != null) {
      return new AccessToken(token, tokenSecret);
    } else {
      return null;
    }
  }

  /* AccessToken があれば true を返す */
  public static boolean hasAccessToken(Context context) {
    return loadAccessToken(context) != null;
  }
}

