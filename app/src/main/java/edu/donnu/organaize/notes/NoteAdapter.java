package edu.donnu.organaize.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.donnu.organaize.R;
import edu.donnu.organaize.notes.dao.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    private List<Note> notes;
    private Context context;
    private LayoutInflater layoutInflater;

    public NoteAdapter(List<Note> list, Context context) {
        this.notes = list;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View note_form = layoutInflater.inflate(R.layout.notes_form, parent, false);
        return new NoteViewHolder((note_form));
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = this.notes.get(position);

        String b = Long.toString(note.getId());
        holder.hiddenId.setText(b);
        holder.noteTitle.setText(note.getTitle());
        holder.noteText.setText(note.getText());
    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }
}


