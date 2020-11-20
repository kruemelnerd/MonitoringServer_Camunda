package com.example.monitoringServer.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize
public class CamundaObject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long camundaObject_id;
    private long startzeit;
    private long endzeit;
    private long durchlaufzeit_nano;
    private long durchlaufzeit_ms;
    private long durchlaufzeit_sec;

    public long getCamundaObject_id() {
        return camundaObject_id;
    }

    public long getStartzeit() {
        return startzeit;
    }

    public long getEndzeit() {
        return endzeit;
    }

    public long getDurchlaufzeit_nano() {
        return durchlaufzeit_nano;
    }

    public long getDurchlaufzeit_ms() {
        return durchlaufzeit_ms;
    }

    public long getDurchlaufzeit_sec() {
        return durchlaufzeit_sec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CamundaObject that = (CamundaObject) o;
        return startzeit == that.startzeit &&
                endzeit == that.endzeit &&
                durchlaufzeit_nano == that.durchlaufzeit_nano &&
                durchlaufzeit_ms == that.durchlaufzeit_ms &&
                durchlaufzeit_sec == that.durchlaufzeit_sec;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startzeit, endzeit, durchlaufzeit_nano, durchlaufzeit_ms, durchlaufzeit_sec);
    }

    @Override
    public String toString() {
        return "CamundaObject{" +
                "startzeit=" + startzeit +
                ", endzeit=" + endzeit +
                ", durchlaufzeit_nano=" + durchlaufzeit_nano +
                ", durchlaufzeit_ms=" + durchlaufzeit_ms +
                ", durchlaufzeit_sec=" + durchlaufzeit_sec +
                '}';
    }

    public static final class CamundaObjectBuilder {
        private long startzeit;
        private long endzeit;
        private long durchlaufzeit_nano;
        private long durchlaufzeit_ms;
        private long durchlaufzeit_sec;

        private CamundaObjectBuilder() {
        }

        public static CamundaObjectBuilder aCamundaObject() {
            return new CamundaObjectBuilder();
        }

        public CamundaObjectBuilder withStartzeit(long startzeit) {
            this.startzeit = startzeit;
            return this;
        }

        public CamundaObjectBuilder withEndzeit(long endzeit) {
            this.endzeit = endzeit;
            return this;
        }

        public CamundaObjectBuilder withDurchlaufzeit_nano(long durchlaufzeit_nano) {
            this.durchlaufzeit_nano = durchlaufzeit_nano;
            return this;
        }

        public CamundaObjectBuilder withDurchlaufzeit_ms(long durchlaufzeit_ms) {
            this.durchlaufzeit_ms = durchlaufzeit_ms;
            return this;
        }

        public CamundaObjectBuilder withDurchlaufzeit_sec(long durchlaufzeit_sec) {
            this.durchlaufzeit_sec = durchlaufzeit_sec;
            return this;
        }

        public CamundaObject build() {
            CamundaObject camundaObject = new CamundaObject();
            camundaObject.durchlaufzeit_ms = this.durchlaufzeit_ms;
            camundaObject.durchlaufzeit_sec = this.durchlaufzeit_sec;
            camundaObject.durchlaufzeit_nano = this.durchlaufzeit_nano;
            camundaObject.startzeit = this.startzeit;
            camundaObject.endzeit = this.endzeit;
            return camundaObject;
        }
    }
}
