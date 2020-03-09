package com.example.expirationdateapp;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

class AppContainerViewModelFactory implements ViewModelProvider.Factory{
    private AppContainer appContainer;
    AppContainerViewModelFactory(AppContainer appContainer){
        this.appContainer = appContainer;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.equals(AddViewModel.class))
            return (T) new AddViewModel(appContainer.favoriteRepository, appContainer.basketItemRepository);
        else if (modelClass.equals(BasketViewModel.class))
            return (T) new BasketViewModel(appContainer.basketItemRepository);

        throw new IllegalArgumentException("There is factory does not support " + modelClass.getName());
    }
}