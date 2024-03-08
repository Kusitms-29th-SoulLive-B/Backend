package com.soullive_b.soullive_be.domain.usermodelselect.service;

import com.soullive_b.soullive_be.domain.model.entity.Model;
import com.soullive_b.soullive_be.domain.model.repository.ModelRepository;
import com.soullive_b.soullive_be.domain.user.entity.User;
import com.soullive_b.soullive_be.domain.user.repository.UserRepository;
import com.soullive_b.soullive_be.domain.usermodelselect.entity.UserModelSelect;
import com.soullive_b.soullive_be.domain.usermodelselect.repository.UserModelSelectRepository;
import com.soullive_b.soullive_be.exception.badrequest.BadRequestUserModelSelectException;
import com.soullive_b.soullive_be.exception.notfound.NotFoundModelException;
import com.soullive_b.soullive_be.exception.notfound.NotFoundSelectException;
import com.soullive_b.soullive_be.exception.notfound.NotFoundUserException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserModelSelectService {
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final UserModelSelectRepository userModelSelectRepository;

    public boolean checkDuplicateScrap(Long modelId, Long userId) {
        Model model = modelRepository.findById(modelId)
                .orElseThrow(NotFoundModelException::new);
        User user = userRepository.findById(userId)
                .orElseThrow(NotFoundUserException::new);

        return userModelSelectRepository.existsByModelAndUser(model, user);
    }

    public void createScrap(Long modelId, Long userId) {
        if(checkDuplicateScrap(modelId, userId)) {
            throw new BadRequestUserModelSelectException();
        }

        Model model = modelRepository.findById(modelId)
                .orElseThrow(NotFoundModelException::new);
        User user = userRepository.findById(userId)
                .orElseThrow(NotFoundUserException::new);

        UserModelSelect userModelSelect = UserModelSelect.builder()
                .model(model)
                .user(user)
                .build();

        userModelSelectRepository.save(userModelSelect);
    }

    public void cancelScrap(Long modelId, Long userId) {
        if(!checkDuplicateScrap(modelId, userId)) {
            throw new NotFoundSelectException();
        }

        Model model = modelRepository.findById(modelId)
            .orElseThrow(NotFoundModelException::new);
        User user = userRepository.findById(userId)
                .orElseThrow(NotFoundUserException::new);

        UserModelSelect userModelSelect = userModelSelectRepository.findByModelAndUser(model, user);

        userModelSelectRepository.delete(userModelSelect);
    }

}
