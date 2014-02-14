package com.hbs.service;

import java.util.List;

import com.hbs.domain.community.CommunityInfo;

/**
 * Created by XUZH on 12/30/13.
 */
public interface CommunityInfoService {
  public List<CommunityInfo> findCommunityListByLBCCode(String lbcCode);
  public List<CommunityInfo> findCommunityListByName(String name);
}
