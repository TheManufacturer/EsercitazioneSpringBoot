package com.example.interceptor02.interceptors;

import com.example.interceptor02.entities.Month;
import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {
    public static List<Month> months = new ArrayList<>(Arrays.asList(
            new Month(1, "January", "Gennaio", "Januar"),
            new Month(2, "February", "Febbraio", "Februar"),
            new Month(3, "March", "Marzo", "März"),
            new Month(4, "April", "Aprile", "April"),
            new Month(5, "May", "Maggio", "Mai"),
            new Month(6, "June", "Giugno", "Juni")
    )
    );
    @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            String monthIdString = request.getHeader("monthNumber");
            if (monthIdString == null) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return false;
            }
            long monthNumber = Long.parseLong(monthIdString);
            Optional<Month> month = months.stream().filter(singleMonth ->{
                return singleMonth.getMonthNumber() == monthNumber;
                    }).findFirst();

            if(month.isPresent()){
                request.setAttribute("month", month.get());
            }
            return true;
        }

        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        }

        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        }

}
