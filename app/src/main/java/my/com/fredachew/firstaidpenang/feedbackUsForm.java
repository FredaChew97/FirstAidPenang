package my.com.fredachew.firstaidpenang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class feedbackUsForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_us_form);

        // Do click handling here

        final EditText feedbackTitle = (EditText)findViewById(R.id.feedbackTitle);
        final EditText feedbackField = (EditText)findViewById(R.id.EditTextFeedbackBody);

        feedbackTitle.setBackgroundResource(R.drawable.edittext_bg);
        feedbackField.setBackgroundResource(R.drawable.edittext_bg);

        Button startBtn = (Button) findViewById(R.id.ButtonSendFeedback);


        startBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                String feedback = feedbackField.getText().toString();

                String feedbackHeader = feedbackTitle.getText().toString();

                try {
                    String emailList[] = {"fredachew321@gmail.com"};
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("message/rfc822");
                    intent.putExtra(Intent.EXTRA_EMAIL,emailList);
                    intent.putExtra(Intent.EXTRA_SUBJECT,feedbackHeader);
                    intent.putExtra(Intent.EXTRA_TEXT,feedback);

                    Log.d("Email Subject",feedback);

                    startActivity(Intent.createChooser(intent, "Choose Email App"));

                    Log.i("Finished sending email.","");

                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(feedbackUsForm.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }




            }
        });

    }

}