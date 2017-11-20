package cs349.uwaterloo.ca.mvp1;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.Observable;
import java.util.Observer;

/**
 * MVP1
 * <p>
 * Created by J. J. Hartmann on 11/19/2017.
 * Email: j3hartma@uwaterloo.ca
 * Copyright 2017
 */

public class SecondViewModel extends ViewModel implements Observer
{

    // Private Vars
    private MutableLiveData<String > mCounterString;
    private Model mModel;

    // Initialize persistent data
    public void init(Integer i){
        if (mCounterString == null){
            mCounterString = new MutableLiveData<String>();
        }

        if (mModel == null){
            mModel = Model.getInstance();
            mModel.addObserver(this);
        }

        mModel.initObservers();
    }

    // Get Counter Value
    public  MutableLiveData<String> getCounter() {
        return mCounterString;
    }

    // Increment Values
    public void incrementCounter(){
        mModel.incrementCounter();
    }


    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg)
    {
        // Build String based on mModel state
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < mModel.getCounter(); ++i)
        {
            s.append("x");
        }

        // Update textView
        mCounterString.setValue(s.toString());
    }
}
