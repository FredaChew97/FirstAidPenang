package my.com.fredachew.firstaidpenang;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class our_services_listview extends Fragment {

    Intent mIntent;
    ListView mListView;
    public our_services_listview() {
        // Required empty public constructor
    }

    String[] name = {"Emergency Care ", "Hospital Near You", "Clinic Near You","Step By Step Handle Emergency Situation ","Do and Don’t When Facing Natural Disaster"};
    int[] image = {R.mipmap.health_check_home ,R.mipmap.hospital_near_you,R.mipmap.clinic_near_you,R.mipmap.emergencynav,R.mipmap.doanddont};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_view_main, container, false);
        mListView = (ListView) v.findViewById(R.id.listview);

        MyAdapter myAdapter = new MyAdapter(getActivity(), name, image);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.d(":)","Testing");

                if(name[i]=="Emergency Care ") {
                    Toast.makeText(getActivity(), "Health Care",
                            Toast.LENGTH_SHORT).show();
                   mIntent = new Intent(getActivity(), EmergencyCheck.class);

                }

                else if(name[i]=="Hospital Near You") {

                    Toast.makeText(getActivity(), "Hospital Near You",
                            Toast.LENGTH_SHORT).show();
                    mIntent = new Intent(getActivity(), hospitalNearYou.class);

                }

                else if(name[i]=="Clinic Near You"){

                    Toast.makeText(getActivity(), "Clinic Near You",
                            Toast.LENGTH_SHORT).show();
                   mIntent = new Intent(getActivity(), clinicNearYou.class);

                }

                else if(name[i]=="Step By Step Handle Emergency Situation "){

                    Toast.makeText(getActivity(), "Step By Step Handle Emergency Situation",
                            Toast.LENGTH_SHORT).show();
                    mIntent = new Intent(getActivity(), stepByStepEmergencySituationInfo.class);

                }

                else if(name[i]=="Do and Don’t When Facing Natural Disaster"){

                    Toast.makeText(getActivity(), "Do and Don’t When Facing Natural Disaster",
                            Toast.LENGTH_SHORT).show();
                    mIntent = new Intent(getActivity(),doAndDont_firstpage.class);

                }

//                mIntent.putExtra("Item", name[i]);
//                mIntent.putExtra("Image", image[i]);
//                mIntent.putExtra("Button",buttonNextService[i]);

                getActivity().startActivity(mIntent);


            }
        });


        return v;
    }

}
