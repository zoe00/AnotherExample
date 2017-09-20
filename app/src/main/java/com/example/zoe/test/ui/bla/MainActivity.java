package com.example.zoe.test.ui.bla;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.zoe.test.R;
import com.example.zoe.test.ui.bla.model.BlaModel;
import com.example.zoe.test.ui.bla.presenter.BlaPresenter;
import com.example.zoe.test.ui.bla.view.BlaView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements BlaView {

    @BindView(R.id.fab)
    FloatingActionButton fabButton;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.my_recycler_view)
    RecyclerView recyclerView;

    BlaPresenter blaPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);

        blaPresenter = new BlaPresenter();
        blaPresenter.attachView(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnClick(R.id.fab)
    public void onFabClick() {
        startActivity(AnotherActivity.createIntent(this, new BlaModel()));
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        blaPresenter.detachView();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(getWindow().getDecorView().getRootView(),
                message,
                Snackbar.LENGTH_SHORT)
                .show();
    }

    @Override
    public void showCards(String[] cards) {
        recyclerView.setAdapter(new CardsAdapter(cards));
    }
}
