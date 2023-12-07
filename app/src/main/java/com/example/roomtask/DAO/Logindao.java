package com.example.roomtask.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomtask.model.Login;

import java.util.List;

@Dao
public interface Logindao {
    @Insert

    void insert(Login login);

    @Delete
    void delete(Login login);

    @Update
    void update(Login login);



    @Query("SELECT * FROM login_table")
    LiveData<List<Login>> getlogindata();


}
