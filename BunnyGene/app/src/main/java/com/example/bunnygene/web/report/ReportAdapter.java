package com.example.bunnygene.web.report;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.VectorDrawable;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bunnygene.R;
import com.example.bunnygene.contract.RecommendationDTO;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.RecViewHolder>{

    public ArrayList<RecommendationDTO> recommendations;



    public ReportAdapter(ArrayList<RecommendationDTO> recommendations)
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
        RecommendationDTO rec = recommendations.get(position);
        holder.bind(rec);

    }

    public class RecViewHolder extends RecyclerView.ViewHolder{

        TextView txtName;
        TextView txtDescription;
        ImageView img;
        TextView txtFequency;
        TextView txtLink;

        View itemView;

        public RecViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.rec_name);
            txtDescription = itemView.findViewById(R.id.rec_description);
            img = itemView.findViewById(R.id.rec_img);
            txtFequency  = itemView.findViewById(R.id.rec_freq);
            txtLink = itemView.findViewById(R.id.rec_link);
            this.itemView = itemView;
        }

        public void bind(RecommendationDTO recommendation){
            txtName.setText(recommendation.recommendation);
            txtDescription.setText(recommendation.description);
            txtFequency.setText(recommendation.frequency);

            txtLink.setClickable(true);
            txtLink.setMovementMethod(LinkMovementMethod.getInstance());
            String text = "<a href='";
            text+=recommendation.link;
            text+="'> More details on this Recommendation </a>";
            txtLink.setText(Html.fromHtml(text));



            int drawableId = itemView.getResources().getIdentifier(recommendation.icon, "drawable",
                    itemView.getContext().getPackageName());

            img.setImageResource(drawableId);

        }
    }
}
