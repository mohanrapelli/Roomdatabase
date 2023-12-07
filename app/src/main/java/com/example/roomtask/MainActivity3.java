package com.example.roomtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Handler;

import com.example.roomtask.Viewmodel.Loginviewmodel;
import com.example.roomtask.databinding.ActivityMain3Binding;
import com.example.roomtask.model.Login;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private ActivityMain3Binding activityMain3Binding;
    private Login login;
    private Mainactivity3Handler handler;

    private ArrayList<Login> contactsArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        activityMain3Binding = DataBindingUtil.setContentView(this, R.layout.activity_main3);
        Loginviewmodel myViewModel = new ViewModelProvider(this)
                .get(Loginviewmodel.class);

        login = new Login();
        handler = new Mainactivity3Handler(this, login, myViewModel);


        if (getIntent().getExtras() != null) {
            String a1 = getIntent().getStringExtra("name");
            String a2 = getIntent().getStringExtra("email");
            String a3 = String.valueOf(getIntent().getIntExtra("id", -1));
            login.setName(a1);
            login.setEmail(a2);
            login.setId(Integer.parseInt(a3));
            activityMain3Binding.setContact(login);
            activityMain3Binding.setOnclickitem(handler);
        }
    }
}