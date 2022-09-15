package com.example.bunnygene.web.report;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bunnygene.R;
import com.example.bunnygene.contract.Recommendation;

import java.util.ArrayList;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.RecViewHolder>{

    public ArrayList<Recommendation> recommendations;



    public ReportAdapter(ArrayList<Recommendation> recommendations)
    {
        this.recommendations = recommendations;
    }

    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.report_item,parent,false);

        return new RecViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return recommendations.size();
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder holder, int position) {
        Recommendation rec = recommendations.get(position);
        holder.bind(rec);

    }

    public class RecViewHolder extends RecyclerView.ViewHolder{

        TextView txtName;
        TextView txtDescription;
        public RecViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.rec_name);
            txtDescription = itemView.findViewById(R.id.rec_description);
        }

        public void bind(Recommendation recommendation){
            txtName.setText(recommendation.title);
            txtDescription.setText(recommendation.description);
        }
    }
}
