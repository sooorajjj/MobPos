package online.klok.mobpos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final EditText etUsername = (EditText) findViewById(R.id.etUserName);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final TextView welcomeMessage = (TextView) findViewById(R.id.tvWelcomeMsg);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
//
//        TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
//        EditText etUsername = (EditText) findViewById(R.id.etUsername);
//        EditText etEmail = (EditText) findViewById(R.id.etEmail);

        // Display user details
        String message = name + " welcome to your user area";
        welcomeMessage.setText(message);
        etUsername.setText(username);
        etEmail.setText(email);
    }
}