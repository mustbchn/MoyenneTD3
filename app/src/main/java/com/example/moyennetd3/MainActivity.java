package com.example.moyennetd3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
    public void calculer(View view) {


        EditText Num1 = findViewById(R.id.num1);
        String number_1 = Num1.getText().toString();


        EditText Num2 = findViewById(R.id.num2);
        String number_2 = Num2.getText().toString();

        EditText Num3 = findViewById(R.id.num3);
        String number_3 = Num3.getText().toString();

        if (number_1.isEmpty() || number_2.isEmpty() || number_3.isEmpty()) {
            String errorMessage="Error\npleas add 3 numbers!";
            Toast errorToast = Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT);
            errorToast.show();

        }      else {
                float number_1f = Float.parseFloat(number_1);
                float number_2f = Float.parseFloat(number_2);
                float number_3f = Float.parseFloat(number_3);
                float result = (number_1f + number_2f + number_3f)/3;
                String resultS = String.valueOf(result);

                if (number_1f>20 || number_2f>20 || number_3f>20) {
                    String errorMessage="Error\nnumbers should be between 0 & 20!";
                    Toast errorToast = Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT);
                    errorToast.show();
                } else if (result>10 && result<=20) {
                    Intent intent = new Intent ( getApplicationContext (), MainActivity2.class );

                    intent.putExtra("result",resultS);
                    startActivity ( intent );
                } else if (result<10 && result>=0){
                    Intent intent = new Intent ( getApplicationContext (), MainActivity4.class );
                    intent.putExtra("result",resultS);
                    startActivity ( intent );
                }


            }
    }

}