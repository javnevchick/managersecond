package com.fakhritdinov.managersecond.repositiry;

import com.fakhritdinov.managersecond.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}
