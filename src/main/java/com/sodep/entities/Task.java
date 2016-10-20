package com.sodep.entities;

import static javax.xml.bind.annotation.XmlAccessType.NONE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(NONE)
@Entity
@Table(name="tasks")
public final class Task implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
	@XmlAttribute
	private String description;
    
	@XmlAttribute
	private Assignee assignee;
    
    /**
     The date where the task
     should be completed.
    */
	@XmlAttribute
	private Date due;
    
    /**
      The date where the task
      was completed.
    */
	@XmlAttribute
	@Column(name = "completed_at")
	private Date completedAt;
    
    /**
      The date where the task
      was created.
    */
	@XmlAttribute
	@Column(name = "created_at")
	private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(final Assignee assignee) {
        this.assignee = assignee;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(final Date due) {
        this.due = due;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(final Date completedAt) {
        this.completedAt = completedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }
}
