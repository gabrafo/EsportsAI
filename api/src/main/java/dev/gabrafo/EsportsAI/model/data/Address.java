package dev.gabrafo.EsportsAI.model.data;

import dev.gabrafo.EsportsAI.model.dtos.ViaCepResponseDTO;
import dev.gabrafo.EsportsAI.model.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

    @Column(name = "cep", nullable = false, length = 8)
    private String cep;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "address_number")
    private Integer addressNumber;

    @Column(name = "complement")
    private String complement;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private State state;

    public void addFromViaCepRequest(ViaCepResponseDTO dto){
        this.setStreet(dto.street());
        this.setCity(dto.city());
        this.setDistrict(dto.district());
        this.setState(State.valueOf(dto.state()));
    }
}