package com.example.quicknotes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Простой адаптер для отображения заметок в RecyclerView.
 */
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private final List<String> notes = new ArrayList<>();

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.bind(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void addNote(@NonNull String note) {
        notes.add(note);
        notifyItemInserted(notes.size() - 1);
    }

    public void setNotes(@NonNull List<String> initialNotes) {
        notes.clear();
        notes.addAll(initialNotes);
        notifyDataSetChanged();
    }

    @NonNull
    public List<String> getNotes() {
        return new ArrayList<>(notes);
    }

    static class NoteViewHolder extends RecyclerView.ViewHolder {

        private final TextView noteText;

        NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            noteText = itemView.findViewById(R.id.noteText);
        }

        void bind(String note) {
            noteText.setText(note);
        }
    }
}
