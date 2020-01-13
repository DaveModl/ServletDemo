package com.login.exec.controller;





import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.*;

@WebServlet(name = "CountsServlet",urlPatterns = "/counts",loadOnStartup = 1)
public class CountsServlet extends HttpServlet {
    @Override
    public void init() {
        String path = this.getServletContext().getRealPath("/counts/counts.txt");
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String counts = bufferedReader.readLine();
            System.out.println(counts);
            this.getServletContext().setAttribute("counts",counts);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("service destroy");
        String counts =String.valueOf((int) this.getServletContext().getAttribute("counts"));
        String path = this.getServletContext().getRealPath("/counts/counts.txt");
        System.out.println(path);
        //写入文件
        BufferedWriter bufferedwriter = null;
        try {
            bufferedwriter = new BufferedWriter(new FileWriter(path));
            bufferedwriter.write(counts);
            System.out.println(counts);
            bufferedwriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedwriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
