package com.rs.warehouse.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;





@Entity
@Table(name = "releaseTable")
@Getter
@Setter

public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String releaseId;
    private String orderId;
    private String shipFromLocationId;
    //@JsonIgnore
    private String status;

    @OneToMany(mappedBy = "release",cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private Set<ReleaseLine> releaseLine;





    public Set<ReleaseLine> setChildren(Set<ReleaseLine> releaseLines) {
        for (ReleaseLine r  : releaseLines) {
            r.setRelease(this);
        }

        this.releaseLine = releaseLines;
        return releaseLines;
    }

}
