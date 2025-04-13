package dev.gabrafo.EsportsAI.clients;

import dev.gabrafo.EsportsAI.model.dtos.ViaCepResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
@Tag(name = "ViaCep", description = "API used for requesting address data using zip code.")
public interface ViaCep {

    @GetMapping("/{cep}/json")
    ViaCepResponseDTO findAddressByCep(@PathVariable String cep);
}