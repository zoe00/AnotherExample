package com.example.zoe.test.ui.bla.presenter;

import com.example.zoe.test.entity.data.UserRequestParams;
import com.example.zoe.test.entity.data.UserResponse;
import com.example.zoe.test.rest.UserApi;
import com.example.zoe.test.ui.bla.model.BlaModel;
import com.example.zoe.test.ui.bla.view.BlaView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class BlaPresenter {

    private BlaView view;

    public void attachView(final BlaView view) {
        this.view = view;
        initView();
        initRequest();
    }

    private void initRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://staging.taxfix.de/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
        UserApi api = retrofit.create(UserApi.class);

        UserRequestParams params = new UserRequestParams("zoe@taxfix.de", "1234");
        api.login(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableSingleObserver<UserResponse>() {
                    @Override
                    public void onSuccess(@NonNull UserResponse userResponse) {
                        view.showMessage(userResponse.accessToken);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                    }
                });
    }

    private void initView() {
        view.showMessage("View attached to presenter");
        view.showCards(getCards());
    }

    private String[] getCards() {
        BlaModel blaModel = new BlaModel();
        HashMap<String, String> map = new HashMap<>();
        map.put("en", "Hello");
        map.put("de", "Hallo");
        map.put("es", "Hola");
        map.put("pl", "Chin Dobray");
        map.put("dk", "Tak");
        Iterator iterator = map.entrySet().iterator();
        blaModel.cards = new String[map.size()];
        int i = 0;
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            blaModel.cards[i] = (String) pair.getValue();
            i++;
        }
        return blaModel.cards;
    }

    public void detachView() {
        this.view = null;
    }

}
