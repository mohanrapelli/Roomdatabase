package com.example.roomtask;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.roomtask.Viewmodel.Loginviewmodel;
import com.example.roomtask.databinding.FragmentUpdateBinding;
import com.example.roomtask.model.Login;

import java.util.Objects;

public class UpdateFragment extends DialogFragment {
    Login login;
    Loginviewmodel loginviewmodel;
    Context context;



    public UpdateFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentUpdateBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_update, container, false);
        loginviewmodel = new ViewModelProvider(this).get(Loginviewmodel.class);
        login = new Login();

        if (getArguments() != null) {
            String a1 = getArguments().getString("name");
            String a2 = getArguments().getString("email");
            String a3 = String.valueOf(getArguments().getInt("id", -1));
            login.setName(a1);
            login.setEmail(a2);
            login.setId(Integer.parseInt(a3));
            binding.setContact(login);


        }
        binding.submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login.getName().isEmpty() || login.getEmail().isEmpty()) {
                    Toast.makeText(getContext(), "Please fill the Above fields ", Toast.LENGTH_SHORT).show();
                } else {
                    if (loginviewmodel != null) {
                        loginviewmodel.updateLogindetail(login);
                        Intent intent = new Intent(requireActivity().getApplication(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getContext(), "Data is not Added", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(requireActivity().getApplication(), MainActivity.class);
                startActivity(intent);
            }
        });
        return binding.getRoot();
    }


}