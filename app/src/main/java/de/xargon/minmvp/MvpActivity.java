package de.xargon.minmvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class MvpActivity extends AppCompatActivity {
    private PresenterRegistry presenterRegistry;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.presenterRegistry = (PresenterRegistry) this.getLastCustomNonConfigurationInstance();
        if (this.presenterRegistry == null) {
            this.presenterRegistry = new PresenterRegistry();
        }
    }

    public PresenterRegistry getPresenterRegistry() {
        return presenterRegistry;
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return this.presenterRegistry;
    }
}
