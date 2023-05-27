package com.Stryker_Backend.Maven;

import com.Stryker_Backend.Maven.entity.dao.HospitalDetailsEntity;
import com.Stryker_Backend.Maven.repository.HospitalDetailsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class HospitalDetailsRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private HospitalDetailsRepository hospitalDetailsRepository;

    @Test
    public void testFetchHospitalDetails() {
        // Arrange
        String customerName = "John Doe";

        // Create a mock entity
        HospitalDetailsEntity entity = new HospitalDetailsEntity();
        entity.setCustomerName(customerName);
        // Set other properties if needed

        entityManager.persist(entity);
        entityManager.flush();

        // Act
        List<HospitalDetailsEntity> results = hospitalDetailsRepository.FetchHospitalDetails(customerName);

        // Assert
        assertEquals(1, results.size());
        assertEquals(customerName, results.get(0).getCustomerName());
        // Add additional assertions if needed
    }
}
