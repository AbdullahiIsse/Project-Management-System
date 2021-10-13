package com.ai.projectmanagement.dao;

import com.ai.projectmanagement.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount,Long> {


}
