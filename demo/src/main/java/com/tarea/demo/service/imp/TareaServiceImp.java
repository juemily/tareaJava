package com.tarea.demo.service.imp;

import com.tarea.demo.entity.TareaEntity;
import com.tarea.demo.model.TareaModel;
import com.tarea.demo.repository.TareaRepository;
import com.tarea.demo.service.TareaService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TareaServiceImp implements TareaService {

    @Autowired
    TareaRepository repository;

    @Override
    @SneakyThrows
    public List<TareaModel> save(TareaModel tarea) {
        TareaEntity insert = new TareaEntity();
        insert.setTarea(tarea.getTarea());
        insert.setDescription(tarea.getDescription());

        if (tarea.getTareaId() != null){
            insert.setTareaId(tarea.getTareaId());
        }
        repository.save(insert);
        return  findAll();
    }

    @Override
    public List<TareaModel> detele(String tareaId) {
        UUID uid = UUID.fromString(tareaId);
        repository.deleteAllById(Collections.singleton(uid));
        return findAll();
    }

    @Override
    public List<TareaModel> findAll() {
        List<TareaEntity> listEntity = repository.findAll();
        return  listEntity.stream().map(temp -> {
            TareaModel obj = new TareaModel();
            obj.setTarea(temp.getTarea());
            obj.setDescription(temp.getDescription());
            obj.setTareaId(temp.getTareaId());
            return obj;
        }).collect(Collectors.toList());
    }


}
