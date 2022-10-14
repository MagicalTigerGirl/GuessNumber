package com.example.guessnumber.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class InformationFinal implements Serializable, Parcelable {
    private String usuario;
    private Integer intentos;
    private Integer acertado;

    public InformationFinal(String usuario, int intentos, Integer acertado) {
        this.usuario = usuario;
        this.intentos = intentos;
        this.acertado = acertado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getIntentos() {
        return intentos;
    }

    public void setIntentos(Integer intentos) {
        this.intentos = intentos;
    }

    public Integer getAcertado() {
        return acertado;
    }

    public void setAcertado(Integer acertado) {
        this.acertado = acertado;
    }

    // Métodos para el Parcelable

    protected InformationFinal(Parcel in){
        usuario=in.readString();
        intentos= Integer.valueOf(in.readString());
        acertado= Integer.valueOf(in.readString());
    }

    public static final Creator<InformationFinal> CREATOR = new Creator<InformationFinal>() {
        @Override
        public InformationFinal createFromParcel(Parcel in) {
            return new InformationFinal(in);
        }

        @Override
        public InformationFinal[] newArray(int size) {
            return new InformationFinal[size];
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
        dest.writeString(String.valueOf(intentos));
        dest.writeString(String.valueOf(acertado));
    }

}
