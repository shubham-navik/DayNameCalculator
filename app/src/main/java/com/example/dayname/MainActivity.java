package com.example.dayname;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText etDate;
    Button btnans;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDate = findViewById(R.id.etDate);
        btnans = findViewById(R.id.btnans);
        tv = findViewById(R.id.tv);

      btnans.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            String userInput = etDate.getText().toString();

              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
              try {
                  // Parse the user input to a Date object
                  Date date = dateFormat.parse(userInput);

                  // Get the day of the week as an integer (1 = Sunday, 2 = Monday, ..., 7 = Saturday)
                  int dayOfWeek = getDayOfWeek(date);

                  // Convert the integer day of the week to the corresponding day name
                  String dayName = getDayName(dayOfWeek);

//                  System.out.println("Day of the week: " + dayName);
                  tv.setText(dayName);
              } catch (ParseException e) {
                  System.err.println("Invalid date format. Please enter a date in yyyy-MM-dd format.");
              }







          }
      });
    }

    public static String getDayName(int dayOfWeek) {
        dayOfWeek++;
        switch (dayOfWeek) {
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Saturday";
            default:
                return "Invalid day";
        }
    }

    // Helper method to get the day of the week from a Date object
    public static int getDayOfWeek(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("u");
        String dayOfWeek = dateFormat.format(date);
        return Integer.parseInt(dayOfWeek);
    }

}