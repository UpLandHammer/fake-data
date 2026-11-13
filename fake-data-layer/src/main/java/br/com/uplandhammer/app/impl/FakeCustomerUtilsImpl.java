package br.com.uplandhammer.app.impl;

import br.com.uplandhammer.app.FakeCustomerUtils;
import br.com.uplandhammer.model.Customer;
import com.github.javafaker.Faker;

import java.util.Locale;

public class FakeCustomerUtilsImpl implements FakeCustomerUtils {

    private final Faker faker = new Faker(Locale.forLanguageTag("pt-BR"));

    @Override
    public Customer generateCustomer() {
        return new Customer(
                faker.name().fullName(),
                faker.number().digits(11),
                faker.address().fullAddress()
        );
    }
}
