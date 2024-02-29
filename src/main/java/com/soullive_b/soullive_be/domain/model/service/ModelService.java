package com.soullive_b.soullive_be.domain.model.service;

import com.soullive_b.soullive_be.domain.activity.repository.ActivityRepository;
import com.soullive_b.soullive_be.domain.advertisement.repository.AdvertisementRepository;
import com.soullive_b.soullive_be.domain.issue.repository.IssueRepository;
import com.soullive_b.soullive_be.domain.model.dto.response.ModelDetailResponse;
import com.soullive_b.soullive_be.domain.model.entity.Model;
import com.soullive_b.soullive_be.domain.model.repository.ModelRespository;
import com.soullive_b.soullive_be.domain.popularity.repository.PopularityRepository;
import com.soullive_b.soullive_be.exception.notfound.NotFoundModelException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ModelService {
    private final ModelRespository modelRepository;
    private final IssueRepository issueRepository;
    private final ActivityRepository activityRepository;
    private final AdvertisementRepository advertisementRepository;
    private final PopularityRepository popularityRepository;

    public ModelDetailResponse getModelDtail(Long modelId) {
        Model model = modelRepository.findById(modelId)
                .orElseThrow(NotFoundModelException::new);

        return ModelDetailResponse.of(
                model,
                model.getKeywords(),
                issueRepository.findAllByModelOrderByDateDesc(model),
                activityRepository.findAllByModelOrderByDateDesc(model),
                advertisementRepository.findAllByModelOrderByDateDesc(model),
                popularityRepository.findAllByModelOrderByScoreDesc(model)
        );
    }
}
