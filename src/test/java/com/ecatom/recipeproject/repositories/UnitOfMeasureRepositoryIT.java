package com.ecatom.recipeproject.repositories;

import com.ecatom.recipeproject.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)//Integration test bringing up Spring context, only once for all the tests bellow
@DataJpaTest //Bring up embedded DB and configure JPA
public class UnitOfMeasureRepositoryIT {

    @Autowired//When spring context starts we will get an instance of UomRepository
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByUom() {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByUom("Teaspoon");
        assertEquals("Teaspoon" , uomOptional.get().getUom());
    }
}