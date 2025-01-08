import arc.*;

public class FinalCPTDavid {
	public static void main(String[] args) {
		Console con = new Console();
		con.println("Press p to Play");
		con.println();
		con.println("Press s to View High Score");
		con.println();
		con.println("Press q to Quit");
		con.println();
		con.println("Press h for Help");
		con.println();
		
		char chrChoice = con.readChar();
		if (chrChoice == 'p') {
			con.clear();
			con.println("What is your name?");
			String strName = con.readLine();
			
			TextInputFile themes = new TextInputFile("themes.txt");
			while (themes.eof() == false) {
				String strTheme = themes.readLine();
				con.println(strTheme);
			}
			con.println("What theme do you want to play?");
			String strPlayTheme = con.readLine();
			
		}
	}
}
