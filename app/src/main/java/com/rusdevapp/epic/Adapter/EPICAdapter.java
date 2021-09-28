package com.rusdevapp.epic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.rusdevapp.epic.MainActivity;
import com.rusdevapp.epic.Model.ModelNASA;
import com.rusdevapp.epic.R;
import java.util.List;

public class EPICAdapter extends RecyclerView.Adapter<EPICAdapter.ViewHolder>{

    private List<ModelNASA> listOfEPIC;
    private Context context;

    public EPICAdapter(List<ModelNASA> listOfEPIC, Context context)
    {
        this.listOfEPIC = listOfEPIC;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                                        .inflate(R.layout.data, parent, false),
                                        context, listOfEPIC);
    }

    @Override
    public void onBindViewHolder(@NonNull EPICAdapter.ViewHolder holder, int position) {
        holder.Bind(listOfEPIC.get(position));
    }

    @Override
    public int getItemCount() {
        return listOfEPIC.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        private View itemView;
        private Context context;
        private List<ModelNASA> list;

        ViewHolder(View itemView, Context context, List<ModelNASA> list)
        {
            super(itemView);
            this.itemView = itemView;
            this.context = context;
            this.list = list;
        }

        void Bind(ModelNASA modelNASA)
        {
            ConstraintLayout constraintLayout = itemView.findViewById(R.id.clElement);
            TextView tvDate = itemView.findViewById(R.id.tvDate);
            tvDate.setText(modelNASA.getConvertDate());
            constraintLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.clElement:
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.putExtra("date", list.get(getAbsoluteAdapterPosition()).getDate());
                    intent.putExtra("name", list.get(getAbsoluteAdapterPosition()).getName());
                    context.startActivity(intent);
                    break;
                default:
                    break;
            }
        }
    }

}
