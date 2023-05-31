package com.pablolizarraga.ibmtest.dto;

import java.time.LocalDateTime;

public record ProviderDTO(
        String name,
        LocalDateTime created
) {
}
