package my.com.fredachew.firstaidpenang;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Answer_for_Quiz extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE="my.com.fredachew.hospitalapp.answer_is_true";

    private static final String EXTRA_ANSWER_SHOWN="my.com.fredachew.hospitalapp.answer_shown";
    private boolean AnswerIsTrue;



    private TextView AnswerTextView;
    private Button ShowAnswer;

    private TextView InfoTextView;

    public static Intent newIntent(Context packagaeContext, boolean answerIsTrue){
        Intent i = new Intent(packagaeContext,Answer_for_Quiz.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue);
        return i ;
    }

    public static boolean wasAnswerShown(Intent result){
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN,false);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_answer);

        AnswerIsTrue=getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);
        AnswerTextView=(TextView)findViewById(R.id.answer_text_view);

        ShowAnswer=(Button)findViewById(R.id.show_answer_button);
        ShowAnswer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(AnswerIsTrue){
                    AnswerTextView.setText(R.string.true_button);
                    questionDescription();
                }

                else{
                    AnswerTextView.setText(R.string.false_button);
                    questionDescription();
                }

                setAnswerShownResult(true);
            }
        });
    }

    private void setAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN,isAnswerShown);
        setResult(RESULT_OK,data);
    }

    private void questionDescription(){
        Intent i =getIntent();
        InfoTextView=(TextView)findViewById(R.id.info_text_view);
        int listItem = i.getIntExtra("Itemselected",5);

        if(listItem==0){

            InfoTextView.setText("In Malaysia , the emergency hotline is 999");
        }

        else if(listItem==1){
            InfoTextView.setText("This is to avoid the patient situation to become worst which might lead to death");
        }

        else if(listItem==2){
            InfoTextView.setText("Throw away expired date medicine and do not consume medicine without clear label and description");
        }

        else if(listItem==3){
            InfoTextView.setText("It depends on the doctor guidelines to patient");
        }

        else if(listItem==4){
            InfoTextView.setText("Store medicines in safe area to ensure children safety");
        }
    }
}
