package com.example.roomtask.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomtask.model.Login;
import com.example.roomtask.Repository.Repository;

import java.util.List;

public class Loginviewmodel extends AndroidViewModel {
private Repository repository;
    private LiveData<List<Login>> allLogin;


    public Loginviewmodel(@NonNull Application application) {
        super(application);
        this.repository=new Repository(application);
    }
    public LiveData<List<Login>> getLogindata3(){
        allLogin= repository.getlogindata2();
        return allLogin;

    }
   public void addLogindetail(Login login){
        repository.addLogin(login);


    }

    public void deleteLogindetail(Login login){
        repository.deleteLogin(login);
    }
    public void updateLogindetail(Login login){
        repository.updateLogin(login);
    }
}
