package com.crocodoc.crocodocartifact.repository;

import com.crocodoc.crocodocartifact.model.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
