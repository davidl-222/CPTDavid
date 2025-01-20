import arc.*;

public class FinalCPTDavid {
	public static void main(String[] args) {
		Console con = new Console();
		boolean blnQuitGame = false;
		TextOutputFile highscore = new TextOutputFile("highscore.txt");
		while (blnQuitGame == false) {
			con.clear();
			con.println("Press p to Play");
			con.println();
			con.println("Press s to View High Score");
			con.println();
			con.println("Press q to Quit");
			con.println();
			con.println("Press h for Help");
			con.println();
			
			char chrChoice = con.readChar();
			boolean blnQuit = false;
			int intScore = 0;
			if (chrChoice == 'p') {
				con.clear();
				con.println("What is your name?");
				String strName = con.readLine();
				con.println();
				
				while (blnQuit == false) {
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
					} else if (strPlayTheme.equalsIgnoreCase("skiing")) {
						TextInputFile skiing = new TextInputFile("skiing.txt");
						for (int intCount = 0; intCount < 14; intCount++) {
							strWords[intCount][0] = skiing.readLine();
							strWords[intCount][1] = "" + (int) (Math.random() * 100 + 1);
						}
					} else if (strPlayTheme.equalsIgnoreCase("foods")) {
						TextInputFile foods = new TextInputFile("foods.txt");
						for (int intCount = 0; intCount < 14; intCount++) {
							strWords[intCount][0] = foods.readLine();
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
					String strScrambled = "";
					int intLength = strSecret.length();
					String[][] scramble = new String[intLength][2];
					for (int intCount = 0; intCount < intLength; intCount++) {
						scramble[intCount][0] = strSecret.substring(intCount, intCount+1);
						scramble[intCount][1] = "" + (int) (Math.random() * 100 + 1);
					}
					String strTemp;
					String strTemp2;
					for (int intCount = 0; intCount < intLength - 1; intCount++) {
						for (int i = 0; i < intLength - 1 - intCount; i++) {
							if (Integer.parseInt(scramble[i][1]) > Integer.parseInt(scramble[i+1][1])) {
								strTemp = scramble[i][0];
								strTemp2 = scramble[i][1];
								scramble[i][0] = scramble[i+1][0];
								scramble[i][1] = scramble[i+1][1];
								scramble[i+1][0] = strTemp;
								scramble[i+1][1] = strTemp2;
							}
						}
					}
					for (int intCount = 0; intCount < intLength; intCount++) {
						strScrambled += scramble[intCount][0];
					}
					
					for (int intCount = intLength - 4; intCount >= 0; intCount--) {
						con.println(strScrambled);
						con.println();
						con.println(intCount + " tries remaining");
						con.println();
						if (intCount == 0) {
							con.println("You didn't guess the word right");
							con.println("The word was: " + strSecret);
							con.println("Do you want to PLAY AGAIN or QUIT?");
							String strChoice = con.readLine();
							if (strChoice.equalsIgnoreCase("PLAY AGAIN")) {
								con.clear();
								break;
							}
							else {
								highscore.println(intScore + " " + strName);
								blnQuit = true;
								con.clear();
								break;
							}
						}
						String strGuess = con.readLine();
						con.println();
						if (strGuess.equalsIgnoreCase(strSecret)) {
							con.println("You got the word right!");
							intScore++;
							con.println("Do you want to PLAY AGAIN or QUIT?");
							String strChoice = con.readLine();
							if (strChoice.equalsIgnoreCase("PLAY AGAIN")) {
								con.clear();
								break;
							}
							else {
								highscore.println(intScore + " " + strName);
								blnQuit = true;
								con.clear();
								break;
							}
						} else {
							con.clear();
						}
					}
				}
			}
			else if (chrChoice == 'q') System.exit(0);
			else if (chrChoice == 's') {
				con.clear();
				int intLength = 0;
				TextInputFile viewscore = new TextInputFile("highscore.txt");
				while (viewscore.eof() == false) {
					String strScore = viewscore.readLine();
					intLength++;
				}
				String[] ordered = new String[intLength];
				for (int intCount = 0; intCount < intLength; intCount++) {
					ordered[intCount] = viewscore.readLine();
				}
				String strScoreTemp;	
				for (int intCount = 0; intCount < intLength - 1; intCount++) {
					char chrFirst = ordered[intCount].charAt(0);
					char chrSecond = ordered[intCount+1].charAt(0);
					if (chrFirst < chrSecond) {
						strScoreTemp = ordered[intCount];
						ordered[intCount] = ordered[intCount+1];
						ordered[intCount+1] = strScoreTemp;
					}
				}
				for (int intCount = 0; intCount < intLength; intCount++) {
					con.println("1. " + ordered[intCount]);
				}
				con.sleep(10000);
				viewscore.close();
			}
			else if (chrChoice == 'h') {
				con.clear();
				con.println("How to play?");
				con.println();
				con.println("Choose a theme you want to play");
				con.println("A word will be given to you but scrambled");
				con.println("Then you will have the length of the word - 4 tries to guess the word correctly");
				con.println("If you get the word right, plus 1 to your highscore until you choose to quit");
				con.sleep(8500);
			}
		}
	}
}
