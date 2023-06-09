package com.pablolizarraga.ibmtest.repository;

import com.pablolizarraga.ibmtest.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

    List<Provider> findByClientId(Long clientId);
}
