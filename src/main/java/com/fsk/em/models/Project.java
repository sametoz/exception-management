package com.fsk.em.models;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "project")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Project Class")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @ApiModelProperty(name = "id", dataType = "Long")
    private Long id;

    @ApiModelProperty(name = "projectName", value = "500", dataType = "String", notes = "for ex: Error Management Project")
    @Column(name = "project_name", length = 500)
    private String projectName;

    @Column(name = "project_language", length = 1000)
    @ApiModelProperty(name = "projectLanguage", value = "1000", dataType = "String", notes = "for ex: Java")
    private String projectLanguage;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "technology_id")
    @ApiModelProperty(name = "technologyList", dataType = "List<Technology>")
    private List<Technology> technology;


}
