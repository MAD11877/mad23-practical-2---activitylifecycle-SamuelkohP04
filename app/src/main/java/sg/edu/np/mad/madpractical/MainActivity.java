package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.s10243052madpractical2.R;

public class MainActivity extends AppCompatActivity {
    final String TITLE = "Main Activity";
    boolean hasFollowed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//instantiates new user
        User myUser = new User();
        myUser.setName("Hello World!");
        myUser.setDescription("Hi this represents a long text. \n" +
                "Tomorrow is the day after two yesterdays.\n " +
                "At the end of the day, it's night. \n");
        myUser.setId(R.id.textView3); //setId refers to the id of "Hello World" in bold.
        myUser.setFollowed(false);

        // Applying from the name and desc attributes from the
        // User object, to the text boxes.
        TextView myTextName = findViewById(myUser.getId());
        myTextName.setText(myUser.getName());

        TextView myTextDesc = findViewById(R.id.textView2);
        myTextDesc.setText(myUser.getDescription());

        Button myButton = findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myUser.setFollowed(!myUser.isFollowed());

                Log.v(TITLE, String.valueOf(hasFollowed));
                if (myUser.isFollowed()) { myButton.setText("Unfollow");}
                else { myButton.setText("Follow"); }
            }
        });
        Log.v(TITLE, "On Create!");
    }


    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TITLE, "On Start!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TITLE,"On Resume!");

        User myUser = new User();
        myUser.getName();

        Button myButton = findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hasFollowed = !hasFollowed;
                Log.v(TITLE, "Follow button is pressed");

                //Log.v(TITLE, String.valueOf(hasFollowed));
                if (!hasFollowed) { myButton.setText("Unfollow");}
                else { myButton.setText("Follow"); }
            }
        });

        Button myButton2 = findViewById(R.id.button2);
        myButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TITLE, "Message button is pressed");
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TITLE, "On Stop!");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TITLE,"On Pause!");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TITLE, "On Destroy");
    }

}