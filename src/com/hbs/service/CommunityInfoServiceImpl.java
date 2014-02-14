package com.hbs.service;

import com.hbs.domain.community.CommunityInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("communityInfoService")
public class CommunityInfoServiceImpl extends AbstractBaseService implements CommunityInfoService {

//  @Autowired
//  CommunityInfoRepository communityInfoRepository;

  @Override
  public List<CommunityInfo> findCommunityListByLBCCode(String lbcCode) {
   // return communityInfoRepository.findCommunityListByLBCCode(lbcCode);
      return null;
  }

  @Override
  public List<CommunityInfo> findCommunityListByName(String name) {
//    EasyCriteria<CommunityInfo> easyCriteria = EasyCriteriaFactory.createQueryCriteria(this.getEntityManager(), CommunityInfo.class);
//    easyCriteria.getResultList();
//    return communityInfoRepository.findCommunityListByName(name);
      return null;
  }

}
