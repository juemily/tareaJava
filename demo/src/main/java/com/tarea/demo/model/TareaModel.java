package com.tarea.demo.model;

import lombok.Data;
import java.util.UUID;


@Data
public class TareaModel {


    private UUID tareaId;
    private String tarea;
    private String description;

    public TareaModel() {
    }

    public TareaModel(String tarea, String description, UUID tareaId) {
        this.tarea = tarea;
        this.description = description;
        this.tareaId = tareaId;
    }

}
