package edu.uw.tcss450.phishapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        Intent intent = getActivity().getIntent();
        String email = intent.getStringExtra(MainActivity.EMAIL_KEY);

        TextView emailField = v.findViewById(R.id.emailDisplay);

        emailField.setText(email);

        return v;
    }

}
