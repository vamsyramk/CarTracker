package io.vamsy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by vamsyramk on 6/29/2017.
 */
@Entity
public class Alert {
    @Id
    private String id;

    private String rule;
    private String priority;

    public Alert(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "id='" + id + '\'' +
                ", rule='" + rule + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
