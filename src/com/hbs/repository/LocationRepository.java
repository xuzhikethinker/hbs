package com.hbs.repository;

import com.hbs.domain.support.Province;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 14-2-22.
 */
public interface LocationRepository  extends JpaRepository<Province, Long> {
}
