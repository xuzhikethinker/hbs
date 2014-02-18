package com.hbs.repository;

import com.hbs.domain.service.consumer.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 14-2-18.
 */
public interface ConsumerRepository  extends JpaRepository<Consumer, Long> {
}
