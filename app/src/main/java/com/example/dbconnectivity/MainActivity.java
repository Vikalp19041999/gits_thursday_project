package com.example.dbconnectivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText sid;
    private EditText name;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sid = (EditText) findViewById(R.id.sid);
        name = (EditText) findViewById(R.id.name);
        result = (TextView) findViewById(R.id.result);
    }
    public void addStudent(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this,null,null,1);
        Student student = new Student(Integer.parseInt(sid.getText().toString()),name.getText().toString());
        dbHandler.addHandler(student);
        sid.setText("");
        name.setText("");
    }

    public void searchStudent(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this,null,null,1);
        Student student = dbHandler.searchHandler(Integer.parseInt(sid.getText().toString()));
        if(student!=null) {
            result.setText(student.getId()+ " "+student.getName());
        }
    }
}

