package com.ntg.organization.organization.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ntg.organization.organization.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long>{

}
