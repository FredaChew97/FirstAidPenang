package my.com.fredachew.firstaidpenang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class doAndDont_firstpage extends AppCompatActivity {

    Button btndoAndDontAc;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_and_dont_info);

        btndoAndDontAc = (Button)findViewById(R.id.btndoanddont);
        btndoAndDontAc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(doAndDont_firstpage.this, do_and_dont_list.class);
                startActivity(intent);

            }
        });
    }



}
