package my.com.fredachew.firstaidpenang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EmergencyCheckPatientInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_check_patient_info);


        final EditText title = (EditText)findViewById(R.id.editTextTitle);
        final EditText content = (EditText)findViewById(R.id.editTextContent);

        title.setBackgroundResource(R.drawable.edittext_bg);
        content.setBackgroundResource(R.drawable.edittext_bg);


        Button btn = (Button)findViewById(R.id.btnPatientInfo);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String contentString = content.getText().toString();

                String titleString = title.getText().toString();

                try {
                    String emailList[] = {"fredachew321@gmail.com"};
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("message/rfc822");
                    intent.putExtra(Intent.EXTRA_EMAIL,emailList);
                    intent.putExtra(Intent.EXTRA_SUBJECT,titleString);
                    intent.putExtra(Intent.EXTRA_TEXT,contentString);

                    Log.d("Email Subject",contentString);

                    startActivity(Intent.createChooser(intent, "Choose Email App"));

                    Log.i("Finished sending email.","");





                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(EmergencyCheckPatientInfo.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }


                Toast.makeText(EmergencyCheckPatientInfo.this, "Successfully sent", Toast.LENGTH_SHORT).show();



            }
        });




    }
}
