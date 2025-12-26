package com.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class SimpleStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

       
        resp.setStatus(HttpServletResponse.SC_OK);

        
        try (PrintWriter writer = resp.getWriter()) {
            if (writer == null) {
                throw new IOException("Response writer is null");
            }
            writer.write("Digital Credential Verification Engine is running");
        }
    }
}
