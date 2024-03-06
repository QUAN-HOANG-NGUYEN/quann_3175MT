package com.example.quann_3175mt;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        try {
//
//            bundle.putString("showName",ShowList.get(i).getShowName());
//            bundle.putString("showParentName",editTextParentName.toString());

            Bundle bundle = getIntent().getExtras();
            String showName = bundle.getString("showName","nothing");
            String showParentName = bundle.getString("showParentName","nothing");

            List<Integer> ShowImages2 = new ArrayList<>(Arrays.asList(R.drawable.soccer,R.drawable.theatre,R.drawable.karate));
            List<String> ShowPrices = new ArrayList<>(Arrays.asList("165.99","179.99","189.99"));
            List<Integer> ShowRaws = new ArrayList<>(Arrays.asList(R.raw.soccer,R.raw.theatre,R.raw.karate));
            List<String> Types = new ArrayList<>(Arrays.asList("soccer","theatre","karate"));


            TextView header = findViewById(R.id.txtViewParentNameCampTime);
            String outputStr = "Parent Name: " + showParentName + "\n" + "Camp Time: " + showName;
            header.setText(outputStr);

            //ImgViewChosenCamp:
            ImageView imgViewResult = findViewById(R.id.imgViewChosenCamp);
            final MediaPlayer[] mediaPlayer = new MediaPlayer[1];


            final double[] cost1 = {0};
            final String[][] type = {new String[1]};
            Spinner spinnerTypes = findViewById(R.id.spinnerCamps);
            spinnerTypes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(i == 0){
                        cost1[0] = 165.99;
                        imgViewResult.setImageResource(ShowImages2.get(0));
                        mediaPlayer[0] = MediaPlayer.create(ResultActivity.this,ShowRaws.get(0));
                        mediaPlayer[0].start();
                        type[0] = new String[]{Types.get(0)};
                    } else if(i == 1){
                        cost1[0] = 179.99;
                        imgViewResult.setImageResource(ShowImages2.get(1));
                        mediaPlayer[0] = MediaPlayer.create(ResultActivity.this,ShowRaws.get(1));
                        mediaPlayer[0].start();
                        type[0] = new String[]{Types.get(1)};
                    } else if(i == 2){
                        cost1[0] = 189.99;
                        imgViewResult.setImageResource(ShowImages2.get(2));
                        mediaPlayer[0] = MediaPlayer.create(ResultActivity.this,ShowRaws.get(2));
                        mediaPlayer[0].start();
                        type[0] = new String[]{Types.get(2)};
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });


            final double[] cost2 = {0};
            final String[] meal = new String[1];
            RadioGroup radGroup = findViewById(R.id.radGroupFoodNeeded);
            radGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if(i == R.id.radBtnFood){
                        cost2[0] = 29.99;
                        meal[0] = "Food";
                    } else if (i == R.id.radBtnNoFood3){
                        cost2[0] = 0;
                        meal[0] = "NO FOOD";
                    }
                }
            });

            final double[] totalcost = {0};
            final double[] foodcost = {0};
            final double[] grandcost = {0};
            EditText numberKids = findViewById(R.id.editTextNumKids);
            Button btnBook = findViewById(R.id.btnBookCamp4);
            TextView txtViewResults = findViewById(R.id.txtViewResults);
            btnBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(numberKids.getText().toString().isEmpty()){
                        Toast.makeText(ResultActivity.this, "Number cannot be empty", Toast.LENGTH_SHORT).show();
                    } else {
                        int totalkids = Integer.parseInt(numberKids.getText().toString());
                        totalcost[0] = cost1[0]*totalkids;
                        foodcost[0] = cost2[0]*totalkids;
                        grandcost[0] = totalcost[0] + foodcost[0];
                        DecimalFormat df = new DecimalFormat("$#.## ");
                        String output2 = "Camp Name: " + type + "\n" +
                                "Camp base cost per kids " + cost1[0] + "\n" +
                                "Number of kids: " + numberKids + "\n" +
                                "Camp total: " + totalcost[0] +  "\n" +
                                "Food cost: " + foodcost[0] +  "\n" +
                                "Grand total: " + grandcost[0];
                        txtViewResults.setText(output2);
                        txtViewResults.setGravity(Gravity.CENTER);
                    }
                }
            });

        } catch (Exception error) {
            error.printStackTrace();
            Toast.makeText(this, "Connection Error", Toast.LENGTH_SHORT).show();
        }
    }
}