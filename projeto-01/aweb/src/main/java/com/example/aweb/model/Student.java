package com.example.aweb.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome não pode estar em branco!")
    @Email(message = "E-mail inválido")
    @NotBlank(message = "É necessário o fornecimento de um e-mail")
    private String email;
    @CPF(message = "CPF inválido")
    @NotBlank(message = "O campo precisa ser preenchido!")
    private String cpf;
    @NotNull(message = "O campo é obrigatório!")
    @Past(message = "Data de nascimento inválida!")
    private LocalDate dataNascimento;

    public Student(){}

    public Student(Long id,
            @NotBlank(message = "O nome não pode estar em branco!") @Email(message = "E-mail inválido") @NotBlank(message = "É necessário o fornecimento de um e-mail") String email,
            @CPF(message = "CPF inválido") @NotBlank(message = "O campo precisa ser preenchido!") String cpf,
            @NotNull(message = "O campo é obrigatório!") @Past(message = "Data de nascimento inválida!") LocalDate dataNascimento) {
        this.id = id;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    
}
