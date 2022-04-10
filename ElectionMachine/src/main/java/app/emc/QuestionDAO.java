package app.emc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
		
	private Connection conn;
	public QuestionDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/election_machine","penna","kukkuu");			
		
		}catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException  e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Question> getQuestions(){
	
		List<Question> questions = new ArrayList<>();
		try {
			String sql = "select * from questions order by question_id desc";
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()){
				Question newquestion = new Question();
				
				newquestion.setQuestion(rs.getString("question"));
				newquestion.setQuestionId(rs.getInt("question_id"));
				
				questions.add(newquestion);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return questions;
	}
	
	public void saveQuestion(Question question) {
		PreparedStatement stmt = null;
		try {
			String sql = "insert into questions(question) values (?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, question.getQuestion());
			stmt.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
