package com.jentronics.cs3270a2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fm = getSupportFragmentManager();
    private boolean inverted = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLoad2 = (Button) findViewById(R.id.button_load_2);
        Button btnLoad3 = (Button) findViewById(R.id.button_load_3);
        Button btnLoad4 = (Button) findViewById(R.id.button_load_4);
        Button btnSwap  = (Button) findViewById(R.id.button_swap_3_4);

        fm.beginTransaction()
                .replace(R.id.fragAContainer, new FragmentA(), "ContainerA")
                //.addToBackStack(null)
                .commit();

        btnLoad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction()
                        .replace(R.id.fragBContainer, new FragmentB(), "ContainerB")
                        .addToBackStack(null)
                        .commit();
            }
        });

        btnLoad3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction()
                        .replace(R.id.fragCContainer, new FragmentC(), "ContainerC")
                        .addToBackStack(null)
                        .commit();
            }
        });

        btnLoad4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction()
                    .replace(R.id.fragDContainer, new FragmentD(), "ContainerD")
                    .addToBackStack(null)
                    .commit();
            }
        });

        btnSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Fragment fragX = fm.findFragmentByTag("ContainerC");
//                Fragment fragY = fm.findFragmentByTag("ContainerD");
                Fragment fragX;
                Fragment fragY;
                if( !inverted) {
                    fragX = new FragmentC();
                    fragY = new FragmentD();
                    inverted = true;
                } else {
                    fragY = new FragmentC();
                    fragX = new FragmentD();
                    inverted = false;
                }
                fm.beginTransaction()
                        .replace(R.id.fragCContainer, fragY, "ContainerC")
                        .replace(R.id.fragDContainer, fragX, "ContainerD")
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
