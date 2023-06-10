package com.devthalys.usermanagementapi.dtos;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

public record UserDto(String firstName, String secondName, int age, String address, @CPF String cpf, String rg, @Email String email) {
}
