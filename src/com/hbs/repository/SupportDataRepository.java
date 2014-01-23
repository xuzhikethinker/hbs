package com.hbs.repository;

import com.hbs.domain.support.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupportDataRepository extends JpaRepository<Province, Long> {
}
