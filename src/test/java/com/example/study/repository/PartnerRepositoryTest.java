package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Partner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class PartnerRepositoryTest extends StudyApplicationTests {

    @Autowired
    PartnerRepository partnerRepository;

    @Test
    public void create() {
        String name = "Partner01";
        String status = "Registered";
        String address = "서울시 강남구";
        String callCenter = "070-1111-1111";
        String partnerNumber = "010-2222-2222";
        String businessNumber = "123455667";
        String ceoName = "최성훈";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";
        Long categoryId = 1L;

        Partner partner = new Partner();
        partner.setName(name);
        partner.setStatus(status);
        partner.setAddress(address);
        partner.setCallCenter(callCenter);
        partner.setPartnerNumber(partnerNumber);
        partner.setBusinessNumber(businessNumber);
        partner.setCeoName(ceoName);
        partner.setRegisteredAt(registeredAt);
        partner.setCreatedAt(createdAt);
        partner.setCreatedBy(createdBy);
        // partner.setCategoryId(categoryId);

        Partner newPartner = partnerRepository.save(partner);

        Assertions.assertNotNull(newPartner);
        Assertions.assertEquals(newPartner.getName(), name);
    }

    @Test
    public void read() {
        // 생략
    }
}
