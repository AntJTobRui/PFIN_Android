package com.example.pfin_android.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private static int idSel = 0;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public static void setIdSel(int i){
        idSel = i;
    }

    public static int getIdSel(){
        return idSel;
    }

    public LiveData<String> getText() {
        return mText;
    }
}