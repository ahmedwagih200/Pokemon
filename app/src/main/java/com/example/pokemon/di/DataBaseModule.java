package com.example.pokemon.di;

import android.app.Application;
import androidx.room.Room;
import com.example.pokemon.db.Dao;
import com.example.pokemon.db.DataBase;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)

public class DataBaseModule {

    @Provides
    @Singleton
    public static DataBase provideDataBase (Application application){
        return Room.databaseBuilder(application,DataBase.class,"fav_table")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Singleton
    @Provides
    public static Dao provideDao(DataBase dataBase){
        return dataBase.dao();
    }
}
