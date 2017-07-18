package my.com.fredachew.firstaidpenang;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class myProfile extends Fragment implements View.OnClickListener{

    View v;
    Intent intent;

    myProfile activityCommander;


    public myProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     v=inflater.inflate(R.layout.fragment_my_profile, container, false);

        Button btnaboutus = (Button)v.findViewById(R.id.btnAboutUs);
        btnaboutus.setOnClickListener(this);

        Button btnOurService = (Button)v.findViewById(R.id.btnOurService);
        btnOurService.setOnClickListener(this);

        Button btnKnowledgeQuiz=(Button)v.findViewById(R.id.knowledge_quiz);
        btnKnowledgeQuiz.setOnClickListener(this);

        Button btnFeedbackUs=(Button)v.findViewById(R.id.btnFeedbackUs);
        btnFeedbackUs.setOnClickListener(this);

        intent = new Intent(getActivity(),login.class);
        Button btnlogout = (Button)v.findViewById(R.id.logout);

        btnlogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(intent);
            }

        });

        return v;
    }

    public void replaceFragment(Fragment someFragment){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.flContent,someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(View v){
        Fragment fragment=null;
        switch(v.getId()){

            case R.id.btnAboutUs:
                fragment = new aboutUs();
                replaceFragment(fragment);
                break;

            case R.id.btnOurService:
                fragment = new our_services_listview();
                replaceFragment(fragment);
                break;

            case R.id.knowledge_quiz:
                fragment = new knowledge_quiz_display();
                replaceFragment(fragment);
                break;

            case R.id.btnFeedbackUs:
                fragment = new feedbackUs_display();
                replaceFragment(fragment);
                break;
        }
    }

}
