package com.rusdevapp.epic.ViewHolder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.rusdevapp.epic.Model.ModelListOfDate;
import com.rusdevapp.epic.R;


public class ViewHolderListOfDate extends RecyclerView.ViewHolder{

    private View itemView;

    public ViewHolderListOfDate(View itemView)
    {
        super(itemView);
        this.itemView = itemView;
    }

    public void bind(ModelListOfDate modelListOfDate)
    {
        TextView tvDate = itemView.findViewById(R.id.tvDate);
        tvDate.setText(modelListOfDate.getConvertDate());
    }
}
