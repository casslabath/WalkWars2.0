package com.example.walkwars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    ImageButton signinButton;
    EditText emailInput;
    EditText passwordInput;
    TextView signinText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signinButton = (ImageButton) findViewById(R.id.signin_button);
        emailInput = (EditText) findViewById(R.id.email_input);
        passwordInput = (EditText) findViewById(R.id.password_input);
        signinText = (TextView) findViewById(R.id.signin_txt);

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
}
