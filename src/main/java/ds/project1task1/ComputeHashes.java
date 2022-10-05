package ds.project1task1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Author: Changzhou (Channing) Zheng (changzhz)
 * Last Modified: September 24, 2022
 *
 * This program will convert any user inputs to a hash code and a base 64 notation in two modes:
 * MD5 and SHA-256
 * Either way will have a hash and notation.
 */

@WebServlet(name = "ComputerHashes", urlPatterns = {"/input"})
public class ComputeHashes extends HttpServlet {
    private String message;

    public void init() {
        message = "Get Hashes!";
    }

    /**
     This method is used to generate Hex Binary code for the user's inputs.
     Utilizes javax.xml.bind.DatatypeConverter.printHexBinary to get Hex Binary values in any of the two modes.
     */
    public static String getHexBinary(String inputStr, String hashMode)  throws NoSuchAlgorithmException {

        // Generate MessageDigest object to store hashing strings
        MessageDigest instance = MessageDigest.getInstance(hashMode);
        instance.update(inputStr.getBytes());
        instance.reset();
        byte[] helloArray = instance.digest(inputStr.getBytes(StandardCharsets.UTF_8));

        // Create HexBinary output
        String hexBinary = DatatypeConverter.printHexBinary(helloArray);

        return hexBinary;
    }

    /**
     This method is used to generate Base 64 Binary code for the user's inputs.
     Utilizes javax.xml.bind.DatatypeConverter.printBase64Binary to get Base 64 Binary result.
     */
    public static String getBase64(String inputStr, String hashMode)  throws NoSuchAlgorithmException {

        // Generate MessageDigest object to store hashing strings
        MessageDigest instance = MessageDigest.getInstance(hashMode);
        instance.update(inputStr.getBytes());
        instance.reset();
        byte[] helloArray = instance.digest(inputStr.getBytes(StandardCharsets.UTF_8));

        //Create Base64Binary output
        String base64 = DatatypeConverter.printBase64Binary(helloArray);

        return base64;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Get and store user's input as a String
        String input = request.getParameter("anyInput");

        String hashMode = request.getParameter("hashMode");

        String hashOutput;
        String base64Output;
        try {
            // Convert user input to Hex Binary code
            hashOutput = ComputeHashes.getHexBinary(input, hashMode);

            // Convert user input to Base 64 code
            base64Output = ComputeHashes.getBase64(input, hashMode);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("finalHashMode", hashOutput);
        request.setAttribute("finalBase64", base64Output);

        RequestDispatcher nextStep = request.getRequestDispatcher("output.jsp");
        nextStep.forward(request, response);
    }
}
