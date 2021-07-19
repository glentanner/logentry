package com.grtanner.logentry.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SequenceId implements Serializable {
    private String count;
    private String sequence;
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

    public void setSource(String source) {
        this.source = source;
    }
}
