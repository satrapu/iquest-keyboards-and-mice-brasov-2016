package ro.satrapu.iqkm.demo.persons;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "DemoEndpoint", urlPatterns = {"/"})
public class DemoEndpoint extends HttpServlet {
    @Inject
    private PersonPersistenceService personPersistenceService;

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new ServletException(new UnsupportedOperationException("POST verb not supported"));
    }

    /**
     * Processes HTTP requests.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.println("<!DOCTYPE html>");
            printWriter.println("<html>");
            printWriter.println("<head>");
            printWriter.println("<title>iQuest Keyboards & Mice - Brașov - 2016 - Persons Demo</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("<h1>DemoEndpoint</h1>");

            writeInfo(getRequestInfo(request), printWriter);
            writePersons(personPersistenceService.getPersons(), printWriter);

            printWriter.println("</body>");
            printWriter.println("</html>");
        }
    }

    /**
     * Extracts info out of a given {@link HttpServletRequest} instance.
     *
     * @param request THe HTTP request containing information.
     * @return A map containing info related to the given request.
     */
    private Map<String, Object> getRequestInfo(HttpServletRequest request) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("Server IP", request.getLocalAddr());
        result.put("Server name", request.getLocalName());
        result.put("Server port", request.getLocalPort());
        result.put("Server Java version", System.getProperty("java.version"));
        result.put("Client IP", request.getRemoteAddr());
        result.put("Client name", request.getRemoteHost());
        result.put("Request URI", request.getRequestURI());
        result.put("Request method", request.getMethod());
        result.put("Current date", DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now()));

        return result;
    }

    /**
     * Writes a map using a given {@link PrintWriter} instance.
     *
     * @param info        The map to be written.
     * @param printWriter The {@link PrintWriter} used for writing.
     */
    private void writeInfo(Map<String, Object> info, PrintWriter printWriter) {
        printWriter.println("<h2>Request info</h2>");
        printWriter.println("<ul>");

        for (String key : info.keySet()) {
            Object value = info.get(key);

            printWriter.println("<li>");
            printWriter.println(String.format("%s: %s", key, value));
            printWriter.println("</li>");
        }

        printWriter.println("</ul>");
        printWriter.println("</h2>");
    }

    /**
     * Writes a list of {@link Person} entities using a given {@link PrintWriter} instance.
     *
     * @param persons     The entities to be written.
     * @param printWriter The {@link PrintWriter} used for writing.
     */
    private void writePersons(List<Person> persons, PrintWriter printWriter) {
        printWriter.println("<h2>Database records</h2>");

        printWriter.println("<table>");

        printWriter.println("<thead>");
        printWriter.println("<td>ID</td>");
        printWriter.println("<td>Person Name</td>");
        printWriter.println("</thead>");

        printWriter.println("<tbody>");

        for (Person person : persons) {
            printWriter.println("<tr>");

            printWriter.println(String.format("<td>%d</td>", person.getId()));
            printWriter.println(String.format("<td>%s %s %s</td>",
                    person.getFirstName(), person.getMiddleName(), person.getLastName()));

            printWriter.println("</tr>");
        }

        printWriter.println("</tbody>");

        printWriter.println("</table>");

        printWriter.println("</h2>");
    }
}