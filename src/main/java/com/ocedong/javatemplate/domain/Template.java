package com.ocedong.javatemplate.domain;


import com.ocedong.common.models.AbstractAuditingEntity;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "templates")
public class Template extends AbstractAuditingEntity {

    @Column(name="name", length = 200)
    private String name;
    public Template() {

    }
    public Template(UUID id, String name, String createdBy, Instant createdDate, String lastModifiedBy, Instant lastModifiedDate, String tenantCode) {
        super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate, tenantCode);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
