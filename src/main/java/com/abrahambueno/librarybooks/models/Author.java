package com.abrahambueno.librarybooks.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorid;

    private String lastname;
    private String firstname;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "sectionauthors",
    joinColumns = {@JoinColumn(name = "authorid")},
            inverseJoinColumns = {@JoinColumn(name = "sectionid")})
    private Set<Section> sections;


}
