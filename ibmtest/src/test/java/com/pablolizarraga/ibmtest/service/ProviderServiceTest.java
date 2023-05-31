package com.pablolizarraga.ibmtest.service;

import com.pablolizarraga.ibmtest.controller.ProviderController;
import com.pablolizarraga.ibmtest.dto.ProviderDTO;
import com.pablolizarraga.ibmtest.model.Provider;
import com.pablolizarraga.ibmtest.repository.ProviderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ProviderServiceTest {

    @Mock
    private ProviderRepository providerRepository;

    @InjectMocks
    private ProviderService providerService;

    @Test
    public void givenExistingClientId_whenGetByClientId_thenReturnProvidersList() throws Exception {
        //given - precondition or setup
        Provider provider1 = Provider.builder()
                .id(1L)
                .name("Provider1")
                .created(LocalDateTime.now())
                .clientId(1L)
                .build();

        Provider provider2 = Provider.builder()
                .id(2L)
                .name("Provider2")
                .created(LocalDateTime.now())
                .clientId(1L)
                .build();

        given(providerRepository.findByClientId(1L))
                .willReturn(List.of(provider1, provider2));

        //when
        List<ProviderDTO> providers = providerService.findByClientId(1L);

        //then
        Assertions.assertThat(providers).isNotNull().isNotEmpty();
        Assertions.assertThat(providers.size()).isEqualTo(2);

    }

    @Test
    public void givenNonExistingClientId_whenGetByClientId_thenReturnEmptyList() throws Exception {
        //given - precondition or setup
        given(providerRepository.findByClientId(-1L))
                .willReturn(Collections.emptyList());

        //when
        List<ProviderDTO> providers = providerService.findByClientId(-1L);

        //then
        Assertions.assertThat(providers).isNotNull().isEmpty();
    }

    @Test
    public void givenNullClientId_whenGetByClientId_thenReturnEmptyList() throws Exception {
        //when
        List<ProviderDTO> providers = providerService.findByClientId(null);

        //then
        Assertions.assertThat(providers).isNotNull().isEmpty();
    }

}
