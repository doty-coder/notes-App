package com.example.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

 class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {


    private final ArrayList<Note> notes;
    private final OnItemClickListener listener;

    public NoteAdapter(ArrayList<Note> notes,OnItemClickListener listener) {
        this.notes = notes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());

        View listItem= layoutInflater.inflate(R.layout.note_list,parent,false);

        ViewHolder viewHolder= new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Note Note =getnotes(position);
        if (Note!=null){

            holder.noteTitle.setText(notes.get(position).getTitle());
            holder.noteDesc.setText(notes.get(position).getDesc());
            holder.bind(Note);

        }


    }

    @Override
    public int getItemCount() {

        return notes.size();
    }
    private Note getnotes(int position){

        return notes.get(position);
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView noteTitle, noteDesc;
        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.noteTitle= itemView.findViewById(R.id.title);
            this.noteDesc= itemView.findViewById(R.id.desc);
            this.view= itemView;

        }

        public void bind(Note note){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public  void onClick(View v) {
                    listener.OnClick(note);
                }
            });

        }
    }
}
