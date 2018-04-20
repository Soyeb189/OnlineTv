package kpsoftwaresolutions.org.onlinetv;

import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    BoomMenuButton boomMenuButton;
    ArrayList<Integer> imageIdList;
    ArrayList<String> imageTitleList;
    private CardView atn_news,shomoy_news,ntv,gtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageIdList = new ArrayList<>();
        imageTitleList = new ArrayList<>();
        setInitialData();
        boomMenuButton = findViewById(R.id.bmb);

        //card view
        atn_news = findViewById(R.id.cardVwAtn);
        shomoy_news = findViewById(R.id.cardVwShomoy);
        ntv = findViewById(R.id.cardVwNtv);
        gtv = findViewById(R.id.cardVwGazi);


        atn_news.setOnClickListener(this);
        shomoy_news.setOnClickListener(this);
        ntv.setOnClickListener(this);
        gtv.setOnClickListener(this);




        //boom menu

        for (int i = 0; i < boomMenuButton.getPiecePlaceEnum().pieceNumber(); i++) {
            TextInsideCircleButton.Builder builder = new TextInsideCircleButton.Builder()

                    .normalImageRes(imageIdList.get(i))
                    .normalText(imageTitleList.get(i));
            builder.imagePadding(new Rect(40, 40, 40, 40));

            builder.listener(new OnBMClickListener() {
                @Override
                public void onBoomButtonClick(int index) {
                    // When the boom-button corresponding this builder is clicked.
                    Intent i;
                    if (index == 0) {

                        Toast.makeText(getApplicationContext(), "Log Out Successfully", Toast.LENGTH_SHORT).show();

                    }

                }
            });
            boomMenuButton.addBuilder(builder);
        }
    }

    private void setInitialData() {
        //set icon id
        imageIdList.add(R.drawable.ic_power_settings_new_black_24dp);
        imageIdList.add(R.drawable.ic_build_black_24dp);
        imageIdList.add(R.drawable.ic_add_alert_black_24dp);



        //set icon title

        imageTitleList.add("Log Out");
        imageTitleList.add("Settings");
        imageTitleList.add("Notification");
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch(v.getId()){

            case R.id.cardVwAtn : i = new Intent(this,atn_news.class);
                startActivity(i);
                break;

            case R.id.cardVwShomoy : i = new Intent(this,shomoy_news.class);
                startActivity(i);
                break;

            case R.id.cardVwNtv : i = new Intent(this,ntv.class);
                startActivity(i);
                break;

            case R.id.cardVwGazi : i = new Intent(this,gtv.class);
                startActivity(i);
                break;


            default: break;
        }

    }
}
