package br.com.charlesedu.moneyapi.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String street_address;
    private Integer number;
}
