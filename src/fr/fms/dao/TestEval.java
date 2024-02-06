package fr.fms.dao;

import fr.fms.entities.Stage;

public class TestEval {

	public static void main(String[] args) 
	{
		ArticleDao artdao = new ArticleDao();
		
		Stage st = new Stage("js", "jvcrpt", 1500, "remote", 10);
		artdao.update(st, 7);
		artdao.delete(6);
		artdao.readAll();
	}

}
