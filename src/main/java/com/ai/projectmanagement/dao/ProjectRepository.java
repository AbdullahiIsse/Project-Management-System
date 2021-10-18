package com.ai.projectmanagement.dao;

import com.ai.projectmanagement.dto.ProjectStage;
import com.ai.projectmanagement.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProjectRepository extends PagingAndSortingRepository<Project,Long> {
    @Override
   public List<Project> findAll();


    @Query(nativeQuery = true, value = "SELECT stage AS label, COUNT(*) AS value " +
            "FROM project " +
            "GROUP BY stage")

    public List<ProjectStage>projectStage();







}
