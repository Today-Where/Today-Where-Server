package com.example.todaywhereserver.domain.survey.service;


import com.example.todaywhereserver.domain.survey.presentation.dto.request.SurveyAnswerRequest;
import com.example.todaywhereserver.domain.travel.domain.Travel;
import com.example.todaywhereserver.domain.travel.domain.TravelRepository;
import com.example.todaywhereserver.domain.user.domain.User;
import com.example.todaywhereserver.domain.user.domain.repository.UserRepository;
import com.example.todaywhereserver.domain.user.facade.UserFacade;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@RequiredArgsConstructor
@Service
public class SurveyAnswerService {
    private final ChatgptService chatgptService;
    private final TravelRepository travelRepository;
    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Transactional
    public List<String> execute(SurveyAnswerRequest request){
        StringBuilder prompt = new StringBuilder();

        for(String answers : request.getKeyword()) {
            prompt.append(answers);
            prompt.append(" ");
        }

        prompt.append("받은 각각의 단어들은 여행지를 추천받고자 하는 사람이 입력한 키워드 입니다. 받은 각각의 키워드들을 모두 만족하는 대한민국 내의 실제로 존재하는 여행지 추천을 해주세요. 추천받을 여행지 개수는 1개 이상, 5개 이하입니다. 결과는 항상 여행지이름, 여행지이름, 여행지이름... , 여행지이름 형식이여야 합니다 각각의 여행지를 , 로 나누어 주세요. 또한 결과에는 줄넘김이 없어야 합니다. 주어진 형식 외의 설명과 같은 내용이 들어가서는 안됩니다. 글자 수 제한은 35자입니다.");
        String gptAnswer = chatgptService.sendMessage(prompt.toString());
        while(gptAnswer.isBlank() || gptAnswer.length() > 40 || gptAnswer.length() < 10 || gptAnswer.contains("[^가-힣,\\s]+") || !gptAnswer.contains(",")) gptAnswer = chatgptService.sendMessage(prompt.toString());

        List<String> travelList = Arrays.stream(gptAnswer.replaceAll("(여행지이름|여행지|\\n|\")", "").trim().split(", "))
                .filter(travel -> travel.length() <= 9)
                .toList();

        User user = userFacade.getCurrentUser();
        for(String travels : travelList) {
            Travel travel = Travel.builder()
                    .name(travels)
                    .build();

            travelRepository.save(travel);

            user.getTravel().add(travel);

            userRepository.save(user);
        }

        return travelList;
    }
}
