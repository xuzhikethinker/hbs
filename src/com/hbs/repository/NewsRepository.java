package com.hbs.repository;

import com.hbs.domain.common.News;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 14-2-22.
 */
public interface NewsRepository extends JpaRepository<News, Long> {
}
