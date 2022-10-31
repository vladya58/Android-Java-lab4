package com.example.lab3;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class list extends Activity {
    ArrayList <String> data = new ArrayList<String>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        Button b_add = findViewById(R.id.button2);
        Button b_del = findViewById(R.id.button3);
        ListView list = findViewById(R.id.list1);
        EditText input = findViewById(R.id.edtxt);
        Button quite = findViewById(R.id.button4);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);

        list.setAdapter(adapter);
        Intent intent = new Intent(this, MainActivity.class);
        Bundle recbl = this.getIntent().getExtras();
        String str = recbl.get("key").toString();



        quite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);


            }
        });


        b_add.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         String word = input.getText().toString();
                                         if (!word.isEmpty() )
                                         {
                                             if (data.contains(word)){
                                                 Toast toast = Toast.makeText(getApplicationContext(),
                                                         str, Toast.LENGTH_SHORT);
                                                 toast.setGravity(Gravity.TOP, 0,160);   // import android.view.Gravity;
                                                 toast.show();
                                             }
                                             else {
                                                 data.add(word);
                                                 input.setText("");
                                                 adapter.notifyDataSetChanged();
                                             }
                                         }
                                     }

                                 }
        );
        b_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.size() > 0) {
                    data.remove(data.size()-1);
                    adapter.notifyDataSetChanged();
                }

            }
        });


    }
}
