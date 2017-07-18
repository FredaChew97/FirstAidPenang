package my.com.fredachew.firstaidpenang;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class do_and_dont_list extends AppCompatActivity {

    private ListView mListView;
    private Intent mIntent;
    private String doDescription ;
    private String dontDescription;

    Bundle bundle = new Bundle();
    // Change here for the title and image :)
    String[] name = {"earthquake", "flood", "tsunami"};
    int[] image = {R.mipmap.earth,R.mipmap.flood,R.mipmap.tsunami};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.do_dont_listview);

        mListView = (ListView) findViewById(R.id.listView);
        populateListView();
    }

    private void populateListView() {

        final ListAdapter adapter = new do_and_dont_list_adapter(this,image,name);

        mListView.setAdapter(adapter);

        //set an onItemClickListener to the ListView
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(name[i]=="earthquake") {
                    doDescription="Try to protect your head and torso.\n\n"+
                            "Be aware that smoke alarms and sprinkler systems frequently go off in buildings during an earthquake, even if there is no fire.\n\n"+
                            "Before you leave any building check to make sure that there is no debris from the building that could fall on you.\n\n";
                    dontDescription="Doorways are no stronger than any other part of a structure so don’t rely on them for protection!\n\n";

                    Toast.makeText(do_and_dont_list.this, "earthquake",
                            Toast.LENGTH_SHORT).show();
                    mIntent = new Intent(do_and_dont_list.this, do_n_dont_each_display.class);
                    bundle.putString("doD",doDescription);
                    bundle.putString("donD",dontDescription);
                    bundle.putString("name",name[i]);
                    bundle.putInt("image",image[i]);



                }

               else if(name[i]=="flood") {

                    doDescription="Turn off the power and water mains if instructed to do so by local authorities\n\n"+
                            "Continue listening to local area radio for updates.\n\n"+
                            "If caught on a flooded road with rapidly rising waters, get out of the car quickly and move to higher ground.\n\n";
                    dontDescription="Don’t use gas or electrical appliances that have been flooded.\n\n"+
                    "Avoid contact with floodwater. It may be contaminated with sewage or contain dangerous insects or animals\n\n"+
                    "Don’t allow children to play in or near flood water.\n\n"+
                    "Don't walk on beaches or riverbanks.";

                    Toast.makeText(do_and_dont_list.this, "flood",
                            Toast.LENGTH_SHORT).show();
                    mIntent = new Intent(do_and_dont_list.this, do_n_dont_each_display.class);
                    bundle.putString("name",name[i]);
                    bundle.putInt("image",image[i]);

                    mIntent = new Intent(do_and_dont_list.this, do_n_dont_each_display.class);
                    bundle.putString("doD",doDescription);
                    bundle.putString("donD",dontDescription);
                    bundle.putString("name",name[i]);
                    bundle.putInt("image",image[i]);


                }

                else if(name[i]=="tsunami") {

                    doDescription="Drop, cover, and hold on to protect yourself from the earthquake.\n\n"+
                            "When the shaking stops, gather members of your household and review your evacuation plan.\n\n"+"A tsunami may be coming within minutes.\n\n"+
                    "Follow instructions issued by local authorities. \n\n Recommended evacuation routes may be different from the one you planned, or you may be advised to climb higher.\n\n"+
                    "Get to higher ground as far inland as possible. Watching a tsunami from the beach or cliffs could put you in grave danger.\n\n If you can see the wave, you are too close to escape it.\n\n";
                    dontDescription="Avoid downed power lines and stay away from buildings and bridges from which heavy objects might fall during an aftershock.\n\n"+
                            "Stay away until local officials tell you it is safe. A tsunami is a series of waves that may continue for hours. \n Do not assume that after one wave the danger is over.\n The next wave may be larger than the first one.\n\n"
                            ;

                    Toast.makeText(do_and_dont_list.this, "tsunami",
                            Toast.LENGTH_SHORT).show();
                    mIntent = new Intent(do_and_dont_list.this, do_n_dont_each_display.class);
                    bundle.putString("name",name[i]);
                    bundle.putInt("image",image[i]);

                    mIntent = new Intent(do_and_dont_list.this, do_n_dont_each_display.class);
                    bundle.putString("doD",doDescription);
                    bundle.putString("donD",dontDescription);
                    bundle.putString("name",name[i]);
                    bundle.putInt("image",image[i]);


                }

                mIntent.putExtras(bundle);
                startActivity(mIntent);

            }
        });

    }




    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }



}
