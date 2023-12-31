package com.example.roomtask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.roomtask.Database.Logindatabase;
import com.example.roomtask.databinding.ActivityMainBinding;
import com.example.roomtask.model.Login;
import com.example.roomtask.Viewmodel.Loginviewmodel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerviewInterface {
    private Logindatabase logindatabase;
    private ArrayList<Login> contactsArrayList = new ArrayList<>();
    private MyAdapter myAdapter;
    private ActivityMainBinding mainBinding;
    private MainactivityCilckHandler handlers;
    Loginviewmodel viewmodel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        handlers = new MainactivityCilckHandler(this);

        mainBinding.setClick(handlers);


        RecyclerView recyclerView = mainBinding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);



        logindatabase = Logindatabase.getInstance(this);


        viewmodel = new ViewModelProvider(this)
                .get(Loginviewmodel.class);



        viewmodel.getLogindata3().observe(this,
                new Observer<List<Login>>() {
                    @Override
                    public void onChanged(List<Login> contacts) {

                        contactsArrayList.clear();

                        for (Login c : contacts) {
                            contactsArrayList.add(c);
                        }
                        myAdapter.setContacts((ArrayList<Login>) contacts);
                        myAdapter.notifyDataSetChanged();

                    }
                });



        myAdapter = new MyAdapter(contactsArrayList,this);


        recyclerView.setAdapter(myAdapter);




        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {


                Login c = contactsArrayList.get(viewHolder.getAdapterPosition());


                viewmodel.deleteLogindetail(c);
                Snackbar snackbar=Snackbar.make(mainBinding.getRoot(),"Item Deleted",Snackbar.LENGTH_LONG);
                snackbar.setActionTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white1));
                snackbar.setBackgroundTint(ContextCompat.getColor(getApplicationContext(),R.color.black));
                snackbar.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white1));
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        viewmodel.addLogindetail(c);


                    }
                })
               .show();

            }
        }).attachToRecyclerView(recyclerView);


    }

    @Override
    public void OnItemClick(int position) {
        UpdateFragment updateFragment=new UpdateFragment();

       Bundle bundle=new Bundle();
       bundle.putString("name",contactsArrayList.get(position).getName());
       bundle.putInt("id",contactsArrayList.get(position).getId());
        bundle.putString("email",contactsArrayList.get(position).getEmail());
updateFragment.setArguments(bundle);


        updateFragment.show(getSupportFragmentManager(), "UpdateFragment");


    }
}
