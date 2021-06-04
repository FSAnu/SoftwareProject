package com.example.zooapp.AnimalsDetails;

import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.zooapp.R;

/* compiled from: AnimalsAdapter2 */
class ListDet2 extends RecyclerView.ViewHolder {
    CardView CardofAnimals2;
    ImageView cardsX2;

    public ListDet2(View itemView) {
        super(itemView);
        this.cardsX2 = (ImageView) itemView.findViewById(R.id.cardsB);
        this.CardofAnimals2 = (CardView) itemView.findViewById(R.id.CardofAnimals2);
    }
}
