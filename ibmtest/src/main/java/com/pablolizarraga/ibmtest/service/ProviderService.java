package com.pablolizarraga.ibmtest.service;

import com.pablolizarraga.ibmtest.dto.ProviderDTO;
import com.pablolizarraga.ibmtest.mapper.ProviderDTOMapper;
import com.pablolizarraga.ibmtest.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

    public List<ProviderDTO> findByClientId(Long clientId) {
        if (clientId == null) {
            return new ArrayList<>();
        }

        return providerRepository.findByClientId(clientId)
                .stream()
                .map(ProviderDTOMapper::toDTO)
                .collect(Collectors.toList());
    }
}
