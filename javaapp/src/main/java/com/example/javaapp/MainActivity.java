package com.example.javaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.javaapp.data.DataSet;
import com.example.javaapp.data.Person;

public class MainActivity extends AppCompatActivity {
    private PersonsAdapter personsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
    }

    private void initView() {
        personsAdapter = new PersonsAdapter(DataSet.persons);
        RecyclerView rvPersons = findViewById(R.id.rv_persons);
        rvPersons.setLayoutManager(new LinearLayoutManager(this));
        rvPersons.setAdapter(personsAdapter);
    }

    private void initEvent() {
        personsAdapter.setItemClickListener(person -> {
            AlertDialog.Builder dialog = new AlertDialog
                    .Builder(this)
                    .setTitle(person.getFullName())
                    .setMessage(String.valueOf(person.getAge()))
                    .setPositiveButton("확인", null);
            dialog.show();
        });
        findViewById(R.id.fab_add).setOnClickListener(view -> {
            Toast.makeText(this, "Add Button Click!", Toast.LENGTH_SHORT).show();
        });
    }
}