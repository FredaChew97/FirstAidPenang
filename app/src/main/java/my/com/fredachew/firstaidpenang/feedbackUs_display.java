package my.com.fredachew.firstaidpenang;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class feedbackUs_display extends Fragment {

    Intent intent;

    public feedbackUs_display() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_feedback_us_info,
                container, false);
        Button button = (Button) view.findViewById(R.id.buttonNextToProceed_id);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (v.getId()) {
                    case R.id.buttonNextToProceed_id:
                        Log.d("BUTTON", "BUTTON PRESSED");
                    intent = new Intent(getActivity(), feedbackUsForm.class);
                    startActivity(intent);

                    break;
                }
            }
        });
        return view;
    }


}
