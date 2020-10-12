package com.lnt.navigationdrawerexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Shared#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Shared extends Fragment {

    Button button_save,button_retrieve,button_clear;
    EditText name,email;
    SharedPreferences sharedPreferences;

    public static final String mypreferences="mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Shared() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Shared.
     */
    // TODO: Rename and change types and number of parameters
    public static Shared newInstance(String param1, String param2) {
        Shared fragment = new Shared();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shared, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button_save=(Button) view.findViewById(R.id.save);
        button_retrieve=(Button) view.findViewById(R.id.retrieve);
        button_clear=(Button) view.findViewById(R.id.clear);

        name = (EditText) view.findViewById(R.id.name);
        email= (EditText) view.findViewById(R.id.email);

        sharedPreferences = getActivity().getSharedPreferences(mypreferences, Context.MODE_PRIVATE);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String n = name.getText().toString();
                String e = email.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(Name, n);
                editor.putString(Email,e);
                editor.commit();
            }
        });
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name.setText("");
                email.setText("");
            }
        });


        button_retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                sharedPreferences = getActivity().getSharedPreferences(mypreferences,Context.MODE_PRIVATE);

                if(sharedPreferences.contains(Name)){
                    name.setText(sharedPreferences.getString(Name, ""));
                }
                if(sharedPreferences.contains(Email)){
                    email.setText(sharedPreferences.getString(Email, ""));
                }
            }
        });

    }
}