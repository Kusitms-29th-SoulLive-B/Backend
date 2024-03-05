package com.soullive_b.soullive_be.domain.model.service;

import com.soullive_b.soullive_be.domain.activity.repository.ActivityRepository;
import com.soullive_b.soullive_be.domain.advertisement.entity.Advertisement;
import com.soullive_b.soullive_be.domain.advertisement.repository.AdvertisementRepository;
import com.soullive_b.soullive_be.domain.issue.repository.IssueRepository;
import com.soullive_b.soullive_be.domain.keyword.entity.Keyword;
import com.soullive_b.soullive_be.domain.keyword.repository.KeywordRepository;
import com.soullive_b.soullive_be.domain.model.dto.request.ModelByKeywordRequest;
import com.soullive_b.soullive_be.domain.model.dto.response.ModelByKeywordResponse;
import com.soullive_b.soullive_be.domain.model.dto.response.ModelDetailResponse;
import com.soullive_b.soullive_be.domain.model.dto.response.ModelResponse;
import com.soullive_b.soullive_be.domain.model.entity.Model;
import com.soullive_b.soullive_be.domain.model.repository.ModelRepository;
import com.soullive_b.soullive_be.domain.modelkeyword.entity.ModelKeyword;
import com.soullive_b.soullive_be.domain.modelkeyword.repository.ModelKeywordRepository;
import com.soullive_b.soullive_be.domain.popularity.repository.PopularityRepository;
import com.soullive_b.soullive_be.exception.notfound.NotFoundKeywordException;
import com.soullive_b.soullive_be.exception.notfound.NotFoundModelException;
import com.soullive_b.soullive_be.exception.notfound.NotFoundPopularityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ModelService {
    private final ModelRepository modelRepository;
    private final IssueRepository issueRepository;
    private final ActivityRepository activityRepository;
    private final AdvertisementRepository advertisementRepository;
    private final PopularityRepository popularityRepository;
    private final ModelKeywordRepository modelKeywordRepository;
    private final KeywordRepository keywordRepository;

    public ModelDetailResponse getModelDtail(Long modelId) {
        Model model = modelRepository.findById(modelId)
                .orElseThrow(NotFoundModelException::new);
        return ModelDetailResponse.of(
                model,
                issueRepository.findAllByModelOrderByDateDesc(model),
                activityRepository.findAllByModelOrderByDateDesc(model),
                advertisementRepository.findAllByModelOrderByDateDesc(model),
                popularityRepository.findTopByModelOrderByScoreDesc(model)
                        .orElseThrow(NotFoundPopularityException::new),
                popularityRepository.findAllByModelOrderByScoreDesc(model)
        );
    }

    public List<ModelResponse> getModelList() {
        return modelRepository.findAll().stream()
                .map(m -> ModelResponse.of(
                        m,
                        popularityRepository.findTopByModelOrderByScoreDesc(m)
                                .orElseThrow(NotFoundPopularityException::new))
                )
                .toList();
    }

    public List<ModelByKeywordResponse> getModelsByKeyword(ModelByKeywordRequest modelByKeywordRequest) {
        Keyword keyword = keywordRepository.findByContent(modelByKeywordRequest.getKeyword())
                .orElseThrow(NotFoundKeywordException::new);
        List<Model> models = modelKeywordRepository.findAllByKeyword(keyword).stream()
                .map(ModelKeyword::getModel)
                .toList();
        List<ModelByKeywordResponse> ret = new ArrayList<>();
        for (Model model : models) {
            for (Advertisement advertisement : model.getAdvertisements())
                ret.add(ModelByKeywordResponse.of(model, advertisement));
        }
        Collections.sort(ret, (a, b) -> b.getDate().compareTo(a.getDate()));
        return ret;
    }
}
