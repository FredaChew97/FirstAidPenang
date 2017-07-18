package my.com.fredachew.firstaidpenang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class emergency_details_display extends AppCompatActivity {

    TextView mTextview;
    ImageView mImageView;

    TextView TextDescp;
    Button btnBackEmergency;
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_display);

        mTextview=(TextView)findViewById(R.id.stepDescription);
        mImageView = (ImageView) findViewById(R.id.imageViewD);
        TextDescp=(TextView)findViewById(R.id.emergencyDetails);


        btnBackEmergency=(Button)findViewById(R.id.buttonBackE);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
//            mToolbar.setTitle(mBundle.getString("Name"));
            mTextview.setText(mBundle.getString("D"));
            mImageView.setImageResource(mBundle.getInt("image"));
            TextDescp.setText(mBundle.getString("name"));


        }

        btnBackEmergency.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){

                onBackPressed();
            }
        });


    }

    @Override
    public void onBackPressed(){

        finish();
    }



}
