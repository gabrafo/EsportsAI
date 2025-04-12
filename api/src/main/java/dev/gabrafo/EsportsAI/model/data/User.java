package dev.gabrafo.EsportsAI.model.data;

import jakarta.persistence.*;

@Table(name = "tb_user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    @Column(unique = true)
    private String email;

    private String phone;

    @Embedded
    private Address address;

    @Embedded
    private CPF cpf;
}