package com.weakwill.weakwillapi.repository;

import com.weakwill.weakwillapi.emtity.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ManagerRepositoryTests {

    @Autowired
    private ManagerRepository managerRepository;

    private Manager savedManager;

    @BeforeEach
    public void setup() {
        // Given
        Manager newManager = new Manager();
        newManager.setEmail("test@example.com");
        newManager.setName("Test Manager");
        newManager.setPassword("password");
        newManager.setPhone("123-456-7890");
        newManager.setAddress("Test Address");

        savedManager = managerRepository.save(newManager);
    }

    @Test
    @Order(1)
    public void testReadManager() {
        // When
        Optional<Manager> foundManager = managerRepository.findById(savedManager.getId());

        // Then
        assertThat(foundManager).isPresent();
        assertThat(foundManager.get().getEmail()).isEqualTo("test@example.com");
    }

    @Test
    @Order(2)
    public void testDeleteManager() {
        // When
        managerRepository.deleteById(savedManager.getId());

        // Then
        Optional<Manager> deletedManager = managerRepository.findById(savedManager.getId());
        assertThat(deletedManager).isNotPresent();
    }
}
