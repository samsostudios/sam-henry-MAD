package com.example.sam.afinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class WebViewActivity extends Activity {
    private String workType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view2);

        Intent i = getIntent();
        workType = i.getStringExtra("workOut");
        Log.d("work out passed:", workType);

        WebView webView = (WebView) findViewById(R.id.webView);

        switch (workType){
            case "Treadmill":
                webView.loadUrl("https://www.dickssportinggoods.com/products/treadmills.jsp");
                break;
            case "Elliptical":
                webView.loadUrl("https://www.popsugar.com/fitness/Elliptical-Workouts-All-Levels-18712196");
                break;
            case "Stair Climber":
                webView.loadUrl("https://www.self.com/story/2-ridiculously-effective-ways-to-work-your-butt-using-a-stair-climber-machine");
                break;
            case "Push-Up":
                webView.loadUrl("https://www.military.com/military-fitness/workouts/try-pushup-push-workout");
                break;
            case "Squat":
                webView.loadUrl("https://dailyburn.com/life/fitness/squat-challenge-exercises/");
                break;
            case "Dumbbell Row":
                webView.loadUrl("https://www.bodybuilding.com/exercises/one-arm-dumbbell-row");
                break;
            case "Arm Across Chest":
                webView.loadUrl("https://www.youtube.com/watch?v=yJiixnuBTqc");
                break;
            case "Triceps Stretch":
                webView.loadUrl("https://www.youtube.com/watch?v=hSaqjF0dMMg");
                break;
            case "Glute Stretch":
                webView.loadUrl("https://yurielkaim.com/glute-stretches-tight-hips/");
                break;
            default:
                webView.loadUrl("https://www.omaze.com/experiences/dodgeball");

        }
    }
}
