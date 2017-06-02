package com.example.dthompson.daggertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import  dagger.android.AndroidInjection;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static java.security.AccessController.getContext;


public class MainActivity extends AppCompatActivity {

    @Inject
    NetworkApi networkApi;
    @BindView(R.id.textViewId)
    TextView userAvailable;
    @BindView(R.id.testButton)
     Button button;

    int observableInt = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        boolean injected = networkApi == null ? false : true;
        userAvailable.setText("Dependency injection worked: " + String.valueOf(injected) + "\n\n");

       // final Observable<String> ob;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable<String> ob = Observable.just("Observer called: ");
                observableInt++;
                Observer<String> myOb = new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        userAvailable.append(" " + Integer.toString(observableInt) + " times");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        userAvailable.setText(s);
                    }
                };
                Subscription mySub = ob.subscribe(myOb);

            }
        });


    }









}
