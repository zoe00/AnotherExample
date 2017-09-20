package com.example.zoe.test.ui.bla;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zoe.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;

class CardViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.info_text)
    TextView textView;

    private CardViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    static CardViewHolder create(final ViewGroup viewGroup){
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new CardViewHolder(layout);
    }

    void bind(String card) {
        textView.setText(card);
    }
}
