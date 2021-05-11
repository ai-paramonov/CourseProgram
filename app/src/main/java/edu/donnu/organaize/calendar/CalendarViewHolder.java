package edu.donnu.organaize.calendar;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.donnu.organaize.R;

public class CalendarViewHolder extends RecyclerView.ViewHolder {
    TextView calenTitle;
    TextView calenData;
    TextView calenAdres;
    TextView hiddenId;
    public CalendarViewHolder(@NonNull View itemView) {
        super(itemView);
        this.hiddenId = (TextView) itemView.findViewById(R.id.clHiddenId);
        this.calenTitle = (TextView) itemView.findViewById(R.id.calendar_form_title);
        this.calenData = (TextView) itemView.findViewById(R.id.calendar_form_data);
        this.calenAdres = (TextView) itemView.findViewById(R.id.calendar_form_adres);

    }
}

