package com.example.demo._entry.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@Table(name = "log_data")
@NoArgsConstructor
public class LogData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    public Long id;

    @Column
    public Date created_at;

    @Column
    public Date updated_at;

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
