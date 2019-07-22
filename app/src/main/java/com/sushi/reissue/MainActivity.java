package com.sushi.reissue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (!TwitterUtils.hasAccessToken(this)) {
      /* AccessToken をまだ持っていないときの処理 */
      Intent intent = new Intent(getApplication(), TwitterOAuthActivity.class);
      startActivity(intent);
      finish();
    } else {
      Intent intent = new Intent(getApplication(), TimetableActivity.class);
      startActivity(intent);
      finish();
    }
  }
}
