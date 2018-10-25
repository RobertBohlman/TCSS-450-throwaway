package edu.uw.tcss450.phishapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements LoginFragment.OnFragmentInteractionListener {

    public static String EMAIL_KEY = "EMAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            if (findViewById(R.id.frame_main) != null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frame_main, new LoginFragment())
                        .commit();
            }
        }
    }

    public void loadFragment(Fragment frag) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_main, frag)
                .addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onLoginClick(View view) {
        EditText emailField = findViewById(R.id.editTextEmail);
        String email = emailField.getText().toString();
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(EMAIL_KEY, email);
        startActivity(intent);
    }

    @Override
    public void onRegisterClick(View view) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_main, new RegisterFragment())
                .addToBackStack(null);
        transaction.commit();
    }
}
