package edu.donnu.organaize.notes;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.donnu.organaize.R;

public class NoteViewHolder extends RecyclerView.ViewHolder {

        TextView noteTitle;
        TextView noteText;
        TextView hiddenId;
    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        this.hiddenId = (TextView) itemView.findViewById(R.id.ntHiddenId);
        this.noteTitle = (TextView) itemView.findViewById(R.id.notes_title);
        this.noteText = (TextView) itemView.findViewById(R.id.notes_text);

        }
}
