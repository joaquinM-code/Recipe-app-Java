package com.ecatom.recipeproject.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne //Recipes owns notes so if we delete notes recipe will not be deleted (therefore no cascade added)
    private Recipe recipe;

    @Lob //Allows to surpass the 255 character limit of the String type in Hibernate and JPA
    private String recipeNotes;

}
