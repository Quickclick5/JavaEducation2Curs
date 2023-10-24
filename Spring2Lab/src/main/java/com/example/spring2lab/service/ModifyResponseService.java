package com.example.spring2lab.service;

import com.example.spring2lab.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ModifyResponseService {
    Response modify(Response response);
}