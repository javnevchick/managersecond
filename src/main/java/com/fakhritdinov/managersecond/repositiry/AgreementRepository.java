package com.fakhritdinov.managersecond.repositiry;

import com.fakhritdinov.managersecond.model.Agreement;
import com.fakhritdinov.managersecond.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AgreementRepository extends JpaRepository<Agreement, Integer> {

    @Query(value = "select * from agreement order by id desc limit 1", name = "lastAgr", nativeQuery = true)
    public Agreement getLast();
}
