package com.rusdevapp.epic.ViewHolder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.rusdevapp.epic.Model.ModelListOfPhoto;
import com.rusdevapp.epic.R;

public class ViewHolderListOfPhoto extends RecyclerView.ViewHolder {

    private View itemView;

    public ViewHolderListOfPhoto(View itemView)
    {
        super(itemView);
        this.itemView = itemView;
    }

    public void bind(ModelListOfPhoto modelListOfPhoto)
    {
        TextView tvImage = itemView.findViewById(R.id.tvImage);
        TextView tvDateAndTime = itemView.findViewById(R.id.tvDateAndTime);
        tvImage.setText(modelListOfPhoto.getImage());
        tvDateAndTime.setText(modelListOfPhoto.getTime());
    }
}
