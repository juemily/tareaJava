package com.tarea.demo.controller;

import com.tarea.demo.model.TareaModel;
import com.tarea.demo.service.imp.TareaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tarea/")
public class TareaController {

    @Autowired
    private TareaServiceImp service ;

    @DeleteMapping("delete/{tareaId}")
    @ResponseStatus (code = HttpStatus.OK)
    public List<TareaModel> deleteTarea(@PathVariable(value = "tareaId", required = true) String tareaId){
        return service.detele(tareaId);
    }


    @PostMapping("insertOrUpdate")
    @ResponseStatus(code = HttpStatus.CREATED)
    public List<TareaModel> insertOrUpdate(@RequestBody final TareaModel tarea){
        return service.save(tarea);
    }

    @GetMapping("listAll")
    @ResponseStatus(code = HttpStatus.OK)
    public  List<TareaModel>findAll (){
        return service.findAll();
    }

}
