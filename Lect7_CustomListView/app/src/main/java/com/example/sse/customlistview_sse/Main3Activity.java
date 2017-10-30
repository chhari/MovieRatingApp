package com.example.sse.customlistview_sse;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

public class Main3Activity extends AppCompatActivity {

    VideoView myVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        String myVideoName = "khan";
        String myAppPackage = "com.example.sse.customlistview_sse";
        myVideo = (VideoView) findViewById(R.id.videoView);
        Uri myVideoUri = Uri.parse("android.resource://"+myAppPackage+"/raw/"+myVideoName);
        myVideo.setVideoURI(myVideoUri);
        myVideo.start();

    }
}
