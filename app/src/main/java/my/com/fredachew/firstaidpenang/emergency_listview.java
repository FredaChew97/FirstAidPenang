package my.com.fredachew.firstaidpenang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class emergency_listview extends AppCompatActivity {
    private ListView mListView;
    private Intent mIntent;
    private String Description ;


    Bundle bundle = new Bundle();
    // Change here for the title and image :)
    String[] name = {"Asthma Attack", "Broken Bones", "Minor Burns","Major Burns","Choking","Heart Attack","Sting"};
    int[] image = {R.mipmap.asthma ,R.mipmap.bone,R.mipmap.minorburn,R.mipmap.majorburn,R.mipmap.choking,R.mipmap.heartattack,R.mipmap.sting};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_listview_display);

        mListView = (ListView) findViewById(R.id.emergencylistView);
        populateListView();
    }


    private void populateListView() {

        final ListAdapter adapter = new emergency_list_adapter(this,image,name);

        mListView.setAdapter(adapter);

        //set an onItemClickListener to the ListView
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(name[i]=="Asthma Attack") {
                    Description="Sit down and try to take slow, steady breaths. Try to remain calm, as panicking will make things worse. \n\n" +
                            "Take one puff of your reliever inhaler (usually blue) every 30-60 seconds, up to a maximum of 10 puffs. It's best to use your spacer if you have one.\n\n" +
                            "Call 999 for an ambulance if you don't have your inhaler with you, you feel worse despite using your inhaler, you don't feel better after taking 10 puffs, or you're worried at any point.\n\n" +
                            "If the ambulance hasn't arrived within 15 minutes, repeat step 2.";


                    Toast.makeText(emergency_listview.this, "Asthma Attack",
                            Toast.LENGTH_SHORT).show();
                    mIntent = new Intent(emergency_listview.this, emergency_details_display.class);
                    bundle.putString("D",Description);

                    bundle.putString("name",name[i]);
                    bundle.putInt("image",image[i]);


                    mIntent.putExtras(bundle);
                    startActivity(mIntent);


                }

                else if(name[i]=="Broken Bones"){

                        Description="Don't move the person except if necessary to avoid further injury. Take these actions immediately while waiting for medical help:\n \n"+"Stop any bleeding. Apply pressure to the wound with a sterile bandage, a clean cloth or a clean piece of clothing. \n"+"Immobilize the injured area. Don't try to realign the bone or push a bone that's sticking out back in. If you've been trained in how to splint and professional help isn't readily available, apply a splint to the area above and below the fracture sites. Padding the splints can help reduce discomfort. \n\n"
                                +"Apply ice packs to limit swelling and help relieve pain. Don't apply ice directly to the skin. Wrap the ice in a towel, piece of cloth or some other material. \n\n"
                                +"Treat for shock. If the person feels faint or is breathing in short, rapid breaths, lay the person down with the head slightly lower than the trunk and, if possible, elevate the legs. \n\n";


                        Toast.makeText(emergency_listview.this, "Broken Bones",
                                Toast.LENGTH_SHORT).show();
                        mIntent = new Intent(emergency_listview.this, emergency_details_display.class);
                        bundle.putString("D",Description);

                        bundle.putString("name",name[i]);
                        bundle.putInt("image",image[i]);


                        mIntent.putExtras(bundle);
                        startActivity(mIntent);


                    }

                else if(name[i]=="Minor Burns"){

                    Description="For minor burns:\n\n"+

                    "Cool the burn to help soothe the pain. Hold the burned area under cool (not cold) running water for 10 to 15 minutes or until the pain eases. Or apply a clean towel dampened with cool tap water. \n \n" +

                    "Remove rings or other tight items from the burned area. Try to do this quickly and gently, before the area swells.\n \n"+
                            "Don't break small blisters (no bigger than your little fingernail). If blisters break, gently clean the area with mild soap and water, apply an antibiotic ointment, and cover it with a nonstick gauze bandage. \n \n"+
                    "Apply moisturizer or aloe vera lotion or gel, which may provide relief in some cases. \n"+
                   " If needed, take an over-the-counter pain reliever, such as ibuprofen (Advil, Motrin IB, others), naproxen sodium (Aleve) or acetaminophen (Tylenol, others). \n \n"+
                           " Consider a tetanus shot. Make sure that your tetanus booster is up to date. Doctors recommend people get a tetanus shot at least every 10 years.";


                    Toast.makeText(emergency_listview.this, "Minor Burns",
                            Toast.LENGTH_SHORT).show();
                    mIntent = new Intent(emergency_listview.this, emergency_details_display.class);
                    bundle.putString("D",Description);

                    bundle.putString("name",name[i]);
                    bundle.putInt("image",image[i]);


                    mIntent.putExtras(bundle);
                    startActivity(mIntent);


                }

                else if(name[i]=="Major Burns"){

                    Description="For major burns:\n\n"+
                            "Call 911 or emergency medical help for major burns. Until an emergency unit arrives, take these actions: \n \n"+

                    "Protect the burned person from further harm. If you can do so safely, make sure the person you're helping is not in contact with smoldering materials or exposed to smoke or heat. But don't remove burned clothing stuck to the skin. \n \n"+
                    "Check for signs of circulation. Look for breathing, coughing or movement. Begin CPR if needed. \n \n"+
                            "Remove jewelry, belts and other restrictive items, especially from around burned areas and the neck. Burned areas swell rapidly. \n \n"+
                    "Don't immerse large severe burns in cold water. Doing so could cause a serious loss of body heat (hypothermia) or a drop in blood pressure and decreased blood flow (shock). \n \n"+
                    "Elevate the burned area. Raise the wound above heart level, if possible. \n \n"+
                            "Cover the area of the burn. Use a cool, moist, bandage or a clean cloth.";


                    Toast.makeText(emergency_listview.this, "Major Burns",
                            Toast.LENGTH_SHORT).show();
                    mIntent = new Intent(emergency_listview.this, emergency_details_display.class);
                    bundle.putString("D",Description);

                    bundle.putString("name",name[i]);
                    bundle.putInt("image",image[i]);


                    mIntent.putExtras(bundle);
                    startActivity(mIntent);


                }

                else if(name[i]=="Choking"){

                    Description="Give 5 back blows. First, deliver five back blows between the person's shoulder blades with the heel of your hand. \n \n"+
                    "Give 5 abdominal thrusts. Perform five abdominal thrusts (also known as the Heimlich maneuver). \n \n"+
                    "Alternate between 5 blows and 5 thrusts until the blockage is dislodged.";


                    Toast.makeText(emergency_listview.this, "Choking",
                            Toast.LENGTH_SHORT).show();
                    mIntent = new Intent(emergency_listview.this, emergency_details_display.class);
                    bundle.putString("D",Description);

                    bundle.putString("name",name[i]);
                    bundle.putInt("image",image[i]);


                    mIntent.putExtras(bundle);
                    startActivity(mIntent);


                }

                else if(name[i]=="Heart Attack"){

                    Description="Have the person sit down , rest and try to keep calm \n \n"+
                            "Loosen any tight clothing \n \n"+
                            "Ask if the person takes any chest pain medication , such as nitroglycerin, for a known heart condition, and help them take it  \n\n"+
                            "If the pain does not go away with rest or within 3 minutes of taking nitroglycerin , call for emergency medical help.";


                    Toast.makeText(emergency_listview.this, "Heart Attack",
                            Toast.LENGTH_SHORT).show();
                    mIntent = new Intent(emergency_listview.this, emergency_details_display.class);
                    bundle.putString("D",Description);

                    bundle.putString("name",name[i]);
                    bundle.putInt("image",image[i]);


                    mIntent.putExtras(bundle);
                    startActivity(mIntent);


                }

                else if(name[i]=="Sting"){

                    Description="Wash with soap and water and apply an antiseptic if available \n \n"+
                            "Ensure that the patient's tetanus vaccination is up to date \n \n"+
                            "Apply an ice-pack to reduce local pain and swelling \n \n"+
                            "Pain relief may be required.Example Paracetamol (to reduce redness or itch)";


                    Toast.makeText(emergency_listview.this, "Sting",
                            Toast.LENGTH_SHORT).show();
                    mIntent = new Intent(emergency_listview.this, emergency_details_display.class);
                    bundle.putString("D",Description);

                    bundle.putString("name",name[i]);
                    bundle.putInt("image",image[i]);


                    mIntent.putExtras(bundle);
                    startActivity(mIntent);


                }




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
