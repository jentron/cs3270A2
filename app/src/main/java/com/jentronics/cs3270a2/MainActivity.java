package com.jentronics.cs3270a2;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm.beginTransaction()
                .replace(R.id.fragAContainer, new FragmentA(), "ContainerA")
                //.addToBackStack(null)
                .commit();

        Button btnLoad2 = (Button) findViewById(R.id.button_load_2);
        btnLoad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction()
                        .replace(R.id.fragBContainer, new FragmentB(), "ContainerB")
                        .addToBackStack(null)
                        .commit();
            }
        });

        fm.beginTransaction()
                .replace(R.id.fragCContainer, new FragmentC(), "ContainerC")
                //.addToBackStack(null)
                .commit();
        fm.beginTransaction()
                .replace(R.id.fragDContainer, new FragmentD(), "ContainerD")
                //.addToBackStack(null)
                .commit();
    }
}
