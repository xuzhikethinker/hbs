package com.hbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hbs.domain.community.CommunityInfo;

/**
 * Created by XUZH on 12/30/13.
 */
public interface CommunityInfoRepository extends JpaRepository<CommunityInfo, Long> {
  @Query("select c from CommunityInfo c where c.ownerLifeBusinessCircle.circleCode=?")
  public List<CommunityInfo> findCommunityListByLBCCode(String lbcCode);
  public List<CommunityInfo> findCommunityListByName(String name);
  public List<CommunityInfo> findCommunityListByAddress(String address);
  public List<CommunityInfo> findCommunityList(String keywords);
}
