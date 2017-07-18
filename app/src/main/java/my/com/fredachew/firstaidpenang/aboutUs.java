package my.com.fredachew.firstaidpenang;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class aboutUs extends Fragment{

    View view;
    Intent mintent;

    public aboutUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.fragment_about_us, container, false);

        mintent = new Intent(getActivity(), main_activity.class);
        final Button button = (Button) view.findViewById(R.id.buttonBackToProfile);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(mintent);
            }
        });
        return view;

    }

}
