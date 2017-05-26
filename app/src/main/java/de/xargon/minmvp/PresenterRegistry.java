package de.xargon.minmvp;

import java.util.Hashtable;
import java.util.Map;

/**
 * Manager class for activities to hold presenters for all child views
 * <p>
 * TODO: Introduce some sort of tagging to allow multiple instances of a view
 */
public class PresenterRegistry {
    private Map<Class<? extends BasePresenter>, BasePresenter> presenters = new Hashtable<>();

    public <T extends BasePresenter> T getPresenter(Class<T> presenterClass) {
        try {
            BasePresenter basePresenter = this.presenters.get(presenterClass);
            if (basePresenter != null) {
                return presenterClass.cast(basePresenter);
            } else {
                T presenter = presenterClass.newInstance();
                this.presenters.put(presenterClass, presenter);

                return presenter;
            }
        } catch (Exception ignored) {
            return null;
        }
    }
}
