package online.klok.mobpos;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final TextView registerLink = (TextView) findViewById(R.id.tvRegisterHere);

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);


            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = (EditText) findViewById(R.id.etUserName);
                EditText password = (EditText) findViewById(R.id.etPassword);

                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    Intent loginIntent = new Intent(LoginActivity.this, AdminAreaActivity.class);
                    LoginActivity.this.startActivity(loginIntent);
                } else if(username.getText().toString().equals("manager") && password.getText().toString().equals("manager")) {
                    Intent loginIntent = new Intent(LoginActivity.this, ManagerAreaActivity.class);
                    LoginActivity.this.startActivity(loginIntent);
                }else if(username.getText().toString().equals("user") && password.getText().toString().equals("user")) {
                    Intent loginIntent = new Intent(LoginActivity.this, UserAreaActivity.class);
                    LoginActivity.this.startActivity(loginIntent);
                }else {
                    //wrong password
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.testmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.action_about:
                aboutMenuItem();
                break;
        }
        return true;
    }
    private void aboutMenuItem(){
        new AlertDialog.Builder(this)
                .setTitle("About")
                .setMessage("Created by Klok Innovations "+" Copyright 2015 ©. All rights reserved")
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
    }

}