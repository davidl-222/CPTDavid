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
			con.println();
			
			TextInputFile themes = new TextInputFile("themes.txt");
			while (themes.eof() == false) {
				String strTheme = themes.readLine();
				con.println(strTheme);
			}
			con.println("What theme do you want to play?");
			String strPlayTheme = con.readLine();
			con.clear();
			
			String[][] strWords = new String[14][2];
			if (strPlayTheme.equalsIgnoreCase("baseball")) {
				TextInputFile baseball = new TextInputFile("baseball.txt");
				for (int intCount = 0; intCount < 14; intCount++) {
					strWords[intCount][0] = baseball.readLine();
					strWords[intCount][1] = "" + (int) (Math.random() * 100 + 1);
				}
			}
			String strTempName;
			String strTempNum;
			for (int intCount = 0; intCount < 13; intCount++) {
				for (int i = 0; i < 13 - intCount; i++) {
					if (Integer.parseInt(strWords[i][1]) > Integer.parseInt(strWords[i+1][1])) {
						strTempName = strWords[i][0];
						strTempNum = strWords[i][1];
						strWords[i][0] = strWords[i+1][0];
						strWords[i][1] = strWords[i+1][1];
						strWords[i+1][0] = strTempName;
						strWords[i+1][1] = strTempNum;
					}
				}
			}
			String strSecret = strWords[0][0];
			char[] scramble = new char[strSecret.length()];
			
			
		}
	}
}
