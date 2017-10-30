package com.yaoyao.testall;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yaoyao.testall.activity.ForActivity;
import com.yaoyao.testall.activity.PedActivity;
import com.yaoyao.testall.zxing.ScanCodeActivity;
import com.yaoyao.testall.activity.YidongActivity;
import com.yaoyao.testall.app.AppManager;
import com.yaoyao.testall.base.BaseActivity;
import com.yaoyao.testall.chanel.ChanActivity;
import com.yaoyao.testall.chanel.ChanelActivity;
import com.yaoyao.testall.ion.IonActivity;
import com.yaoyao.testall.lrecy.EndlessLinearLayoutActivity;
import com.yaoyao.testall.mpandroid.BarChartActivity;
import com.yaoyao.testall.mpandroid.LinchartActivity;
import com.yaoyao.testall.mpandroid.PieChartActivity;
import com.yaoyao.testall.one0912.Data;
import com.yaoyao.testall.ucrop.UcropActivity;
import com.yaoyao.testall.vitamio.VitamioActivity;
import com.yaoyao.testall.zxing.ShengCodeActivity;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends BaseActivity {
    String tag = "msg";
    String TAG = "msg";

    @Override
    public void inidata() {

    }

    @Override
    public void setCon() {
        setContentView(R.layout.activity_main);
        getOnshow();
//        gettwoshow();
//        threeShow();
//        fourShow();
//        fiveShow();
//        sexShow();
//        sevenToast();



        findViewById(R.id.test1_bu)
                .setOnClickListener(new View.
                        OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Observable.just("I am new Hello world")
                                .subscribeOn(Schedulers.newThread())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<String>() {@Override
                                public void accept(String s) throws Exception {
                                    ((TextView) findViewById(R.id.hello_tv)).setText(s);
                                }
                                });
                    }
                });
        findViewById(R.id.test2_bu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManager.getAppManager().ToOtherActivity(ScanCodeActivity.class);
            }
        });

        findViewById(R.id.test3_bu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManager.getAppManager().ToOtherActivity(LinchartActivity.class);
            }
        });

        findViewById(R.id.test4_bu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManager.getAppManager().ToOtherActivity(BarChartActivity .class);
            }
        });

        findViewById(R.id.test5_bu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManager.getAppManager().ToOtherActivity(PieChartActivity.class);
            }
        });

        findViewById(R.id.test6_bu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManager.getAppManager().ToOtherActivity(ForActivity.class);
            }
        });
        findViewById(R.id.test7_bu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManager.getAppManager().ToOtherActivity(IonActivity.class);
            }
        });
        findViewById(R.id.test8_bu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManager.getAppManager().ToOtherActivity(UcropActivity.class);
            }
        });
        findViewById(R.id.test9_bu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManager.getAppManager().ToOtherActivity(VitamioActivity.class);
            }
        });
        findViewById(R.id.test10_bu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManager.getAppManager().ToOtherActivity(PedActivity.class);
            }
        });
        findViewById(R.id.test11_bu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManager.getAppManager().ToOtherActivity(EndlessLinearLayoutActivity.class);
            }
        });
        findViewById(R.id.test12_bu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManager.getAppManager().ToOtherActivity(ChanActivity.class);
            }
        });
        findViewById(R.id.test13_bu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManager.getAppManager().ToOtherActivity(ChanelActivity.class);
            }
        });
        findViewById(R.id.test14_bu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManager.getAppManager().ToOtherActivity(YidongActivity.class);
            }
        });
        findViewById(R.id.test2_1_bu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManager.getAppManager().ToOtherActivity(ShengCodeActivity.class);
            }
        });
    }

    @Override
    public void iniview() {

    }

    @Override
    public void setview() {

    }


    private void sevenToast() {
        Observable.just("one", "two", "three", "four", "five").subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        //text.setText(s);
//                        SystemClock.sleep(500);
                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void sexShow() {
        Data data = new Data(1, "+Java");
        Data data1 = new Data(2, "+Android");
        List<Data> list = new ArrayList<>();
        list.add(data);
        list.add(data1);
        Flowable.just(list).map(new Function<List<Data>, List<Data>>() {
            @Override
            public List<Data> apply(List<Data> datas) throws Exception {
                for (Data data : datas) {
                    if (data.getId() == 2) {
                        data.setName(data.getName() + "---DeMon");
                    }
                }
                return datas;
            }
        }).subscribe(new Consumer<List<Data>>() {
            @Override
            public void accept(List<Data> datas) throws Exception {
                for (Data data : datas) {
                    Log.e(TAG, "onNext: three:" + data.getId() + data.getName());
                }
            }
        });
    }

    private void fiveShow() {
        Flowable.just("Hello,I am China!")
                //替代1.x中的action1,接收一个参数，如果是两个参数action2使用BiCustomer，而且删除了action3-9
                //多个参数用Custom<Object[]>
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e("msg","consumer five"+s);
                    }
                });
    }

    private void fourShow() {
        Data data = new Data(1, "+Java");
        Data data1 = new Data(2, "+Android");
        List<Data> list = new ArrayList<>();
        list.add(data);
        list.add(data1);
        Flowable<List<Data>> flowable = Flowable.just(list);

        Consumer consunmer = new Consumer<List<Data>>() {

            @Override
            public void accept(List<Data> datas) throws Exception {
                for (Data data : datas) {
                    Log.e(TAG, "onNext: second:" + data.getId() + data.getName());
                }
            }
        };

        flowable.subscribe(consunmer);
    }

    private void threeShow() {
        Subscriber<Data> subscriber = new Subscriber<Data>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.e(TAG, "onSubscribe: ");
                s.request(1);
            }

            @Override
            public void onNext(Data data) {
                Log.e(TAG, "onNext: first:" + data.getId() + data.getName());
            }

            @Override
            public void onError(Throwable t) {
                Log.e(TAG, "onError: " + t.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete: ");
            }
        };

        Flowable.create(new FlowableOnSubscribe<Data>() {
            @Override
            public void subscribe(FlowableEmitter<Data> e) throws Exception {
                Data data = new Data(1, "+Java");
                Data data1 = new Data(2, "+Android");
                e.onNext(data);
                e.onNext(data1);
                e.onComplete();
            }
        }, BackpressureStrategy.BUFFER).subscribe(subscriber);
    }

    private void gettwoshow() {
            observable.subscribe(observer);
    }

    //创建观察者或者订阅者
    Observer<String> observer = new Observer<String>() {
        @Override
        public void onSubscribe(Disposable d) {
            //Disposable是1.x的Subscription改名的，因为Reactive-Streams规范用这个名称，为了避免重复
            //这个回调方法是在2.0之后新添加的
            //可以使用d.dispose()方法来取消订阅
            Log.e(TAG, "onSubscribe: "+d );
        }

        @Override
        public void onNext(String value) {
            Log.d("msg", "onNext"+value);
        }

        @Override
        public void onError(Throwable e) {
            Log.d("msg", "onError"+e.getMessage());
        }

        @Override
        public void onComplete() {
            Log.d("msg", "complete");
        }
    };

    //创建被观察者
    Observable observable = Observable.create(new ObservableOnSubscribe() {
        @Override
        public void subscribe(ObservableEmitter e) throws Exception {
            e.onNext("Hello World!,you can open a new box for me");
            e.onComplete();
        }
    });

    private void getOnshow() {
        Observable.just("one", "two", "three", "four", "five")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        Log.e(TAG, "onNext: "+s );
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
