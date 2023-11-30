package br.com.map.cervezas.ui;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import br.com.map.cervezas.R;
import br.com.map.cervezas.ui.news.LoginViewModel;

public class LoginActivity extends AppCompatActivity{
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        EditText usernameEditText = findViewById(R.id.editTextUsername);
        Button loginButton = findViewById(R.id.buttonLogin);

        //SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString("username", "");
        viewModel.setUsername(savedUsername);

        viewModel.getUsername().observe(this, username -> {
            usernameEditText.setText(username);
        });

        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", username);
            editor.apply();

            //nombre no puede ser vacio
            if(username.equals("")){
                String mensaje = "Ingrese un nombre";
                Toast toast = Toast.makeText(this,mensaje , Toast.LENGTH_LONG);
                toast.show();
            } else{
                Intent openLandingPage = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(openLandingPage);
            }
        });
    }
}
