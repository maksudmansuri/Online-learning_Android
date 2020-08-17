package com.example.oc3.session;
import androidx.room.Dao
import android.content.Context;
import android.content.SharedPreferences;

//import javax.inject.Inject
public class SessionManager {

        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;

        public SessionManager(Context context){
            sharedPreferences = context.getSharedPreferences("token",0)
            editor =sharedPreferences.edit();
            editor.apply();
        }

        public void setLogin(boolean login){
            editor.putBoolean("token",login);
            editor.commit();
        }

        public Boolean getLogin(){
            return sharedPreferences.getBoolean("key_login",false);
        }

        public void setUsername(String username){
            editor.putString("token",username);
            editor.commit();
        }
        public String getusername(){
            return sharedPreferences.getString("token","");
        }

}


