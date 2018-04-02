package de.westwing.androidtest.presenter.basepresenter;

public interface BasePresenter<V> {

    void attachView(V view);

    void detachView();

}
