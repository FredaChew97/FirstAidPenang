package my.com.fredachew.firstaidpenang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmergencyCheck extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_emergency_check);

        Button btnHealthCheck = (Button) findViewById(R.id.btnhealthcheckdescription);

        btnHealthCheck.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(EmergencyCheck.this, EmergencyCheckPatientInfo.class));
            }
        });
    }



}
