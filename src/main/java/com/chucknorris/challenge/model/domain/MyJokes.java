package com.chucknorris.challenge.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "my_jokes")
public class MyJokes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_joke")
    private Long idJoke;

    @Column(name = "icon_url")
    private String iconUrl;

    @Column(name = "id")
    private String idJokeApi;

    private String url;

    @Column(name = "value")
    private String joke;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_user",insertable = false, updatable = false)
    private User user;
}