package com.shubhankar.excity.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
//@AllArgsConstructor
//@NoArgsConstructor
public class ActivityType {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    @Column(
            nullable = false
    )
    private String name;
}
