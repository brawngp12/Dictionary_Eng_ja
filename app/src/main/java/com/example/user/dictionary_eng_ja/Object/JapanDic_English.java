package com.example.user.dictionary_eng_ja.Object;

import java.io.Serializable;

/**
 * Created by Tung Lam on 30-Oct-16.
 */

public class JapanDic_English implements Serializable {
    private String ID_ENG; //// stt
    private String ENG_WORD;    /// tu`
    private String ENG_MEAN;    /// y nghia --- nghia tieng nhat
    private String ENG_NOTE;    /// chu y
    private String ENG_PHIENAM;
    private int  SAVE;

    public JapanDic_English(String ID_ENG, String ENG_MEAN, String ENG_WORD, int SAVE, String ENG_NOTE , String ENG_PHIENAM) {
        this.ID_ENG = ID_ENG;
        this.ENG_MEAN = ENG_MEAN;
        this.ENG_WORD = ENG_WORD;
        this.SAVE = SAVE;
        this.ENG_PHIENAM=ENG_PHIENAM;
        this.ENG_NOTE = ENG_NOTE;
    }

    public JapanDic_English() {

    }

    public int getSAVE() {
        return SAVE;
    }

    public void setSAVE(int SAVE) {
        this.SAVE = SAVE;
    }

    public String getID_ENG() {
        return ID_ENG;
    }

    public void setID_ENG(String ID_ENG) {
        this.ID_ENG = ID_ENG;
    }

    public String getENG_WORD() {
        return ENG_WORD;
    }

    public String getENG_PHIENAM() {
        return ENG_PHIENAM;
    }

    public void setENG_PHIENAM(String ENG_PHIENAM) {
        this.ENG_PHIENAM = ENG_PHIENAM;
    }

    public void setENG_WORD(String ENG_WORD) {
        this.ENG_WORD = ENG_WORD;
    }

    public String getENG_MEAN() {
        return ENG_MEAN;
    }

    public void setENG_MEAN(String ENG_MEAN) {
        this.ENG_MEAN = ENG_MEAN;
    }

    public String getENG_NOTE() {
        return ENG_NOTE;
    }

    public void setENG_NOTE(String ENGNOTE) {
        this.ENG_NOTE = ENGNOTE;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JapanDic_English other = (JapanDic_English) obj;
        if ((this.ENG_WORD == null) ? (other.ENG_WORD != null) : !this.ENG_WORD.equals(other.ENG_WORD)) {
            return false;
        }
        if (this.ENG_PHIENAM != other.ENG_PHIENAM) {
            return false;
        }
        if (this.ENG_MEAN != other.ENG_MEAN) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 6;
        return hash;
    }

}



