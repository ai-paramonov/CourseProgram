package edu.donnu.organaize.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.donnu.organaize.R;
import edu.donnu.organaize.calendar.dao.Calendar;
public class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder> {
    private List<Calendar> calendars;
    private Context context;
    private LayoutInflater layoutInflater;


    public CalendarAdapter(List<Calendar> list, Context context) {
        this.calendars = list;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View note_form = layoutInflater.inflate(R.layout.calendar_form, parent, false);
        return new CalendarViewHolder((note_form));
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        Calendar calendar = this.calendars.get(position);

        String b = Long.toString(calendar.getId());
        holder.hiddenId.setText(b);
        holder.calenTitle.setText(calendar.getTitle());
        holder.calenData.setText(calendar.getData());
        holder.calenAdres.setText(calendar.getAdres());
    }

    @Override
    public int getItemCount() {
        return this.calendars.size();
    }
}

