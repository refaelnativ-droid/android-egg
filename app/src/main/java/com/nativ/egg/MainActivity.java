package com.nativ.egg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private EditText editTextName;
    private Button buttonOk;
    private TextView textViewCount;
    private ImageView imageViewEgg;
    private Switch switchHideEgg;
    private Button buttonReset;

    private int counter = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTitle = findViewById(R.id.textViewTitle);
        editTextName = findViewById(R.id.editTextName);
        buttonOk = findViewById(R.id.buttonOk);
        textViewCount = findViewById(R.id.textViewCount);
        imageViewEgg = findViewById(R.id.imageViewEgg);
        switchHideEgg = findViewById(R.id.switchHideEgg);
        buttonReset = findViewById(R.id.buttonReset);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                if (!name.isEmpty()) {
                    textViewTitle.setText("Help " + name + "!");
                    Toast.makeText(MainActivity.this, "Welcome " + name + "!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter your name!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        imageViewEgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 0) {
                    counter--;
                    textViewCount.setText(String.valueOf(counter));

                    if (counter == 0) {
                        imageViewEgg.setImageResource(R.drawable.chick);
                        Toast.makeText(MainActivity.this, "The chick has hatched!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        switchHideEgg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    imageViewEgg.setVisibility(View.VISIBLE);
                } else {
                    imageViewEgg.setVisibility(View.INVISIBLE);
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 10;
                textViewCount.setText(String.valueOf(counter));
                imageViewEgg.setImageResource(R.drawable.egg);
            }
        });
    }
}