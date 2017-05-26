package de.xargon.minmvp;

import android.support.v4.app.Fragment;

@SuppressWarnings("unused")
public abstract class MvpFragment extends Fragment {

    protected <T extends BasePresenter> T getPresenter(Class<T> presenterClass) {
        MvpActivity baseActivity = (MvpActivity) this.getActivity();

        return baseActivity.getPresenterRegistry().getPresenter(presenterClass);
    }
}
