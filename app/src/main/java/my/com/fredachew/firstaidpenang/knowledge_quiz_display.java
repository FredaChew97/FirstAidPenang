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
public class knowledge_quiz_display extends Fragment {

    Intent kintent;
    public knowledge_quiz_display() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_knowledge_quiz_info,
                container, false);
        Button button = (Button) view.findViewById(R.id.btnKnowlegeNextPage);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (v.getId()) {
                    case R.id.btnKnowlegeNextPage:
//                        Log.d("BUTTON", "BUTTON PRESSED");
                        kintent = new Intent(getActivity(), knowledge_quiz.class);
                        startActivity(kintent);

                        break;
                }
            }
        });
        return view;
    }

}
