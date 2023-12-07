package com.example.roomtask.Repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import com.example.roomtask.DAO.Logindao;
import com.example.roomtask.Database.Logindatabase;
import com.example.roomtask.model.Login;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Repository {

 private final Logindao logindao;
 private final ExecutorService service;
Login login;
 private final Handler handler;

    public Repository(Application application) {
        Logindatabase logindatabase=Logindatabase.getInstance(application);
        this.logindao = logindatabase.logindao();
        service = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());

    }
    public void addLogin(Login login){
        service.execute(() ->{
            logindao.insert(login);
        });
    }
    public void deleteLogin(Login login) {
        service.execute(() -> {
            logindao.delete(login);
        });
    }
    public void updateLogin(Login login){
        service.execute(() ->{
            logindao.update(login);
        });
    }
    public LiveData<List<Login>> getlogindata2(){
        return logindao.getlogindata();
    }



}
