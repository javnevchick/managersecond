package com.fakhritdinov.managersecond.repositiry;

import com.fakhritdinov.managersecond.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    @Query(value = "select * from application order by id desc limit 1", name = "lastApp", nativeQuery = true)
    public Application getLast();
}
