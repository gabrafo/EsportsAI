package dev.gabrafo.EsportsAI.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.gabrafo.EsportsAI.model.data.Address;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "ViaCepResponse", description = "DTO representing the response from the ViaCep API")
public record ViaCepResponseDTO(
        @Schema(description = "Postal code in ViaCep format", example = "01311-000")
        @NotBlank @JsonProperty("cep") String cep,

        @Schema(description = "Street name (public thoroughfare)", example = "Avenida Paulista")
        @NotBlank @JsonProperty("logradouro") String street,

        @Schema(description = "Neighborhood or district", example = "Bela Vista")
        @NotBlank @JsonProperty("bairro") String district,

        @Schema(description = "City name", example = "São Paulo")
        @NotBlank @JsonProperty("localidade") String city,

        @Schema(description = "State abbreviation", example = "SP")
        @NotBlank @JsonProperty("uf") String state
) {
    public ViaCepResponseDTO(Address address){
        this(
                address.getCep(),
                address.getStreet(),
                address.getDistrict(),
                address.getCity(),
                String.valueOf(address.getState())
        );
    }
}