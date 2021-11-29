package com.example.necapp.rvadapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.necapp.R;
import com.example.necapp.models.Items;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WarningsAdapter extends RecyclerView.Adapter<WarningsAdapter.MyViewHolder>{
    private List<Items> itemsList;

    public WarningsAdapter(List<Items> mItemList){
        this.itemsList = mItemList;
    }

    @Override
    public WarningsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WarningsAdapter.MyViewHolder holder, final int position) {
        final Items item = itemsList.get(position);
        holder.name.setText(item.getName());
        Context context = holder.imageView.getContext();
        Picasso.get()
                .load(item.getImg())
                .centerCrop()
                .fit()
                .into(holder.imageView);
        holder.badge.setCardBackgroundColor(Color.parseColor(item.getBadgeColor()));

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.section.setText(item.getSection());
        //holder.imageView.setImageResource(item.getImg());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public CardView container;
        public CardView badge;
        public TextView name;
        public TextView section;
        public ImageView imageView;
        private RelativeLayout itemLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
            name = itemView.findViewById(R.id.tvName);
            imageView = itemView.findViewById(R.id.icon);
            badge = itemView.findViewById(R.id.badge);
            section = itemView.findViewById(R.id.section);
            itemLayout =  itemView.findViewById(R.id.itemLayout);

        }
    }

    // Customs methods
    /*
    public void updateData(List<Items> dataSet, int flag)
    {
        if(flag == 0)
        {
                for(int i = 0; i < dataSet.size(); i++)
                {
                    System.out.println(dataSet.get(i).getName());
                    this.itemsList.add(dataSet.get(i));
                }
                Items item = new Items("Señalan en comparecencia aviadores y simulaciones");
                this.itemsList.add(item);
                notifyItemInserted(getItemCount());
        }

        else
        {
            itemsList.clear();
            notifyDataSetChanged();
        }
    }
    */
}
