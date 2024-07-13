package com.asa.postfreeapp.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.asa.postfreeapp.R;
import com.asa.postfreeapp.app.BaseActivity;
import com.asa.postfreeapp.models.requests.RegisterRequest;
import com.asa.postfreeapp.presenters.RegisterPresenter;
import com.asa.postfreeapp.views.RegisterView;

public class RegisterActivity extends BaseActivity implements RegisterView {
    private EditText firstName, lastName, userName, email, phone, password, confirmPassword;
    private Button btnRegister;
    private ProgressBar progressBar;
    private RegisterPresenter registerPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        registerPresenter = new RegisterPresenter(this);
        initView();
    }
    private void initView(){
        progressBar = findViewById(R.id.progressBar);
        firstName = findViewById(R.id.etFirstName);
        lastName = findViewById(R.id.etLastName);
        userName = findViewById(R.id.etUserName);
        phone = findViewById(R.id.etPhone);
        email = findViewById(R.id.etEmail);
        firstName = findViewById(R.id.etFirstName);
        password = findViewById(R.id.etPassword);
        confirmPassword = findViewById(R.id.etConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterRequest request = new RegisterRequest();
                request.setFirstName(firstName.getText().toString().trim());
                request.setLastName(lastName.getText().toString().trim());
                request.setUsername(userName.getText().toString().trim());
                request.setPhoneNumber(phone.getText().toString().trim());
                request.setEmail(email.getText().toString().trim());
                request.setPassword(password.getText().toString().trim());
                request.setConfirmPassword(confirmPassword.getText().toString().trim());
                request.setRole("USER");
                request.setProfile("NON");
                registerPresenter.register(request);
            }
        });
    }

    @Override
    public void onLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onMidingLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(String message) {
        showMessage(message);
    }

    @Override
    public void onSuccess(Object message) {
        showMessage("Register Success");
    }
}