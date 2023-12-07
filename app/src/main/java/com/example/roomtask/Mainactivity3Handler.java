package com.example.roomtask;

import static android.content.Intent.getIntent;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.roomtask.DAO.Logindao;
import com.example.roomtask.Repository.Repository;
import com.example.roomtask.Viewmodel.Loginviewmodel;
import com.example.roomtask.model.Login;

import java.util.ArrayList;
import java.util.List;

public class Mainactivity3Handler {
    private Context context;
    private Login login;
    private   Loginviewmodel loginviewmodel;



    public Mainactivity3Handler(Context context, Login login, Loginviewmodel loginviewmodel) {
        this.context = context;
        this.login = login;
        this.loginviewmodel = loginviewmodel;
    }

    public void oneditbutton(View view) {
        if (login.getName().isEmpty() || login.getEmail().isEmpty()) {
            Toast.makeText(context, "Please fill the Above fields ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            context.startActivity(intent);
        } else {
            if (loginviewmodel != null) {
                loginviewmodel.updateLogindetail(login);
                loginviewmodel.addLogindetail(login);
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                context.startActivity(intent);
            } else {
                Toast.makeText(context, "Data is not Added", Toast.LENGTH_SHORT).show();
            }


        }
    }
        public void onCloseclicked(View view){
        Intent intent=new Intent(view.getContext(), MainActivity.class);
        context.startActivity(intent);

    }
}
