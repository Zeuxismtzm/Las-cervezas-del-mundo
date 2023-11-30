package br.com.map.cervezas.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DetailsViewModel extends ViewModel {
    private MutableLiveData<String> username2 = new MutableLiveData<>();

    public LiveData<String> getUsername() {
        return username2;
    }

    public void setUsername(String name) {
        username2.setValue(name);
    }
}
