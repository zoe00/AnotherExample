package com.example.zoe.test.ui.bla;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.zoe.test.R;
import com.example.zoe.test.ui.bla.model.BlaModel;

import org.parceler.Parcels;

import butterknife.ButterKnife;

public class AnotherActivity extends AppCompatActivity {

    private static final String EXTRA_MODEL = "extra_model";
    private BlaModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_layout);
        ButterKnife.bind(this);

        if(getIntent()!=null){
            initFromIntent(getIntent());
        }
        initView();
    }

    private void initFromIntent(final Intent intent){
        model = Parcels.unwrap(intent.getParcelableExtra(EXTRA_MODEL));
    }

    private void initView() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = AnFragmentBuilder.newAnFragment(model, "1we");
        transaction.replace(R.id.container_frame_layout, fragment);
        transaction.commit();
    }

    public static Intent createIntent(Context context, BlaModel blaModel){
        Intent intent = new Intent(context, AnotherActivity.class);
         intent.putExtra(EXTRA_MODEL, Parcels.wrap(blaModel));
        return intent;
    }
}

