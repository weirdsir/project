package app.emc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListQuestionsServlet
 */
@WebServlet(name = "listquestions", urlPatterns = { "/listquestions" })
public class ListQuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListQuestionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionDAO questiondao = new QuestionDAO();
		//Get Question from Dao
		List<Question> questions = questiondao.getQuestions();
		
		//Add question to the request
		request.setAttribute("Questions", questions);
		
		//Send data to JSP view
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/listquestions.jsp");
		dispatcher.forward(request, response);
	}

	

}
