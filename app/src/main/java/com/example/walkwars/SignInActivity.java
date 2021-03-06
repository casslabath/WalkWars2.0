package com.example.walkwars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {

    ImageButton signinButton;
    EditText emailInput;
    EditText passwordInput;
    TextView signinText;
    TextView signUpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signinButton = (ImageButton) findViewById(R.id.signin_button);
        emailInput = (EditText) findViewById(R.id.email_input);
        passwordInput = (EditText) findViewById(R.id.password_input);
        signinText = (TextView) findViewById(R.id.signin_txt);
        signUpText = (TextView) findViewById(R.id.sign_up_txt);

        signinButton.setEnabled(false);

        emailInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) { inputFilled(); }
        });

        passwordInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) { inputFilled(); }
        });

        signUpText.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpOnClick();
            }
        });
    }

    protected void inputFilled(){
        if(!emailInput.getText().toString().isEmpty() && !passwordInput.getText().toString().isEmpty()){
            signinButton.setEnabled(true);
            signinButton.setAlpha((float)1.0);
            signinText.setAlpha(1);
        } else {
            signinButton.setEnabled(false);
            signinButton.setAlpha((float)0.3);
            signinText.setAlpha((float)0.5);
        }
    }

    public void signUpOnClick(){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}

