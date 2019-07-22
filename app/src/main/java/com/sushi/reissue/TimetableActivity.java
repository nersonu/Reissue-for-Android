package com.sushi.reissue;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

public class TimetableActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_timetable);

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    //drawer.openDrawer(GravityCompat.START);
  }
}
