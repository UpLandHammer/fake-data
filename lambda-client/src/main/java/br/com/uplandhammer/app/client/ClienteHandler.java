package br.com.uplandhammer.app.client;

import br.com.uplandhammer.app.FakeCustomerUtils;
import br.com.uplandhammer.model.Customer;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;
import java.util.ServiceLoader;

public class ClienteHandler implements RequestHandler<Map<String, Object>, Customer> {

    private final FakeCustomerUtils fakeCustomerUtils;

    public ClienteHandler() {
        this.fakeCustomerUtils = ServiceLoader
                .load(FakeCustomerUtils.class)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalStateException(
                                "Implementação da Layer não encontrada"
                        )
                );
    }

    @Override
    public Customer handleRequest(Map<String, Object> input, Context context) {
        return fakeCustomerUtils.generateCustomer();
    }
}
