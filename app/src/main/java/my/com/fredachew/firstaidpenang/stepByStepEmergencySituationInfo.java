package my.com.fredachew.firstaidpenang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class stepByStepEmergencySituationInfo extends AppCompatActivity {

    Button btnNext;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_by_step_emergency_situation_info);

        btnNext = (Button)findViewById(R.id.btnsbsemergency);
        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(stepByStepEmergencySituationInfo.this, emergency_listview.class);
                startActivity(intent);

            }
        });
    }

}
