package my.com.fredachew.firstaidpenang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.thefinestartist.finestwebview.FinestWebView;

public class clinicNearYou extends AppCompatActivity {

    Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_near_you);
        button = (Button)findViewById(R.id.btnclinicNearYouNext);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                Log.d("BuTton click","wtf");
                new FinestWebView.Builder(getApplicationContext()).show("http://www.penang-traveltips.com/clinics.htm");
            }
        });
    }
}
