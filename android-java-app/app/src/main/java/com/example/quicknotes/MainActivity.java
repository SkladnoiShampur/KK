package com.example.quicknotes;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.quicknotes.databinding.ActivityMainBinding;

import java.util.ArrayList;

/**
 * Основной экран приложения заметок. Позволяет сохранять короткие идеи и задачи в списке.
 */
public class MainActivity extends AppCompatActivity {

    private static final String KEY_NOTES = "key_notes";

    private ActivityMainBinding binding;
    private NoteAdapter noteAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupRecyclerView();
        setupInputControls();

        if (savedInstanceState != null) {
            ArrayList<String> savedNotes = savedInstanceState.getStringArrayList(KEY_NOTES);
            if (savedNotes != null) {
                noteAdapter.setNotes(savedNotes);
            }
        }
    }

    private void setupRecyclerView() {
        noteAdapter = new NoteAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(noteAdapter);
    }

    private void setupInputControls() {
        binding.inputEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                saveNote();
                return true;
            }
            return false;
        });

        binding.addButton.setOnClickListener(v -> saveNote());
    }

    private void saveNote() {
        CharSequence text = binding.inputEditText.getText();
        String noteText = text != null ? text.toString().trim() : "";

        if (TextUtils.isEmpty(noteText)) {
            binding.inputLayout.setError(getString(R.string.error_empty_note));
            Toast.makeText(this, R.string.error_empty_note, Toast.LENGTH_SHORT).show();
            return;
        }

        binding.inputLayout.setError(null);
        noteAdapter.addNote(noteText);
        binding.recyclerView.smoothScrollToPosition(noteAdapter.getItemCount() - 1);
        binding.inputEditText.setText(null);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(KEY_NOTES, new ArrayList<>(noteAdapter.getNotes()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
