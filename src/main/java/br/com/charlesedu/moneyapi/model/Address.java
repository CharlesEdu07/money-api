package br.com.charlesedu.moneyapi.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "number_address")
    private String numberAddress;

    private String complement;
    private String neighborhood;
    private String cep;
    private String city;

    @Column(name = "state_address")
    private String stateAddress;

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getNumberAddress() {
        return numberAddress;
    }

    public void setNumberAddress(String numberAddress) {
        this.numberAddress = numberAddress;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateAddress() {
        return stateAddress;
    }

    public void setStateAddress(String stateAddress) {
        this.stateAddress = stateAddress;
    }
}
