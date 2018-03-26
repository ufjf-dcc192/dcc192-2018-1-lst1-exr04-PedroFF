/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufjf.br.dcc192;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "JurosCompostos", urlPatterns = {"/juros.html"})
public class JurosCompostos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        double valInicial;
        if(request.getParameter("val-inicial")!= null && !"".equals(request.getParameter("val-inicial"))){
            valInicial = Double.parseDouble(request.getParameter("val-inicial"));
        } else{ valInicial = 5000.0;}
        double taxa;
        if(request.getParameter("taxa")!= null && !"".equals(request.getParameter("taxa"))){
            taxa = Double.parseDouble(request.getParameter("taxa"))/100;
        }else{taxa = 1/100;}
        int meses;
            if(request.getParameter("meses")!= null && !"".equals(request.getParameter("meses"))){
                 meses = Integer.parseInt(request.getParameter("meses"));
        }else{meses = 12;}
        double valorFinal = valInicial*(Math.pow(1+taxa, meses));
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Juros Compostos</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Juros Compostos </h1>");
        out.println("<form>");
        out.println("<label> Valor Inicial: <input name='val-inicial' /></label></br>");
        out.println("<label> Meses: <input name='meses' /></label></br>");
        out.println("<label> Taxa de Juros: <input name='taxa' /></label></br>");
        out.println("<input type='submit' />");
        out.println("<input type='reset' />");
        out.println("</form>");
        out.println("<p>Para um investimento inicial de R$"+valInicial+" a uma taxa de juros compostos de "+taxa*100+"% ao mês,"
                + " você terá R$"+valorFinal+" ao final de "+meses+" meses!</p>");
        if((valorFinal-valInicial)/meses >200){
            out.println("<p style='color:Green'>Bom Negócio!</p>");
        }else{
            out.println("<p style='color:Red'>Mau Negócio!</p>");
        }
        out.println("</body>");
        out.println("</html>");
    }

}
