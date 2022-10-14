package com.example.guessnumber.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Information implements Serializable, Parcelable {
    private String usuario;
    private String intentos;

    public Information(String usuario, String intentos){
        this.usuario = usuario;
        this.intentos = intentos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getIntentos() {
        return intentos;
    }

    public void setIntentos(String intentos) {
        this.intentos = intentos;
    }

    // Métodos para el Parcelable

    protected Information(Parcel in){
        usuario =in.readString();
        intentos=in.readString();
    }

    public static final Creator<Information> CREATOR = new Creator<Information>() {
        @Override
        public Information createFromParcel(Parcel in) {
            return new Information(in);
        }

        @Override
        public Information[] newArray(int size) {
            return new Information[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @NonNull
    @Override
    public String toString() {
        return getUsuario() + "->" + getIntentos() ;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(usuario);
        dest.writeString(intentos);
    }
}
