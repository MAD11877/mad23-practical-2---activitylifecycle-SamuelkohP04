package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

public class MainActivity extends AppCompatActivity {
    final String TITLE = "Main Activity";
    boolean hasFollowed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        // Set the title text color to white
        toolbar.setTitleTextColor(Color.WHITE);

        User myUser = new User();
        myUser.setName("Hello World!");
        // Create an instance of the LoremIpsum class
        Lorem lorem = LoremIpsum.getInstance();

        // Generate a paragraph of Lorem Ipsum text
        String paragraph = lorem.getParagraphs(1, 1);

        // Display the generated text
        TextView textView = findViewById(R.id.textView2);

        myUser.setDescription(paragraph);
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
}