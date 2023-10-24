package com.example.spring2lab.service;

import com.example.spring2lab.model.Request;
import com.example.spring2lab.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
@Qualifier("ModifySystemTimeRequestService")
public class ModifySystemTimeRequestService implements ModifyRequestService {
    @Override
    public void modify(Request request){
        request.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        new RestTemplate().exchange("http://localhost:8084/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>() {
                });
    }
}