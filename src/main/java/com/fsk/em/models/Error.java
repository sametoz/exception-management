package com.fsk.em.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "error")
@Entity
@Getter
@Setter
@AllArgsConstructor
@ApiModel(description = "Error Class")
public class Error {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @ApiModelProperty(name = "id", dataType = "Long")
    private Long id;

    @Column(name = "error_message", length = 500)
    @ApiModelProperty(name = "errorMessage", value = "500", dataType = "String", notes = "for ex: java.lang.NullPointerException")
    private String errorMessage;

    @Column(name = "error_explanation", length = 1000)
    @ApiModelProperty(name = "errorExplanation", value = "1000", dataType = "String", notes = "for ex: This field is null.")
    private String errorExplanation;

    @CreationTimestamp
    @ApiModelProperty(name = "createdTimeOfError", value = "Date", dataType = "LocalDateTime", notes = "When created this error.?")
    private LocalDateTime createdTimeOfError;

    @Column(name = "notes")
    @ElementCollection
    private List<String> notes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;

//    @Enumerated(value = EnumType.STRING)
//    @Column(name = "error_status")
//    private Error errorStatus;

    public Error(){
        notes = new ArrayList<>();
    }


}
