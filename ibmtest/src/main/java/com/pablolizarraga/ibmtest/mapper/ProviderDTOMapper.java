package com.pablolizarraga.ibmtest.mapper;

import com.pablolizarraga.ibmtest.dto.ProviderDTO;
import com.pablolizarraga.ibmtest.model.Provider;

public class ProviderDTOMapper {

    public static ProviderDTO toDTO(Provider provider) {
        return new ProviderDTO(provider.getName(), provider.getCreated());
    }
}
