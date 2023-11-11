package com.example.app_demo.Fragments.AddFragment;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.app_demo.R;
import com.example.app_demo.databinding.FragmentAddBinding;


public class AddFragment extends Fragment {


    public AddFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    FragmentAddBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add, container, false);

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.edtName.getText().toString().trim();
                String location = binding.edtLocation.getText().toString().trim();

                boolean is_parking_available = true;
                if (binding.rbNo.isChecked()) {
                    is_parking_available = false;
                } else if (binding.rbYes.isChecked()) {
                    is_parking_available = true;
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());//getActivity()

                if (name.isEmpty() || location.isEmpty()) {
                    builder.setTitle("Error");
                    builder.setMessage("All required field must be filled");
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(), "YES", Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.show();
                } else {
                    //dialog confirmation
                    builder.setTitle("Confirmation");
                    builder.setMessage(
                            "New hike will be added: " +
                                    "\nName: " + name +
                                    "\nLocation: " + location +
                                    "\nParking Available: " + (is_parking_available ? "Yes" : "No") +
                                    "\nAre you sure?"
                    );

                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(), "YES", Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(), "CANCEL", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });

                    builder.show();
                }
            }
        });


        return binding.getRoot();
//        return inflater.inflate(R.layout.fragment_add, container, false);
    }
}