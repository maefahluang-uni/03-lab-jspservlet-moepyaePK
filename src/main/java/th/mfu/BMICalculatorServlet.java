package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet(urlPatterns = "/calbmi")
public class BMICalculatorServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO: get parameter from request: "weight" and "height"
        String weightInstring = request.getParameter("weight");
        String heightInstring = request.getParameter("height");
        response.setContentType("text/html");
        // TODO: calculate bmi

        double weight = Double.parseDouble(weightInstring);
        double height = Double.parseDouble(heightInstring);

        double result = weight / (height * height);
        int final_result = (int) Math.round(result);

        // TODO: determine the built from BMI
        String BMI_result;
        if (result < 18.5) {
            BMI_result = "underweight";
        } else if (18.5 <= result && result < 25) {
            BMI_result = "normal";
        } else if (25 <= result && result < 30) {
            BMI_result = "overweight";
        } else if (30 <= result && result < 35) {
            BMI_result = "obese";
        } else {
            BMI_result = "extremely obese";
        }

        // TODO: add bmi and built to the request's attribute

        request.setAttribute("BMI_result", BMI_result);
        request.setAttribute("final_result", final_result);
        

        // TODO: forward to jsp
        request.getRequestDispatcher("/bmi_result.jsp").forward(request, response);
    }

}
