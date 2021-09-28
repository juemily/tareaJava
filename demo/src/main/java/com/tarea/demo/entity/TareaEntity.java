package com.tarea.demo.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class TareaEntity {

    @Id
    @GeneratedValue
    private UUID tareaId;

    @Column(name = "tarea")
    @NonNull
    private String tarea;

    @Column(name = "decription")
    @NonNull
    private String Description;

    public TareaEntity() {
    }

    public TareaEntity(UUID tareaId, String tarea, String description) {
        this.tareaId = tareaId;
        this.tarea = tarea;
        Description = description;
    }
}
