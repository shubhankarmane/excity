package com.shubhankar.excity.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    @Column(
            nullable = false
    )
    private String description;
    @Column(
            nullable = false
    )
    private Integer peopleRequired;
    private Double price;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "type_id",
            referencedColumnName = "id"
    )
    private ActivityType activityType;
}
