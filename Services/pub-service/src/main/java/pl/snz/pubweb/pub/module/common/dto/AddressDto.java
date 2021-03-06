package pl.snz.pubweb.pub.module.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class AddressDto {

    private String city;
    private String street;
    private String number;

}
