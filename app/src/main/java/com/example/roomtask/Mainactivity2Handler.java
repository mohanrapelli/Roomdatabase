package com.example.roomtask;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.roomtask.model.Login;
import com.example.roomtask.Viewmodel.Loginviewmodel;

public class Mainactivity2Handler {
    Context context;
    Login login;
    Loginviewmodel loginviewmodel;

    public Mainactivity2Handler(Context context, Login login, Loginviewmodel loginviewmodel) {
        this.context = context;
        this.login = login;
        this.loginviewmodel = loginviewmodel;
    }
    public void onBtnClicked(View view) {
        if (login.getName().isEmpty()|| login.getEmail().isEmpty()) {
            Toast.makeText(context, "Please fill the Above fields ", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(context, MainActivity.class);

            Login c = new Login(login.getName(), login.getEmail());

            loginviewmodel.addLogindetail(c);

            Toast.makeText(context, "Item inserted", Toast.LENGTH_SHORT).show();
            context.startActivity(i);

        }
    }

}
