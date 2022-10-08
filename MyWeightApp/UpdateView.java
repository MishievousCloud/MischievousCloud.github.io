package com.zybooks.MyWeight;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/*
 *===================================================================================================
 * The UpdateView is where all update changes are made for the user entered dates and weights.
 *
 * BEFORE CHANGES:
 * The update feature was non-functional. Text was not cleared after input was deemed successful.
 * Inputs were not validated or checked for errors. No alert messages appeared if inputs were wrong.
 * The update view was not colored the same as the rest of the app screens. The buttons were not
 * sized appropriately. The goal weight was allowed to be updated but not functional in the activity.
 *
 * AFTER CHANGES:
 * The update feature was fixed to be functional. Text is now cleared after successful update. Input
 * is handled and error messages are displayed when incorrect entries are detected. The update view
 * is now colored correctly, the buttons are sized correctly, and the goal weight update feature was
 * removed as this is utilized by AddWeights instead. A calendar date picker is now used in the text
 * boxed for input of dates as well.
 *===================================================================================================
 */
public class UpdateView extends AppCompatActivity {

    //Initialize Variables
    EditText updateDate, updateWeight, updateNewDate, updateNewWeight;
    Button btUpdate, btReturn;
    DBHelper DB;
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_view);

        //Assign variables
        updateDate = findViewById(R.id.updateDate);
        updateWeight = findViewById(R.id.updateWeight);
        updateNewDate = findViewById(R.id.updateNewDate);
        updateNewWeight = findViewById(R.id.updateNewWeight);
        btUpdate= findViewById(R.id.bt_update);
        btReturn = findViewById(R.id.bt_returnToAddWeights);
        DB = new DBHelper(this);

        //Old Date picker dialog popup
        DatePickerDialog.OnDateSetListener oldDateDialog = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH,month);
            myCalendar.set(Calendar.DAY_OF_MONTH,day);
            updateLabelDate();
        };

        //New Date picker dialog popup
        DatePickerDialog.OnDateSetListener newDateDialog = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH,month);
            myCalendar.set(Calendar.DAY_OF_MONTH,day);
            updateLabelNewDate();
        };

        //Listener for when date edit text field is clicked
        updateDate.setOnClickListener(view -> new DatePickerDialog(UpdateView.this, oldDateDialog, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show());
        updateNewDate.setOnClickListener(view -> new DatePickerDialog(UpdateView.this, newDateDialog, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show());

        //Update button
        btUpdate.setOnClickListener(v -> {
            String oldDate = updateDate.getText().toString();
            String newDate = updateNewDate.getText().toString();
            String oldWeight = updateWeight.getText().toString();
            String newWeight = updateNewWeight.getText().toString();

            //Check if fields are empty
            if (!oldDate.equals("") && newDate.equals("") || oldDate.equals("") && !newDate.equals("")) {
                //If old date is filled, but not new date OR new date is filled but not old date.
                Toast.makeText(UpdateView.this, "Please enter both the date you wish to change and the new date", Toast.LENGTH_SHORT).show();
            } else if (!oldWeight.equals("") && newWeight.equals("") || oldWeight.equals("") && !newWeight.equals("")) {
                //If old weight is filled but not new date OR new weight but not old weight.
                Toast.makeText(UpdateView.this, "Please enter both the weight you wish to change and the new weight", Toast.LENGTH_SHORT).show();
            } else if (!oldDate.equals("") && !newDate.equals("") && oldWeight.equals("") && newWeight.equals("")) {
                //Update date if fields are entered and check passes
                Boolean checkDate = DB.checkDate(oldDate);
                String id = Integer.toString(DB.getDateID(oldDate));
                if (checkDate) {
                    DB.updateDate(newDate, id);
                    Toast.makeText(UpdateView.this, "Date updated Successfully", Toast.LENGTH_SHORT).show();
                    updateDate.setText("");
                    updateNewDate.setText("");
                } else {
                    Toast.makeText(UpdateView.this, "Date does not exist", Toast.LENGTH_SHORT).show();
                }
            } else if (!oldWeight.equals("") && !newWeight.equals("") && oldDate.equals("") && newDate.equals("")) {
                //Update weight if fields are entered and check passes
                Boolean checkWeight = DB.checkWeight(oldWeight);
                String id = Integer.toString(DB.getWeightID(oldWeight));
                if (checkWeight) {
                    DB.updateWeight(newWeight, id);
                    Toast.makeText(UpdateView.this, "Weight updated Successfully", Toast.LENGTH_SHORT).show();
                    updateWeight.setText("");
                    updateNewWeight.setText("");
                } else {
                    Toast.makeText(UpdateView.this, "Weight does not exist", Toast.LENGTH_SHORT).show();
                }
            } else if (!oldDate.equals("") && !newDate.equals("") && !oldWeight.equals("") && !newWeight.equals("")) {
                //Update both date and weight if fields are entered and checks pass
                Boolean checkDate = DB.checkDate(oldDate);
                String dateId = Integer.toString(DB.getDateID(oldDate));
                Boolean checkWeight = DB.checkWeight(oldWeight);
                String weightId = Integer.toString(DB.getWeightID(oldWeight));
                if (checkDate && checkWeight) {
                    DB.updateDate(newDate, dateId);
                    DB.updateWeight(newWeight,weightId);
                    Toast.makeText(UpdateView.this, "Date and weight successfully updated", Toast.LENGTH_SHORT).show();
                    updateDate.setText("");
                    updateNewDate.setText("");
                    updateWeight.setText("");
                    updateNewWeight.setText("");
                } else if (!checkDate) {
                    Toast.makeText(UpdateView.this, "Date does not exist", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UpdateView.this, "Weight does not exist", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Returns to add weight activity
        btReturn.setOnClickListener(v -> startActivity(new Intent(UpdateView.this, HomeActivity.class)));
    }

    //Updates the editText field to the chosen date
    private void updateLabelDate(){
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        updateDate.setText(dateFormat.format(myCalendar.getTime()));
    }

    //Updates the editText field to the chosen new date
    private void updateLabelNewDate(){
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        updateNewDate.setText(dateFormat.format(myCalendar.getTime()));
    }
}
