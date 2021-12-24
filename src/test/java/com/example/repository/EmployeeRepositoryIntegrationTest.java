package com.example.repository;
import com.example.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        String name = "Doe";
        Employee employee1 = new Employee();
        employee1.setName(name);
        entityManager.persist(employee1);
        Employee employee2=new Employee();
        employee2.setName("John");
        entityManager.persist(employee2);
        entityManager.flush();

        List<Employee> list=employeeRepository.findAll();
        Assert.assertTrue("Total Number of employees is 2",(list.size()==2));
        Assert.assertEquals(2,list.size());
        // when
        Employee found = employeeRepository.findByName(list.get(0).getName());

        // then
        Assert.assertNotNull(found);
        Assert.assertEquals(found.getName(),name);

    }

}