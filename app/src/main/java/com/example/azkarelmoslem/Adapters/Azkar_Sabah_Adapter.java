package com.example.azkarelmoslem.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.azkarelmoslem.R;
import com.example.azkarelmoslem.models.Azkar_Content;

import java.util.ArrayList;

public class Azkar_Sabah_Adapter extends RecyclerView.Adapter<Azkar_Sabah_Adapter.MyViewHolder>
{
    Context mContext;
    private int layout;
    private ArrayList<Azkar_Content> azkar_contents = new ArrayList<>();

    public Azkar_Sabah_Adapter(Context mContext, int layout, ArrayList<Azkar_Content> azkar_contents)
    {
        this.mContext = mContext;
        this.layout = layout;
        this.azkar_contents = azkar_contents;
    }

    @NonNull
    @Override
    public Azkar_Sabah_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout , parent , false);

        Azkar_Sabah_Adapter.MyViewHolder holder = new Azkar_Sabah_Adapter.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
     final Azkar_Content azkar_content = azkar_contents.get(position);

     holder.zekr_content.setText(azkar_content.getZekr());
     holder.zekr_counter.setText(azkar_content.getRepeat()+"");
     holder.zekr_result.setText(azkar_content.getBless());

    }

    @Override
    public int getItemCount()
    {
        return azkar_contents.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView zekr_content , zekr_counter , zekr_result;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            zekr_content = itemView.findViewById(R.id.zekr_content_view);
            zekr_counter = itemView.findViewById(R.id.zeker_counter_view);
            zekr_result = itemView.findViewById(R.id.zekr_result_view);

        }
    }
}
