package com.glabs.dmaic.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glabs.dmaic.user.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long> 
{

}
