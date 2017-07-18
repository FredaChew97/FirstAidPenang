package my.com.fredachew.firstaidpenang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.thefinestartist.finestwebview.FinestWebView;

public class hospitalNearYou extends AppCompatActivity {

    Button btnHospitalNearYou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hospital_near_you);

        btnHospitalNearYou = (Button)findViewById(R.id.btnhospitalNearYou);
        btnHospitalNearYou.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                Log.d("BuTton click","Proceed");
                new FinestWebView.Builder(getApplicationContext()).show("http://www.penang-traveltips.com/hospitals.htm");


            }
        });
    }
}
