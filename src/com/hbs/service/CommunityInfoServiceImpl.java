package com.hbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbs.domain.community.CommunityInfo;
import com.hbs.repository.CommunityInfoRepository;
import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;

@Service("communityInfoService")
public class CommunityInfoServiceImpl extends AbstractBaseService implements CommunityInfoService {

  @Autowired
  CommunityInfoRepository communityInfoRepository;

  @Override
  public List<CommunityInfo> findCommunityListByLBCCode(String lbcCode) {
    return communityInfoRepository.findCommunityListByLBCCode(lbcCode);
  }

  @Override
  public List<CommunityInfo> findCommunityListByName(String name) {
    EasyCriteria<CommunityInfo> easyCriteria = EasyCriteriaFactory.createQueryCriteria(this.getEntityManager(), CommunityInfo.class);
    easyCriteria.getResultList();
    return communityInfoRepository.findCommunityListByName(name);
  }

}
