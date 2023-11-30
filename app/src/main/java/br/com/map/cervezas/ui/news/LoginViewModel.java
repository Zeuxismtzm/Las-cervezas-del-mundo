package br.com.map.cervezas.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<String> username = new MutableLiveData<>();

    public LiveData<String> getUsername() {
        return username;
    }

    public void setUsername(String name) {
        username.setValue(name);
    }
}
