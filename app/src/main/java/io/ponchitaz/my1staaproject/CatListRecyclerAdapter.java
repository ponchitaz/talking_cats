package io.ponchitaz.my1staaproject;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Polina on 14.05.2018.
 */

public class CatListRecyclerAdapter extends RecyclerView.Adapter<CatListRecyclerAdapter.CatListViewHolder> {
    @NonNull
    private final List<AllTheCats> allTheCats;

    @NonNull
    private final OnItemClickListener onItemClickListener;

    @NonNull
    private final View.OnClickListener internalClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AllTheCats cat = (AllTheCats) view.getTag();
            if (cat != null) {
                int position = allTheCats.indexOf(cat);
                onItemClickListener.onItemClick(cat, position);
            }
        }
    };



    public CatListRecyclerAdapter(@NonNull List<AllTheCats> allTheCats, @NonNull OnItemClickListener onItemClickListener) {
        this.allTheCats = allTheCats;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CatListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CatListViewHolder catListViewHolder = new CatListViewHolder(inflater.inflate(R.layout.cat_list_item, parent, false));
        return catListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CatListViewHolder holder, int position) {
        AllTheCats cat = allTheCats.get(position);
        holder.catFace.setOnClickListener(internalClickListener);
        holder.catFace.setTag(cat);
        Picasso.get().load(cat.getUrl()).into(holder.catFace);

    }

    @Override
    public int getItemCount() {
        int arr = 0;
        try {
            if (allTheCats.size() != 0) {
                arr = allTheCats.size();
            }
        } catch (Exception e) {
        }
        return arr;
    }
    interface OnItemClickListener {
        void onItemClick(@NonNull AllTheCats cat, int position);
    }

    static class CatListViewHolder extends RecyclerView.ViewHolder {
        @NonNull
        private final ImageView catFace;

        CatListViewHolder(View itemView) {
            super(itemView);
            catFace = (ImageView) itemView.findViewById(R.id.catFace);
        }
    }
}
