package com.zybooks.MyWeight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
/*
 *===================================================================================================
 * The AddWeights class is where the user will add the goal, date, weight, and switch to update view.
 *
 * BEFORE CHANGES:
 * The original applications buttons were sized incorrectly and were not uniform. The
 * goal add feature was unused and not implemented properly. The add weights function worked but did
 * not check for real dates.
 *
 * AFTER CHANGES:
 * The buttons were aligned better and given uniform scaling and layout.
 * The goal feature was implemented and functional. Shared preferences were used for goal weight
 * display. When selecting a date, a dialog calendar now pops up allowing a more user friendly
 * approach to entering dates. It also ensures that a proper date format is entered. Reaching the
 * goal weight after entering in the new current weight now congratulates the user on achieving their
 * goal. Redundancies were also removed. Changes are reflected in the activity_add_weights.xml file.
 *
 *===================================================================================================
 */
public class AddWeights extends AppCompatActivity {

    //Initialized Variables
    private EditText etGoal, etDate, etWeight;
    DBHelper DB;
    DrawerLayout drawerLayout;
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_weights);

        //Assigned Variables
        drawerLayout = findViewById(R.id.drawer_layout);
        etGoal = findViewById(R.id.et_goal);
        etDate = findViewById(R.id.et_date);
        etWeight = findViewById(R.id.et_weight);
        Button btAdd = findViewById(R.id.bt_addWeightDetails);
        Button btAddGoal = findViewById(R.id.bt_addGoal);
        Button btUpdate = findViewById(R.id.bt_update);
        Button btDelete = findViewById(R.id.bt_deleteWeight);
        Button btViewWeight = findViewById(R.id.bt_viewWeight);
        DB = new DBHelper(this);

        //Date picker dialog popup
        DatePickerDialog.OnDateSetListener theDate = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH,month);
            myCalendar.set(Calendar.DAY_OF_MONTH,day);
            updateLabel();
        };
        //Listener for when date edit text field is clicked
        etDate.setOnClickListener(view -> new DatePickerDialog(AddWeights.this, theDate, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show());

        //Listener for Add button to insert data
        btAdd.setOnClickListener(v -> {
            String date = etDate.getText().toString();
            String weight = etWeight.getText().toString();

            if (date.equals("") || weight.equals("")){
                //If either field is empty
                Toast.makeText(AddWeights.this, "Please enter a date and weight", Toast.LENGTH_SHORT).show();
            } else {
                //Add weight and date
                Boolean insert = DB.insertWeightData(date, weight);
                if (insert){
                    //Before changing text field to blank, check the goal.
                    SharedPreferences pref = getBaseContext().getSharedPreferences("Goal",0);
                    //Check to make sure prefs aren't default. If not, check if goal is reached.
                    if(!pref.getString("Goal", "0").equals("0") && Integer.parseInt(weight) == Integer.parseInt(pref.getString("Goal","0"))) {
                        Toast.makeText(AddWeights.this, "CONGRATS!!! YOU REACHED YOUR GOAL!!",Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(AddWeights.this,"Weight entered successfully",Toast.LENGTH_SHORT).show();
                    }
                    etDate.setText("");
                    etWeight.setText("");
                } else {
                    Toast.makeText(AddWeights.this, "Failed to enter weight",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Listener for Add Goal button to insert data.
        btAddGoal.setOnClickListener(v -> {
            //String value of the goal text view.
            String goalText = etGoal.getText().toString();

            //Checks for the goal entry field.
            if (goalText.equals("")){
                //If either field is empty
                Toast.makeText(AddWeights.this, "Please enter a new goal", Toast.LENGTH_SHORT).show();
            }else {
                //If not empty assign goal value into shared prefs.
                SharedPreferences pref = getBaseContext().getSharedPreferences("Goal",0);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("Goal", goalText);
                editor.apply();
                Toast.makeText(AddWeights.this, "Goal weight entered successfully", Toast.LENGTH_SHORT).show();
                etGoal.setText("");
            }
        });

        //Listener for view weight button to bring back to home activity where weight list is located
        btViewWeight.setOnClickListener(v -> startActivity(new Intent(AddWeights.this, HomeActivity.class)));

        //Listener for update button to bring to UpdateView activity.
        btUpdate.setOnClickListener(v -> startActivity(new Intent(AddWeights.this, UpdateView.class)));

        //Listener for delete button to delete fields from the database
        btDelete.setOnClickListener(v -> {
            //If the user enters goal
            String date = etDate.getText().toString();
            String weight = etWeight.getText().toString();

            //If the user enters a date
            if (!date.equals("")) {
                Boolean checkDate = DB.checkDate(date);
                if (checkDate) {
                    DB.deleteDate(date);
                    etDate.setText("");
                    Toast.makeText(AddWeights.this, "Successfully deleted date", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(AddWeights.this, "No such date exists in the database", Toast.LENGTH_SHORT).show();
                }
            }
            //If the user enters a weight
            if (!weight.equals("")) {
                Boolean checkWeight = DB.checkWeight(weight);
                if (checkWeight) {
                    DB.deleteWeight(weight);
                    etWeight.setText("");
                    Toast.makeText(AddWeights.this, "Successfully deleted weight", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddWeights.this, "No such weight exists in the database", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Updates the editText field to the chosen date
    private void updateLabel(){
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        etDate.setText(dateFormat.format(myCalendar.getTime()));
    }

    /*
     *===================================================================================================
     * Navigation drawer methods.
     *===================================================================================================
     */
    public void ClickMenu(View view){
        //Open drawer
        HomeActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        //Close drawer
        HomeActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        //Redirect activity to home
        HomeActivity.redirectActivity(this, HomeActivity.class);
    }

    public void ClickLogout(View view){
        //Close app
        HomeActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        HomeActivity.closeDrawer(drawerLayout);
    }
}