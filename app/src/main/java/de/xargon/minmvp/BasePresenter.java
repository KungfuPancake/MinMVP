package de.xargon.minmvp;

public interface BasePresenter<T> {
    void onAttachView(T view);

    void onDetachView();

    boolean isAttached();
}
