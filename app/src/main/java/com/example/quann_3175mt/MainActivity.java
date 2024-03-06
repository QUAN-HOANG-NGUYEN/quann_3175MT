package com.example.quann_3175mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> ShowNames = new ArrayList<>(Arrays.asList("Morning Camp","AfternoonCamp"));
    List<Integer> ShowImages1 = new ArrayList<>(Arrays.asList(R.drawable.amicon,R.drawable.pmicon));
    List<Integer> ShowImages2 = new ArrayList<>(Arrays.asList(R.drawable.soccer,R.drawable.theatre,R.drawable.karate));

    List<String> ShowPrices = new ArrayList<>(Arrays.asList("165.99","179.99","189.99"));
    List<Integer> ShowRaws = new ArrayList<>(Arrays.asList(R.raw.soccer,R.raw.theatre,R.raw.karate));
    List<Show> ShowList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadModelData();

        ListView listViewShows = findViewById(R.id.listViewShow);
        ShowAdapter2 showAdapter2 = new ShowAdapter2(ShowList);
        listViewShows.setAdapter(showAdapter2);

        EditText editTextParentName = findViewById(R.id.editTextParentName);

        listViewShows.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(editTextParentName.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter parent name", Toast.LENGTH_SHORT).show();
                } else {
                    switch(i){
                        case 0:
                            Toast.makeText(MainActivity.this, "Morning Camp", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            Toast.makeText(MainActivity.this, "Afternoon Camp", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
                Bundle bundle = new Bundle();

                bundle.putString("showName",ShowList.get(i).getShowName());
                bundle.putString("showParentName",editTextParentName.toString());

                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void LoadModelData(){
        for(int i =0; i< ShowNames.size();i++){
            Show eachShow = new Show(ShowNames.get(i),ShowImages1.get(i),ShowPrices.get(i),ShowRaws.get(i));
            ShowList.add(eachShow);
        }
    }
}