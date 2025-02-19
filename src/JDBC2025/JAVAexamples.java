package JDBC2025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JAVAexamples {

	/**
	 * @param args
	 */
	static Connection minConnection;
	static Statement stmt;
	static BufferedReader inLine;

	public static void selectudenparm() {
	try {
		// Laver sql-sætning og får den udført
		String sql = "select navn,stilling from person";
		System.out.println("SQL-streng er "+sql);
		ResultSet res=stmt.executeQuery(sql);
		// gennemløber svaret
		while (res.next()) {
			String s;
			s = res.getString("navn");
			System.out.println(s + "    " + res.getString(2));
		}
		// pæn lukning
 		if (!minConnection.isClosed()) minConnection.close();
		}
		catch (Exception e) {
			System.out.println("fejl:  "+e.getMessage());
		}
	}

	public static void selectmedparm() {
	try {
		// Indlæser søgestreng
		System.out.println("Indtast søgestreng");
		String inString = inLine.readLine();
		// Laver sql-sætning og får den udført
		String sql = "select navn,stilling from person where navn like '" + inString + "%'";
		System.out.println("SQL-streng er "+ sql);
		ResultSet res=stmt.executeQuery(sql);
		//gennemløber svaret
		while (res.next()) {
			System.out.println(res.getString(1) + "    " + res.getString(2));
		}
		// pæn lukning
 		if (!minConnection.isClosed()) minConnection.close();
		}
		catch (Exception e) {
			System.out.println("fejl:  "+e.getMessage());
		}
	}

	public static void insertmedstring() {
		try {
			// indlæsning
			System.out.println("Vi vil nu oprette et nyt ansættelsesfforhold");
			System.out.println("Indtast cpr (personen skal være oprettet på forhånd");
			String cprstr=inLine.readLine();
			System.out.println("Indtast firmanr (firma skal være oprettet på forhånd");
			String firmastr=inLine.readLine();

			// sender insert'en til db-serveren
			String sql = "insert into ansati values ('" + cprstr + "'," + firmastr + ")";
			System.out.println("SQL-streng er "+ sql);
			stmt.execute(sql);
			// pænt svar til brugeren
			System.out.println("Ansættelsen er nu registreret");
			if (!minConnection.isClosed()) minConnection.close();
		}
		catch (SQLException e) {
			        switch (e.getErrorCode())
			        // fejl-kode 547 svarer til en foreign key fejl
			        { case 547 : {if (e.getMessage().contains("cprforeign"))
										System.out.println("cpr-nummer er ikke oprettet");
			        			  else
			        			  if (e.getMessage().contains("firmaforeign"))
										System.out.println("firmaet er ikke oprettet");
			        			  else
			        				    System.out.println("ukendt fremmednøglefejl");
								  break;
			        			}
			        // fejl-kode 2627 svarer til primary key fejl
			          case 2627: {System.out.println("den pågældende ansættelse er allerede oprettet");
			          	          break;
			         			 }
			          default: System.out.println("fejlSQL:  "+e.getMessage());
				};
		}
		catch (Exception e) {
			System.out.println("fejl:  "+e.getMessage());
		}
	};

	public static void insertprepared() {
		try {
			// indl�sning
			System.out.println("Vi vil nu oprette et nyt ansættelsesforhold");
			System.out.println("Indtast cpr (personen skal være oprettet på forhånd");
			String cprstr=inLine.readLine();
			System.out.println("Indtast firmanr (firma skal være oprettet på forhånd");
			String firmastr=inLine.readLine();
			// Anvendelse af prepared statement
			String sql = "insert into ansati values (?,?)";
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();
			prestmt.setString(1,cprstr);
			prestmt.setInt(2,Integer.parseInt(firmastr));
			// Udf�rer s�tningen
			prestmt.execute();
			// p�nt svar til brugeren
			System.out.println("Ansættelsen er nu registreret");
			if (!minConnection.isClosed()) minConnection.close();
		}
		catch (SQLException e) {
			        switch (e.getErrorCode())
			        // fejl-kode 547 svarer til en foreign key fejl
			        { case 547 : {if (e.getMessage().contains("cprforeign"))
									  System.out.println("cpr-nummer er ikke oprettet");
			        			  else
			        			  if (e.getMessage().contains("firmaforeign"))
						              System.out.println("firmaet er ikke oprettet");
			        			  else
			        				  System.out.println("ukendt fremmednøglefejl");
								  break;
			        			}
			        // fejl-kode 2627 svarer til primary key fejl
			          case 2627: {System.out.println("den pågældende ansættelse er allerede oprettet");
			          	          break;
			         			 }
			          default: System.out.println("fejlSQL:  "+e.getMessage());
				};
		}
		catch (Exception e) {
			System.out.println("fejl:  "+e.getMessage());
		}
	};
	public static void udskriv(){
		try{
			String sqlInit = inLine.readLine();
			String sql = "select init, aarstal, plac from placering where init like  '" + sqlInit + "%'";
			System.out.println("SQL-streng er "+ sql);
			ResultSet res=stmt.executeQuery(sql);
			//gennemløber svaret
			while (res.next()) {
				if(res.getString(3) == null){
					System.out.println(res.getString(1) + "      " + res.getString(2) + "      " + "udgået");
				}else System.out.println(res.getString(1) + "    " + res.getString(2) + "         " + res.getString(3));
			}


			// pæn lukning
			if (!minConnection.isClosed()) minConnection.close();

		}catch (Exception e) {
			System.out.println("fejl:  "+e.getMessage());

		}
	}

	public static void year2024(){
		int year  =2024;
		try{
// indlæsning
			System.out.println("vi vil nu indsætte resultater for 2024");
			System.out.println("Indtast rytterinit (rytter skal være oprettet på forhånd");
			String init=inLine.readLine();
			System.out.println("indtast resultat");
			String initResult=inLine.readLine();

			// sender insert'en til cykelrytter-serveren
			String sql = "insert into placering values (2024,'"  + init + "'," + initResult + ")";
			System.out.println("SQL-streng er "+ sql);
			stmt.execute(sql);
			// pænt svar til brugeren
			System.out.println("resultater er nu registreret");
			if (!minConnection.isClosed()) minConnection.close();

		}catch (SQLException e) {
			switch (e.getErrorCode())
			// fejl-kode 547 svarer til en foreign key fejl
			{ case 547 : {if (e.getMessage().contains("initforeign"))
				System.out.println("rytterinitialer er ikke oprettet");
			else
			if (e.getMessage().contains("aarstalforeign"))
				System.out.println("aarstal er ikke oprettet");
			else
				System.out.println("ukendt fremmednøglefejl");
				break;
			}
			// fejl-kode 2627 svarer til primary key fejl
				case 2627: {System.out.println("cykelrytterposition er allerede oprettet");
					break;
				}
				default: System.out.println("fejlSQL:  "+e.getMessage());
			};
		}
		catch (Exception e) {
			System.out.println("fejl:  "+e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			inLine = new BufferedReader(new InputStreamReader(System.in));
			//generel opsætning
			//via native driver
			String server="localhost\\SQLEXPRESS"; //virker måske hos dig
			                                       //virker det ikke - prøv kun med localhost
			String dbnavn="cykelrytter";            //virker måske hos dig
			String login="sa";                     //skal ikke ændres
			String password="torben07";            //skal ændres
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			minConnection = DriverManager.getConnection("jdbc:sqlserver://"+server+";databaseName="+dbnavn+
					";user=" + login + ";password=" + password + ";");
			//minConnection = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=eksempeldb;user=sa;password=torben07;");
			stmt = minConnection.createStatement();
			//Indlæsning og kald af den rigtige metode
			System.out.println("Indtast  ");
			System.out.println("s for select uden parameter  ");
			System.out.println("sp for select med parameter  ");
			System.out.println("i for insert med strengmanipulation");
			System.out.println("ps for insert med prepared statement ");
			System.out.println("u for udskriv");
			System.out.println("år for 2024Udskriv");
			String in=inLine.readLine();
			switch (in)
			{case "s"  : {selectudenparm();break;}
			 case "sp" : {selectmedparm();break;}
			 case "i"  : {insertmedstring();break;}
			 case "ps"  : {insertprepared();break;}
				case "u" : {udskriv();break;}
				case "år" :{year2024();break;}
			default : System.out.println("ukendt indtastning");
			}
		}
		catch (Exception e) {
			System.out.println("fejl:  "+e.getMessage());
		}
	}


}

