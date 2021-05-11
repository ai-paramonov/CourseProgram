package edu.donnu.organaize.telephone;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.donnu.organaize.R;

public class TelephoneViewHolder extends RecyclerView.ViewHolder {

    ImageView contactIcon;
    TextView telephoneName;
    TextView telephoneNumber;
    TextView hiddenId;
    public TelephoneViewHolder(@NonNull View itemView) {
        super(itemView);
        this.hiddenId = (TextView) itemView.findViewById(R.id.tpHiddenId);
        this.contactIcon = (ImageView) itemView.findViewById(R.id.contactIcon);
        this.telephoneName = (TextView) itemView.findViewById(R.id.telephoneName);
        this.telephoneNumber = (TextView) itemView.findViewById(R.id.telephoneNumber);

    }
}
