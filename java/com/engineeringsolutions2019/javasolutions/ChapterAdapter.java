package com.engineeringsolutions2019.javasolutions;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.MyViewHolder> {

    private Context mContext;
    private List<Chapter> chapterList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        CardView card;
        TextView textView1, textView2;

        MyViewHolder(View view) {
            super(view);
            thumbnail = view.findViewById(R.id.thumbnail);
            card = view.findViewById(R.id.card_view);
            textView1=view.findViewById(R.id.textView1);
            textView2=view.findViewById(R.id.textView2);
        }
    }


    ChapterAdapter(Context mContext, List<Chapter> chapterList) {
        this.mContext = mContext;
        this.chapterList = chapterList;
    }

    @Override
    public ChapterAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subject_card, parent, false);

        return new ChapterAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ChapterAdapter.MyViewHolder holder, final int position) {
        Chapter chapter = chapterList.get(position);
        holder.textView1.setText(chapter.getChapterNumber());
        holder.textView2.setText(chapter.getName());
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextPage(position);
            }
        });
        holder.card.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                nextPage(position);

            }
        });
        holder.textView1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                nextPage(position);

            }
        });
        holder.textView2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                nextPage(position);

            }
        });



    }

    private void nextPage(int p){
        Intent i;
        switch (p){
            case 0: i = new Intent(mContext, WebPageActivity.class);
                    i.putExtra("name", 0);
                    mContext.startActivity(i);
                    break;
            case 1: i = new Intent(mContext, WebPageActivity.class);
                i.putExtra("name", 1);
                mContext.startActivity(i);
                break;
            case 2: i = new Intent(mContext, WebPageActivity.class);
                i.putExtra("name", 2);
                mContext.startActivity(i);
                break;
            case 3: i = new Intent(mContext, WebPageActivity.class);
                i.putExtra("name", 3);
                mContext.startActivity(i);
                break;
            case 4: i = new Intent(mContext, WebPageActivity.class);
                i.putExtra("name", 4);
                mContext.startActivity(i);
                break;
            case 5: i = new Intent(mContext, WebPageActivity.class);
                i.putExtra("name", 5);
                mContext.startActivity(i);
                break;
            case 6: i = new Intent(mContext, WebPageActivity.class);
                i.putExtra("name", 6);
                mContext.startActivity(i);
                break;
            case 7: i = new Intent(mContext, WebPageActivity.class);
                i.putExtra("name", 7);
                mContext.startActivity(i);
                break;
            case 8: i = new Intent(mContext, WebPageActivity.class);
                i.putExtra("name", 8);
                mContext.startActivity(i);
                break;
        }

    }



    @Override
    public int getItemCount() {
        return chapterList.size();
    }
}
