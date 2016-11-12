package com.example.user.dictionary_eng_ja.Object;

import java.io.Serializable;

/**
 * Created by Tung Lam on 30-Oct-16.
 */

public class JapanDic_English implements Serializable {
    private String ID_ENG; //// stt
    private String ENG_WORD;    /// tu`
    private String ENG_MEAN;    /// y nghia
    private String ENG_NOTE;    /// chu y
    private int  SAVE;

    public JapanDic_English(String ID_ENG, String ENG_MEAN, String ENG_WORD, int SAVE, String ENG_NOTE) {
        this.ID_ENG = ID_ENG;
        this.ENG_MEAN = ENG_MEAN;
        this.ENG_WORD = ENG_WORD;
        this.SAVE = SAVE;
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


}
