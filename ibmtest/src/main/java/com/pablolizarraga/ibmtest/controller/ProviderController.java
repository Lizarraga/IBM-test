package com.pablolizarraga.ibmtest.controller;

import com.pablolizarraga.ibmtest.dto.ProviderDTO;
import com.pablolizarraga.ibmtest.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(ProviderController.ROOT_PATH)
public class ProviderController {

    public static final String ROOT_PATH = "/api/v1/providers";
    public static final String CLIENT_ID_PATH = "/client/{clientId}";

    private final ProviderService providerService;

    @GetMapping(CLIENT_ID_PATH)
    public List<ProviderDTO> getByClientId(@PathVariable Long clientId) {
        return providerService.findByClientId(clientId);
    }

}
