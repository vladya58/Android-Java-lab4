package com.example.lab3;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.jetbrains.annotations.Nullable;

public class MainActivity extends AppCompatActivity {
    EditText inLogin;
    EditText inPas;
    SharedPreferences settingEnter;
    SharedPreferences.Editor editor;

    private static final String NAME = "login";
    private static final String PASSWORD = "pas";
    @Override
    protected void onStart(){
        super.onStart();
        Log.i("ON START", "Start");

        setContentView(R.layout.autho);
        Intent intent = new Intent(this, list.class);
        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button6);


        inLogin = findViewById(R.id.editTextTextPersonName);
        inPas = findViewById(R.id.editTextTextPassword);

        Bundle bl = new Bundle();
        bl.putString("key","Слово было введено");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtras(bl);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ON CREATE", "Create");

        settingEnter = this.getSharedPreferences("log", Context.MODE_PRIVATE);


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ON PAUSE", "Pause");
        editor = settingEnter.edit();
        editor.putString(NAME, inLogin.getText().toString());
        editor.apply();
        editor.putString(PASSWORD, inPas.getText().toString());
        editor.apply();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ON RESUME", "Resume");
        inLogin.setText(settingEnter.getString(NAME, ""));
        inPas.setText(settingEnter.getString(PASSWORD,""));

    }


    @Override
    protected void onDestroy(){
        editor = settingEnter.edit();
        editor.clear().apply();

        super.onDestroy();
        Log.i("ON DESTROY", "onDestroy");

    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ON StOP", "Stop");

    }
}
