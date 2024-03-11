package Ristorante.projectworkristorante.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Override
    public boolean adminLogin(String username, String password, HttpSession session) {
        return false;
    }
}
