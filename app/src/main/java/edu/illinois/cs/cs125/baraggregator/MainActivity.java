package edu.illinois.cs.cs125.baraggregator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void swapPageSpecails(View v){
        startActivity(new Intent(MainActivity.this, specails.class));
    }

    public void swapPageOthers(View v){
        startActivity(new Intent(MainActivity.this, others.class));
    }


}
