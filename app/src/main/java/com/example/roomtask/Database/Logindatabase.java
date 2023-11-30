package com.example.roomtask.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomtask.DAO.Logindao;
import com.example.roomtask.model.Login;

@Database(entities = {Login.class},version = 1)
public abstract class Logindatabase extends RoomDatabase {
    private static Logindatabase logindatabase;
    public abstract Logindao logindao();


    public static synchronized Logindatabase getInstance(Context context){
        if (logindatabase==null){
            logindatabase= Room.databaseBuilder(context.getApplicationContext(),
                    Logindatabase.class,"Login_db").fallbackToDestructiveMigration().build();
        }
        return logindatabase;
    }



}
