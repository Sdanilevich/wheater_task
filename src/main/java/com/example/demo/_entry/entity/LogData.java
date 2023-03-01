package com.example.demo._entry.entity;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
public class LogData {

    @Id
    @Column
    public Long id;

    @Column
    public Date created_at;

    @Column
    public Double latitude;

    @Column
    public Double longitude;



    public LogData(Double latitude, Double longitude){
        this.created_at = new Date();
        this.latitude = latitude;
        this.longitude = longitude;
    }


}
