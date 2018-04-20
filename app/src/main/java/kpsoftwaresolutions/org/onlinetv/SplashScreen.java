package kpsoftwaresolutions.org.onlinetv;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(4000)
                .withBackgroundResource(R.drawable.background_gradient)
                .withLogo(R.drawable.ic_live_tv_black_24dp)
                .withAfterLogoText("Online Tv")
                .withHeaderText("WELCOME TO")
                .withFooterText("Copyright KP Software Solutions");

        config.getHeaderTextView().setTextColor(Color.WHITE);
        config.getAfterLogoTextView().setTextColor(Color.WHITE);
        config.getFooterTextView().setTextColor(Color.WHITE);

        View easySplashScreenView = config.create();
        setContentView(easySplashScreenView);
    }
}
