package com.ai.projectmanagement.dao;


import com.ai.projectmanagement.ProjectManagementApplication;
import com.ai.projectmanagement.dao.ProjectRepository;
import com.ai.projectmanagement.entities.Project;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,scripts = {"classpath:schema.sql","classpath:data.sql"}),
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,scripts = "classpath:drop.sql")})
public class ProjectRepositoryIntegrationTest {


    @Autowired
    ProjectRepository proRepo;


    @Test
    public void ifNewProjectSaved_thenSuccess(){

        Project newProject = new Project("New Test Project","COMPLETE","Test description");
        proRepo.save(newProject);
        assertEquals(5, proRepo.findAll().size());

    }







}
