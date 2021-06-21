package com.example.tkustaff.game;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.MediaController;
import android.widget.VideoView;

public class Teach extends AppCompatActivity {
    private float x_01,x_02,y_01,y_02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teach);


        VideoView videoView = (VideoView) this.findViewById(R.id.videoView);
        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.eeee));


        videoView.requestFocus();
        videoView.start();
    }


    public boolean onTouchEvent(MotionEvent event)
    {
        float x = event.getX();
        float y = event.getY();
        switch(event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                x_01 = x;
                y_01 = y;
                break;

            case MotionEvent.ACTION_UP:
                x_02 = x;
                y_02 = y;

                if(x_01!=0 && y_01!=0) {
                    if(x_01-x_02>8) {
                        Intent intent = new Intent();
                        intent.setClass(Teach.this  , people.class);
                        startActivity(intent);  //向右滑
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }

                    if(x_01-x_02<-8) { Intent intent = new Intent();
                        intent.setClass(Teach.this  , Even_Game.class);
                        startActivity(intent);    //向左滑
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }
                }
                break;

            case MotionEvent.ACTION_MOVE:
                break;

            default:
                break;

        }
        return super.onTouchEvent(event);
    }
}
