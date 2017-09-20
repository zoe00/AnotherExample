package com.example.zoe.test.ui.bla;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

class CardsAdapter extends RecyclerView.Adapter<CardViewHolder>{

    private final String[] cards;

    CardsAdapter(String[] cards){
        this.cards = cards;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CardViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.bind(cards[position]);
    }

    @Override
    public int getItemCount() {
        return cards.length;
    }
}
