package com.hbs.repository;

import com.hbs.domain.community.CommunityInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by XUZH on 12/30/13.
 */
public interface CommunityInfoRepository extends JpaRepository<CommunityInfo, Long> {
  //@Query("select c from CommunityInfo c where c.ownerLifeBusinessCircle.circleCode=?")
  public List<CommunityInfo> findCommunityListByLBCCode(String lbcCode);
  public List<CommunityInfo> findCommunityListByName(String name);
  public List<CommunityInfo> findCommunityListByAddress(String address);
  public List<CommunityInfo> findCommunityList(String keywords);
}
