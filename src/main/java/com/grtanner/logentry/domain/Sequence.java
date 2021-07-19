package com.grtanner.logentry.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author glen on 07/14/2021
 */
@Entity
@IdClass(SequenceId.class)
public class Sequence implements Serializable {

    @Id
    @Column(name = "COUNT")
    private String count;
    @Id
    @Column(name = "SEQUENCE")
    private String sequence;
    @Id
    @Column(name = "SOURCE")
    private String source;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String endpoint) {
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sequence sequence1 = (Sequence) o;

        if (count != null ? !count.equals(sequence1.count) : sequence1.count != null) return false;
        if (sequence != null ? !sequence.equals(sequence1.sequence) : sequence1.sequence != null) return false;
        return source != null ? source.equals(sequence1.source) : sequence1.source == null;
    }

    @Override
    public int hashCode() {
        int result = count != null ? count.hashCode() : 0;
        result = 31 * result + (sequence != null ? sequence.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Sequence{" +
                "count='" + count + '\'' +
                ", sequence='" + sequence + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
