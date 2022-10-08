package com.zybooks.MyWeight;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
/*
 *===================================================================================================
 * The HomeActivity is where the user can view their entered weights and goal.
 *
 * BEFORE CHANGES:
 * The original app had problems with the goal weight not displaying, the
 * "Goal:" text was misaligned, and the list view would populate with dates that were
 * not real if the user entered them incorrectly. Such as 1/1/1/1. The toolbar also contained unused
 * features.
 *
 * AFTER CHANGES:
 * The home activity now properly displays the weights and dates. It
 * also displays the goal weight with a default value of 0 in case no goal has been set yet. The
 * "Goal:" text is now properly aligned, and the populated goal is in a better readable position.
 * Comments were also reworked. The toolbar unused feature was also removed. Changes are also
 * reflected in the activity_home.xml file.
 *
 *===================================================================================================
 */
public class HomeActivity extends AppCompatActivity {

    //Initialized Variables
    DrawerLayout drawerLayout;
    Button addWeight;
    ListView listView;
    TextView goal;
    DBHelper DB;
    MyAdapter myAdapter;

    //Lists
    ArrayList<User> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Assigned Variables
        drawerLayout = findViewById(R.id.drawer_layout);
        addWeight = findViewById(R.id.bt_addWeight);
        listView = findViewById(R.id.list_view);
        goal = findViewById(R.id.tv_goal);
        DB = new DBHelper(this);
        arrayList = new ArrayList<>();

        //Gets weight data for the user
        getWeights();

        //Gets the shared preferences for the goal weight. Default assign 0.
        SharedPreferences pref = getBaseContext().getSharedPreferences("Goal",0);
        goal.setText(pref.getString("Goal","0"));

        //Listener for addWeight button
        addWeight.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, AddWeights.class)));

    }

    //Method to populate list view
    private void getWeights(){
        arrayList = DB.getWeightList();
        myAdapter = new MyAdapter(this,arrayList);
        listView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    /*
     *==============================================================================================
     * Navigation drawer methods.
     *==============================================================================================
     */

    public void ClickMenu(View view){
        //Open drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view) {
        //Close drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //Close drawer layout
        //Check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            //When drawer is open
            //Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        //Recreate activity
        recreate();
    }

    public void ClickLogout(View view){
        //Close app
        logout(this);
    }

    public static void logout(Activity activity) {
        //Initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //Set title
        builder.setTitle("Logout");
        //Set message
        builder.setMessage("Are you sure you want to logout?");
        //Positive yes button
        builder.setPositiveButton("Yes", (dialog, which) -> {
            //Finish activity
            activity.finishAffinity();
            //Exit app
            System.exit(0)  ;
        });
        //Negative no button
        builder.setNegativeButton("No", (dialog, which) -> {
            //Dismiss dialog
            dialog.dismiss();
        });
        //Show dialog
        builder.show();
    }

    @SuppressWarnings("rawtypes")
    public static void redirectActivity(Activity activity, Class aClass) {
        //Initialize intent
        Intent intent = new Intent(activity, aClass);
        //Set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        closeDrawer(drawerLayout);
    }
}