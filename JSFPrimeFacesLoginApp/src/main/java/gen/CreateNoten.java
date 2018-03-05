package gen;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CreateNoten {
	public static void main( String[ ] args ) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "LoginAppDB" );

		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );

		NotenEntity ne = new NotenEntity( );
		ne.setNote(3.5);
		ne.setMatriculationNumber("1234567");
		ne.setStudentName("Mert Yucel");
		ne.setLecture("Grundlagen der Informatik");

		entitymanager.persist( ne );
		entitymanager.getTransaction( ).commit( );

		entitymanager.close( );
		emfactory.close( );
	}
}
