package edu.donnu.organaize.telephone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.donnu.organaize.R;
import edu.donnu.organaize.telephone.dao.Telephone;

public class TelephoneAdapter extends RecyclerView.Adapter<TelephoneViewHolder> {
    private List<Telephone> numbers;
    private Context context;
    private LayoutInflater layoutInflater;

    public TelephoneAdapter(List<Telephone> list, Context context){
        this.numbers = list;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public TelephoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View telephone_form = layoutInflater.inflate(R.layout.telephone_form,parent,false);
        return  new TelephoneViewHolder((telephone_form));
    }

    @Override
    public void onBindViewHolder(@NonNull TelephoneViewHolder holder, int position) {
    Telephone telephone = this.numbers.get(position);

    String b = Long.toString(telephone.getId());
    holder.hiddenId.setText(b);
    holder.contactIcon.setImageResource(R.drawable.telephone_icone);
    holder.telephoneName.setText(telephone.getName());
    holder.telephoneNumber.setText(telephone.getNumber());
    }

    @Override
    public int getItemCount() {
        return this.numbers.size();
    }



}
