package com.example.spring2lab.service;

import com.example.spring2lab.model.Request;
import org.springframework.stereotype.Service;

@Service
public interface ModifyRequestService {
    void modify (Request request);
}