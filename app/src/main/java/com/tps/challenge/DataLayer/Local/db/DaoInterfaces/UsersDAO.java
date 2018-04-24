package com.tps.challenge.DataLayer.Local.db.DaoInterfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.tps.challenge.DataLayer.DataModels.db.UsersDBTable;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;


@Dao
public interface UsersDAO {

    @Query("SELECT * FROM UsersDBTable")
    List<UsersDBTable> getAllUsers();

    @Query("SELECT * FROM UsersDBTable WHERE email = :userEmail")
    UsersDBTable searchAllUsers(String userEmail);

    @Insert(onConflict = REPLACE)
    void insertAll(UsersDBTable user);

    @Delete
    void delete(UsersDBTable user);

    @Query("DELETE FROM UsersDBTable")
    void deleteAll();

    @Query("UPDATE UsersDBTable SET mobileNo = :newMobileNo WHERE email =:email")
    void update(String email, String newMobileNo);


}
