package sg.edu.ep.c346.id20029318.demodialogue;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button butD1, butD2, butD3, butEx3, butD4, butD5;
    TextView txtDemo2, txtDemo3, txtNum1, txtNum2, txtEx3, txtDemo4, txtDemo5;
    EditText edTxtInput, edNum1, edNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butD1 = findViewById(R.id.butDemo1);
        butD2 = findViewById(R.id.butDemo2);
        txtDemo2 = findViewById(R.id.txtDemo2);
        butD3 = findViewById(R.id.butDemo3);
        txtDemo3 = findViewById(R.id.txtDemo3);
        edTxtInput = findViewById(R.id.edTxtInput);
        butEx3 = findViewById(R.id.butEx3);
        txtEx3 = findViewById(R.id.txtEx3);
        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        edNum1 = findViewById(R.id.edTxtNum1);
        edNum2 = findViewById(R.id.edTxtNum2);
        butD4 = findViewById(R.id.butDemo4);
        txtDemo4 = findViewById(R.id.txtDemo4);
        butD5 = findViewById(R.id.butDemo5);
        txtDemo5 = findViewById(R.id.txtDemo5);


        butD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                /* Set Diaglog details
                myBuilder.setTitle("Demo 1 - Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close", null);
                 */

                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialogue Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("DISMISS", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        butD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the buttons below");
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() { // placement of button: far right
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txtDemo2.setText("You have selected Positive.");
                    }
                });

                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() { // placement of button: middle, next to setPositiveButton
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txtDemo2.setText("You have selected Negative.");
                    }
                });

                myBuilder.setNeutralButton("Cancel", null); // placement of button: far left
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        butD3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input,null);

                final EditText etInput = viewDialog.findViewById(R.id.edTxtInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3 - Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        String message = etInput.getText().toString(); //use final EditText not edTxtInput
                        // Set the text to the TextView
                        txtDemo3.setText(message);
                    }
                });

                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        butEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.exercise3,null);

                final EditText etNum1 = viewDialog.findViewById(R.id.edTxtNum1);
                final EditText etNum2 = viewDialog.findViewById(R.id.edTxtNum2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        int addNum1 = Integer.parseInt(etNum1.getText().toString());
                        int addNum2 = Integer.parseInt(etNum2.getText().toString());
                        int sum = addNum1 + addNum2;
                        String message = "The sum is " + sum + ""; //use final EditText not edTxtInput
                        // Set the text to the TextView
                        txtEx3.setText(message);
                    }
                });

                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        butD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        txtDemo4.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };
                // Create the Date Picker Dialog to show the current date when it first appears
                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, year, month, day);

                myDateDialog.show();
            }
        });

        butD5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        txtDemo5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

                // Create the Date Picker Dialog to show the current date when it first appears
                Calendar now = Calendar.getInstance();
                int hourOfDay = now.get(Calendar.HOUR_OF_DAY);  // Current Hour
                int minute = now.get(Calendar.MINUTE);  // Current Minute
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        myTimeListener, hourOfDay, minute, true);

                myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, 20, 00, false);
                myTimeDialog.show();

            }
        });
    }}