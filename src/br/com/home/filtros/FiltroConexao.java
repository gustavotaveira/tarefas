package br.com.home.filtros;

import br.com.home.infra.ConnectionDataBaseFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class FiltroConexao implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        Connection connection = null;

        if (((HttpServletRequest) servletRequest).getMethod().equalsIgnoreCase("POST")) {
            connection = ConnectionDataBaseFactory.getPostgreSQLConnection();
            servletRequest.setAttribute("connection", connection);
        }

        filterChain.doFilter(servletRequest, servletResponse);

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {

    }
}
