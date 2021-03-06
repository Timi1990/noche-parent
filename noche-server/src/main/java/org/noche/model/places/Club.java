package org.noche.model.places;

import org.noche.model.LiteAbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Timi on 4/5/2017.
 */
@Entity(name = "Club")
@Table(name = "noche_club")
public class Club extends Place {

    /* --- Members --- */

    @Column(name = "dj")
    private String dj;

    /* --- Constructor --- */

    public Club() {
    }

    public Club(String dj) {
        this.dj = dj;
    }

    /* --- Getters/Setters --- */

    public String getDj() {
        return dj;
    }

    public void setDj(String dj) {
        this.dj = dj;
    }
}
