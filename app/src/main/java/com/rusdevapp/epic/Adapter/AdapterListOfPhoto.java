package com.rusdevapp.epic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import com.rusdevapp.epic.Model.ModelListOfPhoto;
import com.rusdevapp.epic.PhotoActivity;
import com.rusdevapp.epic.R;
import com.rusdevapp.epic.ViewHolder.ViewHolderListOfPhoto;

import java.util.List;

public class AdapterListOfPhoto extends RecyclerView.Adapter<ViewHolderListOfPhoto>
{

    private List<ModelListOfPhoto> list;
    private Context context;

    public AdapterListOfPhoto(List<ModelListOfPhoto> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolderListOfPhoto onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                                      .inflate(R.layout.item_photo, parent, false);
        ViewHolderListOfPhoto viewHolder = new ViewHolderListOfPhoto(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAbsoluteAdapterPosition();
                Intent intent = new Intent(context, PhotoActivity.class);
                intent.putExtra("image", list.get(position).getImage());
                intent.putExtra("date", list.get(position).getUrlDate());
                context.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolderListOfPhoto holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
