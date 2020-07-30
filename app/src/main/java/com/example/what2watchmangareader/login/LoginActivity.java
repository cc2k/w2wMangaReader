package com.example.what2watchmangareader.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.what2watchmangareader.R;

import java.util.ArrayList;

import Classes.User;

public class LoginActivity extends AppCompatActivity {


    //TODO
    //this need regex
    //this need security


    EditText tvUsername;
    EditText tvPassword;
    ArrayList<User> testUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        tvUsername = (EditText) findViewById(R.id.et_username);
        tvPassword = (EditText) findViewById(R.id.et_password);
        Button buttonLogin = (Button) findViewById(R.id.btn_login);
        buttonLogin.setOnClickListener(onClickButtonLogin);


        User henk = new User("henk", "henkie", 1, 1);
        User jan = new User("jan", "jantje", 2, 2);
        User piet = new User("piet", "piettje", 3, 3);
        User hennie = new User("hennie", "hennietje", 4, 4);
        User patricia = new User("patricia", "patriciatje", 5, 5);

        testUsers = new ArrayList<User>();

        testUsers.add(henk);
        testUsers.add(jan);
        testUsers.add(piet);
        testUsers.add(hennie);
        testUsers.add(patricia);
    }


    //get a list of user ------  should not be here
    //check the username with usernames in the list
    //if true, check password with the password
    //if true go to main activity
    //if false get error msg    username or password is incorrect
    boolean textFalse = false;

    private View.OnClickListener onClickButtonLogin = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String username;
            String password;
            username = tvUsername.getText().toString();
            password = tvPassword.getText().toString();

            if (username == null || password == null || username.matches("") || password.matches("")) {
                Toast.makeText(LoginActivity.this, "Fill in username/password", Toast.LENGTH_SHORT).show();
            } else {
                textFalse = true;
            }

            if (textFalse) {


                for (int i = 0; i <= testUsers.size() - 1; i++) {
                    if (testUsers.get(i).getUsername().equals(username) && testUsers.get(i).getPassword().equals(password)) {
                        Toast.makeText(LoginActivity.this, "SUCCESS!!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Wrong username/Password", Toast.LENGTH_SHORT).show();
                        textFalse = false;
                    }
                }
            }
        }


    };
}

