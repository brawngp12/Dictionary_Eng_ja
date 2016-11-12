package com.example.user.dictionary_eng_ja.Object;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tung Lam on 28-Oct-16.
 */

public class JapanDic_Defination implements Serializable {
    private String STT;        /// stt
    private String WORD_JAP;    ///  tieng nhat
    private String TRANSLATE;  /// phien am
    private String EXAMPLE;     //// vi du

    public String getEXAMPLE() {
        return EXAMPLE;
    }

    public void setEXAMPLE(String EXAMPLE) {
        this.EXAMPLE = EXAMPLE;
    }

    public JapanDic_Defination(String STT, String WORD_JAP, String TRANSLATE, String EXAMPLE) {

        this.STT = STT;
        this.WORD_JAP = WORD_JAP;
        this.TRANSLATE = TRANSLATE;
        this.EXAMPLE = EXAMPLE;
    }

    public JapanDic_Defination() {

    }

    public String getSTT() {
        return STT;
    }

    public void setSTT(String STT) {
        this.STT = STT;
    }

    public String getWORD_JAP() {
        return WORD_JAP;
    }

    public void setWORD_JAP(String WORD_JAP) {
        this.WORD_JAP = WORD_JAP;
    }

    public String getTRANSLATE() {
        return TRANSLATE;
    }

    public void setTRANSLATE(String TRANSLATE) {
        this.TRANSLATE = TRANSLATE;
    }



}
