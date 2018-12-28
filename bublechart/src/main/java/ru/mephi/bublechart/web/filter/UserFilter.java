package ru.mephi.bublechart.web.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mephi.bublechart.repository.UserRepository;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class UserFilter implements Filter {

    private final UserRepository userRepository;

    @Autowired
    public UserFilter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (request.getMethod().equals("OPTIONS")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String requestURI = request.getRequestURI();
        if (!requestURI.startsWith("/bubble/")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        String role = userRepository.findRoleByToken(request.getHeader("Authorization"));

        if (role == null || !role.equals("USER")) {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String name = userRepository.findRoleNameByToken(request.getHeader("Authorization"));
        request.setAttribute("name", name);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
