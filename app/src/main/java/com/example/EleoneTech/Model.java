package com.example.EleoneTech;


public class Model {
    private String id, date, matricule, of, prf, poste,
            h1pass, h1fail, h1total, h1defaux, h1cadence,
            h2pass, h2fail, h2total, h2defaux, h2cadence,
            h3pass, h3fail, h3total, h3defaux, h3cadence,
            h4pass, h4fail, h4total, h4defaux, h4cadence,
            h5pass, h5fail, h5total, h5defaux, h5cadence,
            h6pass, h6fail, h6total, h6defaux, h6cadence,
            h7pass, h7fail, h7total, h7defaux, h7cadence,
            h8pass, h8fail, h8total, h8defaux, h8cadence,
            defaux, cadence, cadencethe, ActualH;


    public Model(String id, String date, String of, String prf, String matricule, String poste,
                    String h1pass, String h1fail, String h1total, String h1defaux, String h1cadence,
                    String h2pass, String h2fail, String h2total, String h2defaux, String h2cadence,
                    String h3pass, String h3fail, String h3total, String h3defaux, String h3cadence,
                    String h4pass, String h4fail, String h4total, String h4defaux, String h4cadence,
                    String h5pass, String h5fail, String h5total, String h5defaux, String h5cadence,
                    String h6pass, String h6fail, String h6total, String h6defaux, String h6cadence,
                    String h7pass, String h7fail, String h7total, String h7defaux, String h7cadence,
                    String h8pass, String h8fail, String h8total, String h8defaux, String h8cadence,
                    String defaux, String cadence, String cadencethe, String actualH) {
        this.id = id;
        this.date = date;
        this.matricule = matricule;
        this.of = of;
        this.prf = prf;
        this.poste = poste;
        this.h1pass = h1pass;
        this.h1fail = h1fail;
        this.h1total = h1total;
        this.h1defaux = h1defaux;
        this.h1cadence = h1cadence;
        this.h2pass = h2pass;
        this.h2fail = h2fail;
        this.h2total = h2total;
        this.h2defaux = h2defaux;
        this.h2cadence = h2cadence;
        this.h3pass = h3pass;
        this.h3fail = h3fail;
        this.h3total = h3total;
        this.h3defaux = h3defaux;
        this.h3cadence = h3cadence;
        this.h4pass = h4pass;
        this.h4fail = h4fail;
        this.h4total = h4total;
        this.h4defaux = h4defaux;
        this.h4cadence = h4cadence;
        this.h5pass = h5pass;
        this.h5fail = h5fail;
        this.h5total = h5total;
        this.h5defaux = h5defaux;
        this.h5cadence = h5cadence;
        this.h6pass = h6pass;
        this.h6fail = h6fail;
        this.h6total = h6total;
        this.h6defaux = h6defaux;
        this.h6cadence = h6cadence;
        this.h7pass = h7pass;
        this.h7fail = h7fail;
        this.h7total = h7total;
        this.h7defaux = h7defaux;
        this.h7cadence = h7cadence;
        this.h8pass = h8pass;
        this.h8fail = h8fail;
        this.h8total = h8total;
        this.h8defaux = h8defaux;
        this.h8cadence = h8cadence;
        this.defaux = defaux;
        this.cadence = cadence;
        this.cadencethe = cadencethe;
        ActualH = actualH;
    }

    public Model(String id, String date, String poste,
                    String h1pass, String h1fail, String h1total, String h1defaux, String h1cadence,
                    String h2pass, String h2fail, String h2total, String h2defaux, String h2cadence,
                    String h3pass, String h3fail, String h3total, String h3defaux, String h3cadence,
                    String h4pass, String h4fail, String h4total, String h4defaux, String h4cadence,
                    String h5pass, String h5fail, String h5total, String h5defaux, String h5cadence,
                    String h6pass, String h6fail, String h6total, String h6defaux, String h6cadence,
                    String h7pass, String h7fail, String h7total, String h7defaux, String h7cadence,
                    String h8pass, String h8fail, String h8total, String h8defaux, String h8cadence,
                    String defaux, String cadence, String cadencethe, String actualH) {
        this.id = id;
        this.date = date;
        this.poste = poste;
        this.h1pass = h1pass;
        this.h1fail = h1fail;
        this.h1total = h1total;
        this.h1defaux = h1defaux;
        this.h1cadence = h1cadence;
        this.h2pass = h2pass;
        this.h2fail = h2fail;
        this.h2total = h2total;
        this.h2defaux = h2defaux;
        this.h2cadence = h2cadence;
        this.h3pass = h3pass;
        this.h3fail = h3fail;
        this.h3total = h3total;
        this.h3defaux = h3defaux;
        this.h3cadence = h3cadence;
        this.h4pass = h4pass;
        this.h4fail = h4fail;
        this.h4total = h4total;
        this.h4defaux = h4defaux;
        this.h4cadence = h4cadence;
        this.h5pass = h5pass;
        this.h5fail = h5fail;
        this.h5total = h5total;
        this.h5defaux = h5defaux;
        this.h5cadence = h5cadence;
        this.h6pass = h6pass;
        this.h6fail = h6fail;
        this.h6total = h6total;
        this.h6defaux = h6defaux;
        this.h6cadence = h6cadence;
        this.h7pass = h7pass;
        this.h7fail = h7fail;
        this.h7total = h7total;
        this.h7defaux = h7defaux;
        this.h7cadence = h7cadence;
        this.h8pass = h8pass;
        this.h8fail = h8fail;
        this.h8total = h8total;
        this.h8defaux = h8defaux;
        this.h8cadence = h8cadence;
        this.defaux = defaux;
        this.cadence = cadence;
        this.cadencethe = cadencethe;
        ActualH = actualH;
    }


    public String getH1pass() {
        return h1pass;
    }

    public String getH1fail() {
        return h1fail;
    }

    public String getH1total() {
        return h1total;
    }

    public String getH2pass() {
        return h2pass;
    }

    public String getH2fail() {
        return h2fail;
    }

    public String getH2total() {
        return h2total;
    }

    public String getH3pass() {
        return h3pass;
    }

    public String getH3fail() {
        return h3fail;
    }

    public String getH3total() {
        return h3total;
    }

    public String getH4pass() {
        return h4pass;
    }

    public String getH4fail() {
        return h4fail;
    }

    public String getH4total() {
        return h4total;
    }

    public String getH5pass() {
        return h5pass;
    }

    public String getH5fail() {
        return h5fail;
    }

    public String getH5total() {
        return h5total;
    }

    public String getH6pass() {
        return h6pass;
    }

    public String getH6fail() {
        return h6fail;
    }

    public String getH6total() {
        return h6total;
    }

    public String getH7pass() {
        return h7pass;
    }

    public String getH7fail() {
        return h7fail;
    }

    public String getH7total() {
        return h7total;
    }

    public String getH8pass() {
        return h8pass;
    }

    public String getH8fail() {
        return h8fail;
    }

    public String getH8total() {
        return h8total;
    }

    public String getActualH() {
        return ActualH;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getOf() {
        return of;
    }

    public String getPrf() {
        return prf;
    }

    public String getPoste() {
        return poste;
    }

    public String getDefaux() {
        return defaux;
    }

    public String getCadence() {
        return cadence;
    }


    public String getH1defaux() {
        return h1defaux;
    }

    public String getH1cadence() {
        return h1cadence;
    }

    public String getH2defaux() {
        return h2defaux;
    }

    public String getH2cadence() {
        return h2cadence;
    }

    public String getH3defaux() {
        return h3defaux;
    }

    public String getH3cadence() {
        return h3cadence;
    }

    public String getH4defaux() {
        return h4defaux;
    }

    public String getH4cadence() {
        return h4cadence;
    }

    public String getH5defaux() {
        return h5defaux;
    }

    public String getH5cadence() {
        return h5cadence;
    }

    public String getH6defaux() {
        return h6defaux;
    }

    public String getH6cadence() {
        return h6cadence;
    }

    public String getH7defaux() {
        return h7defaux;
    }

    public String getH7cadence() {
        return h7cadence;
    }

    public String getH8defaux() {
        return h8defaux;
    }

    public String getH8cadence() {
        return h8cadence;
    }

    public String getCadencethe() {
        return cadencethe;
    }



}

