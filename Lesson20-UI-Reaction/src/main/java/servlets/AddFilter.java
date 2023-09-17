package servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
@WebFilter("/add")
public class AddFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        List<String> spaces = parameterMap.entrySet().stream()
                .flatMap(entry -> Arrays.stream(entry.getValue()))
                .filter(String::isEmpty)
                .toList();

        if(spaces.isEmpty()){
            chain.doFilter(request,response);
        }
        else{
            request.getRequestDispatcher("/home").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
