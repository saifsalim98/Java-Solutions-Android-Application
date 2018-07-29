package com.engineeringsolutions2019.javasolutions;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ChapterAdapter adapter;
    List<Chapter> chapterList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        chapterList = new ArrayList<>();

        adapter = new ChapterAdapter(this, chapterList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(8), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareChapters();
        try {
            Glide.with(this).load(R.drawable.covfinalmin).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void prepareChapters() {
        Chapter a;
        a = new Chapter("Introduction\nto OOP", "Chapter 1");
        chapterList.add(a);

        a = new Chapter("Java\nFundamentals", "Chapter 2");
        chapterList.add(a);

        a = new Chapter("Classes and\nObjects", "Chapter 3");
        chapterList.add(a);

        a = new Chapter("Inheritance and\nPolymorphism", "Chapter 4");
        chapterList.add(a);

        a = new Chapter("Packages", "Chapter 5");
        chapterList.add(a);

        a = new Chapter( "String\nHandling", "Chapter 6");
        chapterList.add(a);

        a = new Chapter("Exception\nHandling", "Chapter 7");
        chapterList.add(a);

        a = new Chapter("Multithreading", "Chapter 8");
        chapterList.add(a);

        a = new Chapter("Applets", "Chapter 9");
        chapterList.add(a);

        adapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            int column = position % spanCount;

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount;
                outRect.right = (column + 1) * spacing / spanCount;

                if (position < spanCount) {
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            } else {
                outRect.left = column * spacing / spanCount;
                outRect.right = spacing - (column + 1) * spacing / spanCount;
                if (position >= spanCount) {
                    outRect.top = spacing;
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
