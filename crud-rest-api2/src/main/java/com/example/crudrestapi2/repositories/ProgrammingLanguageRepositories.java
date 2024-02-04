package com.example.crudrestapi2.repositories;

import com.example.crudrestapi2.entities.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProgrammingLanguageRepositories extends JpaRepository<ProgrammingLanguage, Long> {
}
