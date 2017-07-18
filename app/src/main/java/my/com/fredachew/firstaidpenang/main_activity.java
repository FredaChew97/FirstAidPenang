package my.com.fredachew.firstaidpenang;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.FragmentManager;

import my.com.fredachew.firstaidpenang.activities.UsersListActivity;


public class main_activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toast toast;
    private long lastBackPressTime = 0;
    private long lastClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Log.d("LOCATION","USER PROFILE");

        setContentView(R.layout.activity_main_activity);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment fragment =null;
        Class fragmentClass=null;

        //Go to User Profile Page
        fragmentClass= myProfile.class;

        try{
            fragment=(Fragment)fragmentClass.newInstance();
        }

        catch (Exception e){
            e.printStackTrace();
        }


        FragmentManager m = getSupportFragmentManager();
        m.beginTransaction().replace(R.id.flContent, fragment).commit();




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        View hView =  navigationView.getHeaderView(0);
        TextView nav_user = (TextView)hView.findViewById(R.id.textViewName);
        String s = "Hi,\n "+ getIntent().getStringExtra("USEREMAIL");

        nav_user.setText(s);
    }
    boolean twice;

    @Override
    public void onBackPressed() {


            if (getSupportFragmentManager().getBackStackEntryCount() > 0 ) {
//                Log.d("STACK","BPuserProfileOne");
                NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
                Log.d("BACKSTACK", String.valueOf(getSupportFragmentManager().getBackStackEntryCount()));
                getSupportFragmentManager().popBackStack();
                int index = getSupportFragmentManager().getBackStackEntryCount() - 1;
                navigationView.getMenu().getItem(index).setChecked(true);


            }else {
//                Log.d("STACK","BPuserProfileTwo");
                final AlertDialog.Builder builder = new AlertDialog.Builder(main_activity.this);
                builder.setTitle("Logging Out?");
                builder.setMessage("Do you want to logout?");
                builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent(getApplicationContext(),login.class);
                        startActivity(intent);

                        finish();

                    }
                });

                builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }









    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
       // if (id == R.id.action_settings) {
        //    return true;
       // }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment =null;
        Class fragmentClass=null;
        if(id==R.id.accounts){
            Intent intent = new Intent(this, UsersListActivity.class);
            startActivity(intent);

            finish();


        }
        else if(id==R.id.logoutpath){
            final AlertDialog.Builder builder = new AlertDialog.Builder(main_activity.this);
            builder.setTitle("Logging Out?");
            builder.setMessage("Do you want to logout?");
            builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent intent = new Intent(getApplicationContext(),login.class);
                    startActivity(intent);

                    finish();

                }
            });

            builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.dismiss();
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        }

      else {
            if (id == R.id.my_Profile) {
                //Go to User Profile Page
                fragmentClass = myProfile.class;

                Toast.makeText(this, "Main Page", Toast.LENGTH_SHORT).show();

            } else if (id == R.id.about_Us) {

                fragmentClass = aboutUs.class;

                Toast.makeText(this, "About Us Page", Toast.LENGTH_SHORT).show();

            } else if (id == R.id.our_Service) {
                // Go to Service page

                fragmentClass = our_services_listview.class;

                Toast.makeText(this, "Service Page", Toast.LENGTH_SHORT).show();

            } else if (id == R.id.knowledgeQuiz) {
                fragmentClass = knowledge_quiz_display.class;

                Toast.makeText(this, "Knowledge Quiz", Toast.LENGTH_SHORT).show();

            } else if (id == R.id.feedback_Us) {

                //Go to feeback Us
                fragmentClass = feedbackUs_display.class;

                Toast.makeText(this, "Feedback Us Page", Toast.LENGTH_SHORT).show();

            }

            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

            FragmentManager m = getSupportFragmentManager();
            m.beginTransaction().replace(R.id.flContent, fragment).addToBackStack(null).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }


}
