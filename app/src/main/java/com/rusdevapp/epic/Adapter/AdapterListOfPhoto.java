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
import java.util.ArrayList;

public class AdapterListOfPhoto extends RecyclerView.Adapter<ViewHolderListOfPhoto>
{

    private ArrayList<ModelListOfPhoto> arrayList;
    private Context context;

    public AdapterListOfPhoto(ArrayList<ModelListOfPhoto> arrayList, Context context) {
        this.arrayList = arrayList;
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
                intent.putExtra("image", arrayList.get(position).getImage());
                intent.putExtra("date", arrayList.get(position).getUrlDate());
                context.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolderListOfPhoto holder, int position) {
        holder.bind(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
