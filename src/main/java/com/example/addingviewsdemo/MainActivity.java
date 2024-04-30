package com.example.addingviewsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout cL;
    TextView tV;
    ImageView iV;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cL = findViewById(R.id.layout);

        tV = new TextView(this);
        tV.setId(View.generateViewId());
        tV.setText("Hello New world");
        tV.setTextColor(Color.RED);

        ConstraintLayout.LayoutParams tVP = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);

        tV.setLayoutParams(tVP);

        cL.addView(tV);

        iV = new ImageView(this);
        iV.setId(View.generateViewId());
        iV.setImageResource(R.drawable.attack);

        ConstraintLayout.LayoutParams iP = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_PERCENT*300, ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_PERCENT*300);

        iV.setLayoutParams(iP);

        cL.addView(iV);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(cL);

        constraintSet.connect(tV.getId(), ConstraintSet.TOP, cL.getId(), ConstraintSet.TOP);
        constraintSet.connect(tV.getId(), ConstraintSet.BOTTOM, cL.getId(), ConstraintSet.BOTTOM);
        constraintSet.connect(tV.getId(), ConstraintSet.LEFT, cL.getId(), ConstraintSet.LEFT);
        constraintSet.connect(tV.getId(), ConstraintSet.RIGHT, cL.getId(), ConstraintSet.RIGHT);

        constraintSet.connect(iV.getId(), ConstraintSet.TOP, cL.getId(), ConstraintSet.TOP);
        constraintSet.connect(iV.getId(), ConstraintSet.BOTTOM, cL.getId(), ConstraintSet.BOTTOM);
        constraintSet.connect(iV.getId(), ConstraintSet.LEFT, cL.getId(), ConstraintSet.LEFT);
        constraintSet.connect(iV.getId(), ConstraintSet.RIGHT, cL.getId(), ConstraintSet.RIGHT);
        constraintSet.setVerticalBias(iV.getId(), 0.2f);

        constraintSet.applyTo(cL);
    }
}