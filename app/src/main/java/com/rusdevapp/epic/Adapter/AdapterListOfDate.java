package com.rusdevapp.epic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.rusdevapp.epic.ListOfPhotoActivity;
import com.rusdevapp.epic.Model.ModelListOfDate;
import com.rusdevapp.epic.R;
import com.rusdevapp.epic.ViewHolder.ViewHolderListOfDate;
import java.util.ArrayList;

public class AdapterListOfDate extends RecyclerView.Adapter<ViewHolderListOfDate>
{

    private ArrayList<ModelListOfDate> arrayList;
    private Context context;

    public AdapterListOfDate(ArrayList<ModelListOfDate> arrayList, Context context)
    {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public ViewHolderListOfDate onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                                      .inflate(R.layout.item_date, parent, false);
        ViewHolderListOfDate viewHolder = new ViewHolderListOfDate(itemView);
        //---
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAbsoluteAdapterPosition();
                Intent intent = new Intent(context, ListOfPhotoActivity.class);
                intent.putExtra("date", arrayList.get(position).getDate());
                context.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderListOfDate holder, int position) {
        holder.bind(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
