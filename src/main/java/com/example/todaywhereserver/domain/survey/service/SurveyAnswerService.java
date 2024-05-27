package com.example.todaywhereserver.domain.survey.service;


import com.example.todaywhereserver.domain.survey.presentation.dto.request.SurveyAnswerRequest;
import com.example.todaywhereserver.domain.survey.presentation.dto.response.SurveyAnswerResponse;
import com.example.todaywhereserver.domain.travel.domain.Travel;
import com.example.todaywhereserver.domain.travel.domain.TravelRepository;
import com.example.todaywhereserver.domain.user.domain.User;
import com.example.todaywhereserver.domain.user.domain.repository.UserRepository;
import com.example.todaywhereserver.domain.user.facade.UserFacade;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class SurveyAnswerService {
    private final ChatgptService chatgptService;
    private final TravelRepository travelRepository;
    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Transactional
    public SurveyAnswerResponse execute(SurveyAnswerRequest request){
        StringBuilder prompt = new StringBuilder();

        for(String answers : request.getKeyword()) {
            prompt.append(answers);
            prompt.append(" ");
        }

        prompt.append("받은 각각의 단어들은 여행지를 추천받고자 하는 사람이 입력한 키워드 입니다. 받은 각각의 키워드들을 만족하는 대한민국 내의 실제로 존재하는 여행지 추천을 해주세요. 추천받을 여행지 개수는 1개입니다. 결과는 항상 여행지이름만 보내야 합니다. 또한 결과에는 줄넘김이 없어야 합니다. 여행지 이름 외의 설명과 같은 내용이 들어가서는 안됩니다. 글자 수 제한은 10자입니다.");
        String gptAnswer = chatgptService.sendMessage(prompt.toString());

        while(gptAnswer.isBlank() || gptAnswer.length() > 10 || gptAnswer.contains("[^가-힣\\s]+"))
            gptAnswer = chatgptService.sendMessage(prompt.toString());

        String name = gptAnswer.replaceAll("(여행지이름|여행지|\\n|\")", "");

        String gptContent = chatgptService.sendMessage(name + " 이 여행지에 대한 설명을 한글을 사용해 45자 이내로 해주세요.");

        while(gptContent.isBlank() || gptContent.contains("[^가-힣.,\\s]+"))
            gptContent = chatgptService.sendMessage(name + " 이 여행지에 대한 설명을 한글을 사용해 95자 이내로 해주세요.");

        String content = gptContent.replaceAll("\\n|\"", "");

        String gptAddress = chatgptService.sendMessage(name + " 한글로 이 여행지의 주소를 알려주세요. 주소 외에 다른 내용이 포함되지 않게 해주세요");

        while(gptAddress.isBlank() || gptAddress.contains("[^가-힣0-9\\s]+") || gptAddress.length() > 30)
            gptAddress = chatgptService.sendMessage(name + " 한글로 이 여행지의 주소를 알려주세요. 주소 외에 다른 내용이 포함되지 않게 해주세요");

        String address = gptAddress.replaceAll("\\n|\"|\\.", "");

        User user = userFacade.getCurrentUser();

        Travel travel = Travel.builder()
                .name(name)
                .content(content)
                .address(address)
                .build();

        travelRepository.save(travel);

        user.getTravel().add(travel);

        userRepository.save(user);

        return SurveyAnswerResponse.builder()
                .name(name)
                .content(content)
                .address(address)
                .build();
    }
}
