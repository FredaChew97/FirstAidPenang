package my.com.fredachew.firstaidpenang;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class do_n_dont_each_display extends AppCompatActivity {

    TextView mTextview;
    ImageView mImageView;

    TextView TextDo;
    TextView TextDont;

    Button btnBack;
    Intent intent;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_natural_disaster_do_n_dont_display);

        mTextview=(TextView)findViewById(R.id.activityDetail);
        mImageView = (ImageView) findViewById(R.id.imageView2);
        TextDo=(TextView)findViewById(R.id.DoDescription);
        TextDont=(TextView)findViewById(R.id.DonDescription);

        btnBack=(Button)findViewById(R.id.buttonBack);



        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
//            mToolbar.setTitle(mBundle.getString("Name"));
             mTextview.setText(mBundle.getString("name"));
            mImageView.setImageResource(mBundle.getInt("image"));
            TextDo.setText(mBundle.getString("doD"));

            TextDont.setText(mBundle.getString("donD"));

        }

        btnBack.setOnClickListener(new View.OnClickListener(){
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