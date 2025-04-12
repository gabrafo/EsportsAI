package dev.gabrafo.EsportsAI.model.data;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CPF {

    @Column(unique=true)
    private String cpf;

    @Lob
    @Column(name="front_image", columnDefinition="BLOB")
    private byte[] frontImage;

    @Lob
    @Column(name="back_image", columnDefinition="BLOB")
    private byte[] backImage;
}
