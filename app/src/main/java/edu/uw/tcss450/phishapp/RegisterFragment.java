package edu.uw.tcss450.phishapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {



    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        //Button b = v.findViewById(R.id.button_register);
        //b.setOnClickListener(view -> onRegister(view));

        return v;
    }

    private void onRegister(View view) {
        EditText field1 = getActivity().findViewById(R.id.editTextEmail);
        EditText field2 = getActivity().findViewById(R.id.editTextPword1);
        EditText field3 = getActivity().findViewById(R.id.editTextPword2);

        String email = field1.getText().toString();
        String pword1 = field2.getText().toString();
        String pword2 = field3.getText().toString();

        if (pword1.equals(pword2)) {
            Intent intent = new Intent(getActivity(), HomeActivity.class);
            intent.putExtra(MainActivity.EMAIL_KEY, email);
            startActivity(intent);
        } else {
            field3.setError("Passwords must match");
        }

    }
}
