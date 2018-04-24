package com.tps.challenge.DataLayer.Local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.tps.challenge.DataLayer.DataModels.db.UsersDBTable;
import com.tps.challenge.DataLayer.Local.db.DaoInterfaces.UsersDAO;


@Database(entities = {UsersDBTable.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UsersDAO usersDao();

}
