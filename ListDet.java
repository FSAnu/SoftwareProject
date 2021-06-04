package com.example.zooapp.AnimalsDetails;

import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.zooapp.R;

/* compiled from: AnimalsAdapter */
class ListDet extends RecyclerView.ViewHolder {
    CardView CardofAnimals;
    ImageView cardsX;

    public ListDet(View itemView) {
        super(itemView);
        this.cardsX = (ImageView) itemView.findViewById(R.id.cardsA);
        this.CardofAnimals = (CardView) itemView.findViewById(R.id.CardofAnimals);
    }
}
