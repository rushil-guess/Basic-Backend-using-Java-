package com.rushil.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto generation
    private int JobId;
    private String JobDesc;
    private int Experience;
    private List<String> Skills;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private Date date;
    private String imageName;
    private String ContentType;
    @Lob // for large object model like imaages
    private byte[] imagedata;

}
