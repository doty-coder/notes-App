
package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClickListener{

    RecyclerView recyclerView;
    NoteAdapter noteAdapter;
    ArrayList<Note> notes= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Note note1 = new Note("title one","Description one");
        Note note2 = new Note("title two","Description two");
        Note note3 = new Note("title three","Description three");
        Note note4 = new Note("title four","Description four");
        Note note5 = new Note("title five","Description five");
        Note note6 = new Note("title six","Description six");


        notes.add(note1);
        notes.add(note2);
        notes.add(note3);
        notes.add(note4);
        notes.add(note5);
        notes.add(note6);




        recyclerView = findViewById(R.id.recycler);
        noteAdapter = new NoteAdapter(notes,this);
        recyclerView.setAdapter(noteAdapter);
    }

    @Override
    public void OnClick(Note item) {

        Intent intent= new Intent(this,NotesDeatils.class);
        startActivity(intent);

    }
}