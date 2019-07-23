package com.mad.heradatingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mindorks.placeholderview.SwipePlaceHolderView;

public class SwipeCardTestActivity extends AppCompatActivity {
    private SwipePlaceHolderView mSwipeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_card_test);

        mSwipeView =(SwipePlaceHolderView)findViewById(R.id.swipeView);
    }
}
