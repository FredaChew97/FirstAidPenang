package my.com.fredachew.firstaidpenang;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class knowledge_quiz extends AppCompatActivity {

    private static final String TAG="KnowlegeQuiz";
    private static final String KEY_INDEX="index";
    private static final int REQUEST_CODE_CHEAT=0;


    private Button TrueButton;
    private Button FalseButton;
    private Button NextButton;

    private Button CheatButton;

    private TextView QuestionTextView;

    private Question[] QuestionBank= new Question[]{
            new Question(R.string.question_1,false),
            new Question(R.string.question_2,true),
            new Question(R.string.question_3,true),
            new Question(R.string.question_4,false),
            new Question(R.string.question_5,true),
    };


    private int CurrentIndex=0;

    private boolean answerIsShown;

    private void updateQuestions(){

        int question =QuestionBank[CurrentIndex].getTextResId();
        QuestionTextView.setText(question);

        if(NextButton.isShown()&&CheatButton.isShown()){
            TrueButton.setVisibility(View.VISIBLE);
            FalseButton.setVisibility(View.VISIBLE);
            NextButton.setVisibility(View.GONE);
            CheatButton.setVisibility(View.GONE);
        }

    }

    private void checkAnswer(boolean userAnswer){
        boolean answerIsTrue=QuestionBank[CurrentIndex].isAnswerTrue();

        int messageId=0;

        if(answerIsShown){
            messageId=R.string.info_toast;
        }

       else {
            if (userAnswer == answerIsTrue) {
                messageId = R.string.correct_toast;
            } else {
                messageId = R.string.incorrect_toast;
            }

        }



        Toast.makeText(this,messageId,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_quiz);

        QuestionTextView=(TextView)findViewById(R.id.question_text_view) ;


        TrueButton=(Button)findViewById(R.id.true_button);
        TrueButton.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){
                checkAnswer(true);
                buttonVisible();

            }
        });
        FalseButton=(Button)findViewById(R.id.false_button);

        FalseButton.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){
                checkAnswer(false);
                buttonVisible();
            }
        });




        NextButton=(Button)findViewById(R.id.nextQuestion_button);
        NextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                CurrentIndex=(CurrentIndex+1)%QuestionBank.length;
                answerIsShown=false;
                updateQuestions();
            }
        });

        CheatButton=(Button)findViewById(R.id.cheat_button);
        CheatButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                boolean answerIsTrue=QuestionBank[CurrentIndex].isAnswerTrue();
                Intent i = Answer_for_Quiz.newIntent(knowledge_quiz.this,answerIsTrue);
                i.putExtra("Itemselected",CurrentIndex);
                startActivityForResult(i,REQUEST_CODE_CHEAT);
            }
        });

        if(savedInstanceState!=null){
            CurrentIndex=savedInstanceState.getInt(KEY_INDEX,0);
        }
        updateQuestions();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        if(resultCode!= Activity.RESULT_OK){
            return;
        }

        if(requestCode==REQUEST_CODE_CHEAT){
            if(data==null){
                return;
            }
            else{
                answerIsShown= Answer_for_Quiz.wasAnswerShown(data);
            }
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX,CurrentIndex);
    }

    private void buttonVisible(){
        if(NextButton.isShown()&&CheatButton.isShown()){
            NextButton.setVisibility(View.GONE);
            CheatButton.setVisibility(View.GONE);
        }

        else{
            NextButton.setVisibility(View.VISIBLE);
            CheatButton.setVisibility(View.VISIBLE);
            TrueButton.setVisibility(View.INVISIBLE);
            FalseButton.setVisibility(View.INVISIBLE);
        }
    }
}
