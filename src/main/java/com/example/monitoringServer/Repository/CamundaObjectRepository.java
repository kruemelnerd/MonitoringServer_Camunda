package com.example.monitoringServer.Repository;

import com.example.monitoringServer.Model.CamundaObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamundaObjectRepository extends CrudRepository<CamundaObject, Long> {

}
