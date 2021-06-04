package com.example.zooapp.AnimalsDetails;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.example.zooapp.R;
import java.util.List;

public class AnimalsAdapter2 extends RecyclerView.Adapter<ListDet2> {
    private Context Acont2;
    private List<AnimalsData2> Adata2;

    public AnimalsAdapter2(Context acont2, List<AnimalsData2> adata2) {
        this.Acont2 = acont2;
        this.Adata2 = adata2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ListDet2 onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListDet2(LayoutInflater.from(parent.getContext()).inflate(R.layout.animals_card2, parent, false));
    }

    public void onBindViewHolder(final ListDet2 holder, int position) {
        holder.cardsX2.setImageResource(this.Adata2.get(position).getImageA2());
        holder.CardofAnimals2.setOnClickListener(new View.OnClickListener() {
            /* class com.example.zooapp.AnimalsDetails.AnimalsAdapter2.AnonymousClass1 */

            public void onClick(View view) {
                Intent i = new Intent(AnimalsAdapter2.this.Acont2, DescAnimals.class);
                i.putExtra("imageA", ((AnimalsData2) AnimalsAdapter2.this.Adata2.get(holder.getAdapterPosition())).getImageA2());
                i.putExtra("namesA", ((AnimalsData2) AnimalsAdapter2.this.Adata2.get(holder.getAdapterPosition())).getNamesA2());
                i.putExtra("specA", ((AnimalsData2) AnimalsAdapter2.this.Adata2.get(holder.getAdapterPosition())).getSpecA2());
                i.putExtra("spanA", ((AnimalsData2) AnimalsAdapter2.this.Adata2.get(holder.getAdapterPosition())).getSpanA2());
                i.putExtra("descA", ((AnimalsData2) AnimalsAdapter2.this.Adata2.get(holder.getAdapterPosition())).getDescA2());
                AnimalsAdapter2.this.Acont2.startActivity(i);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.Adata2.size();
    }
}
