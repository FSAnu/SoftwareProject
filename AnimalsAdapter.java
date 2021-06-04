package com.example.zooapp.AnimalsDetails;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.example.zooapp.R;
import java.util.List;

public class AnimalsAdapter extends RecyclerView.Adapter<ListDet> {
    private Context Acont;
    private List<AnimalsData> Adata;

    public AnimalsAdapter(Context acont, List<AnimalsData> adata) {
        this.Acont = acont;
        this.Adata = adata;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ListDet onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListDet(LayoutInflater.from(parent.getContext()).inflate(R.layout.animals_card, parent, false));
    }

    public void onBindViewHolder(final ListDet holder, int position) {
        holder.cardsX.setImageResource(this.Adata.get(position).getImageA());
        holder.CardofAnimals.setOnClickListener(new View.OnClickListener() {
            /* class com.example.zooapp.AnimalsDetails.AnimalsAdapter.AnonymousClass1 */

            public void onClick(View view) {
                Intent i = new Intent(AnimalsAdapter.this.Acont, DescAnimals.class);
                i.putExtra("imageA", ((AnimalsData) AnimalsAdapter.this.Adata.get(holder.getAdapterPosition())).getImageA());
                i.putExtra("namesA", ((AnimalsData) AnimalsAdapter.this.Adata.get(holder.getAdapterPosition())).getNamesA());
                i.putExtra("specA", ((AnimalsData) AnimalsAdapter.this.Adata.get(holder.getAdapterPosition())).getSpecA());
                i.putExtra("spanA", ((AnimalsData) AnimalsAdapter.this.Adata.get(holder.getAdapterPosition())).getSpanA());
                i.putExtra("descA", ((AnimalsData) AnimalsAdapter.this.Adata.get(holder.getAdapterPosition())).getDescA());
                AnimalsAdapter.this.Acont.startActivity(i);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.Adata.size();
    }
}
