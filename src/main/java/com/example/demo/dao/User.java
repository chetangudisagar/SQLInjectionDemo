package com.example.demo.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String username;
    private String Password;
}