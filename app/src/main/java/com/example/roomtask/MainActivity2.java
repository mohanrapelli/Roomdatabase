package com.example.roomtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.roomtask.model.Login;
import com.example.roomtask.Viewmodel.Loginviewmodel;
import com.example.roomtask.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
  private   ActivityMain2Binding activityMain2Binding;
  private   Mainactivity2Handler handler;
   private Login login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        activityMain2Binding= DataBindingUtil.setContentView(this,R.layout.activity_main2);
login=new Login();
        Loginviewmodel myViewModel = new ViewModelProvider(this)
                .get(Loginviewmodel.class);

        handler = new Mainactivity2Handler(this,login,myViewModel);


        activityMain2Binding.setContact(login);
        activityMain2Binding.setClickHandler(handler);
    }
}