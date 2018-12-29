package com.example.fly.performancetesting;

import android.app.Application;
import android.graphics.Color;
import android.util.Log;
import jp.wasabeef.takt.Audience;
import jp.wasabeef.takt.Seat;
import jp.wasabeef.takt.Takt;


public class SampleApplication extends Application {
    public Takt.Program stock;
  @Override public void onCreate() {
    super.onCreate();

//      stock = Takt.stock(this)
//              .seat(Seat.BOTTOM_RIGHT)
//              .interval(250)
//              .color(Color.RED)
//              .size(14f)
//              .alpha(.5f);


    Takt.stock(this)
        .seat(Seat.TOP_RIGHT)
        .interval(500)
        .color(Color.WHITE)
        .size(14f)
        .alpha(.5f)
        .listener(new Audience() {
          @Override public void heartbeat(double fps) {
            Log.e("Excellent!", fps + " fps");
          }
        })
        .useCustomControl();
  }
}
