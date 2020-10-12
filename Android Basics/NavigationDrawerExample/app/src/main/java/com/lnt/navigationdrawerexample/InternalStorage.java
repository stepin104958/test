package com.lnt.navigationdrawerexample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InternalStorage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InternalStorage extends Fragment {

    public static final int READ_BLOCK_SIZE=100;
    Button button_InternalStorage;
    Button button_clear1,button_read,button_write;
    EditText input;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InternalStorage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InternalStorage.
     */
    // TODO: Rename and change types and number of parameters
    public static InternalStorage newInstance(String param1, String param2) {
        InternalStorage fragment = new InternalStorage();
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
        return inflater.inflate(R.layout.fragment_internal_storage, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);

        button_InternalStorage = view.findViewById(R.id.button_InternalStorage);

        button_InternalStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NavController navController = Navigation.findNavController(view);

                navController.navigate(R.id.action_nav_internalStorage_to_nav_externalStorage);

            }
        });

        button_clear1 = (Button) view.findViewById(R.id.clear1);
        button_read = (Button) view.findViewById(R.id.read);
        button_write = (Button) view.findViewById(R.id.write);
        input = (EditText) view.findViewById(R.id.inputfield);

        button_clear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
            }
        });


        button_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fileout = getActivity().openFileOutput("mytextfile.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(input.getText().toString());
                    outputWriter.close();
                    //display file saved message
                    Toast.makeText(getActivity(), "File saved successfully!", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        button_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fileIn=getActivity().openFileInput("mytextfile.txt");
                    InputStreamReader InputRead= new InputStreamReader(fileIn);
                    char[] inputBuffer= new char[READ_BLOCK_SIZE];
                    String s="";
                    int charRead;
                    while ((charRead=InputRead.read(inputBuffer))>0) {
                        // char to string conversion
                        String readstring=String.copyValueOf(inputBuffer,0,charRead);
                        s +=readstring;
                    }
                    InputRead.close();
                    input.setText(s);
                    Toast.makeText(getActivity(), s,Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }


}


