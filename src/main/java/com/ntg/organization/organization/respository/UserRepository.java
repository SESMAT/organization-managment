package com.ntg.organization.organization.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ntg.organization.organization.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	public User findByUserName(String name);
}
