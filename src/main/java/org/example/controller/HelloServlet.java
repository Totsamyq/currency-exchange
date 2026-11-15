package org.example.controller;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {

            writer.println("<h2>Hello from HelloServlet</h2>");

        } finally {
            writer.close();
        }

    }

}

class DbCheck {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:sqlite:C:/Users/totsa/IdeaProjects/currency-exchange/src/main/resources/currency.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM Currencies")) {

            while (rs.next()) {
                System.out.println(rs.getInt("ID") + " " + rs.getString("Code"));
            }
        }
    }
}
