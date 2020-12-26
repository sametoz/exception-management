package com.fsk.em.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "technology")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Technology Class")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @ApiModelProperty(name = "id", dataType = "Long")
    private Long id;

    @ApiModelProperty(name = "technologyName", value = "100", dataType = "String", notes = "for ex: Microservices, Docker, PostgreSql ...")
    private String technologyName;

    @ManyToMany
    @JoinColumn(name = "project_id")
    @ApiModelProperty(name = "projectList", dataType = "List<Project>")
    private List<Project> projects;
}
