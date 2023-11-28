package com.rubypaper.domain;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Board {
	@Id
	@GeneratedValue
    private int seq;
    private String title;
    private String writer;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(columnDefinition="integer default 0")
    private int cnt;
    
    @PrePersist
    public void prePersist() {
        this.createDate = new Date();
    }
}
